package tw.leader.boot.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import tw.leader.boot.domain.*;
import tw.leader.boot.service.*;

/*
 * ALL REST API 
 */
@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private ProductService productService;

	@Autowired
	private ShoppingOrderService shoppingOrderService;

	@Autowired
	private ShopUserService shopUserService;
	
	private String getCurrentShopper() {
		String shopper = shopUserService.getCurrentLoginUser();
		return shopper;
	}
	
	@PostMapping(value="/login",produces = "application/json;charset=utf-8")
	public ApiResultMsg login(@RequestBody Map<String,String> requestMap) {
		String userid=requestMap.get("userid");
		String upwd=requestMap.get("upwd");
		String loginResult= shopUserService.login(userid, upwd);
		if(loginResult==null) {
			return new ApiResultMsg(0,"OK",null);
		}else {
			return new ApiResultMsg(-1,"登入失敗：" + loginResult,null);
		}
		
	}

	@GetMapping(value = "/categorys", produces = "application/json;charset=utf-8")
	public List<GoodsCategory> getAllGoodsCategorys() {
		return productService.getAllGoodsCategoryList();
	}

	@GetMapping(value = "/product/{cateid}", produces = "application/json;charset=utf-8")
	public List<Product> getProductList(@PathVariable(name = "cateid") int categoryid) {
		return productService.getProductListByCategory(categoryid);
	}

	@GetMapping(value = "/product", produces = "application/json;charset=utf-8")
	public List<Product> getProdcutList(@RequestParam(name = "pagesize", required = false) String spageSize,
			@RequestParam(name = "page", required = false) String spageNo) {

		int pageSize = tryparseToInt(spageSize);
		int pageNo = tryparseToInt(spageNo);

		pageSize = pageSize <= 0 ? 10 : pageSize;
		pageNo = pageNo <= 1 ? 1 : pageNo;
		return productService.getProductListByPage(pageSize, pageNo);
	}

	@GetMapping(value = "/productmany", produces = "application/json;charset=utf-8")
	public List<Product> getProductListByMultIds(@RequestBody int[] pIds) {
		return productService.getProductListByMultIds(pIds);
	}

	@PostMapping(value = "/addToShoppingCart", produces = "application/json;charset=utf-8")
	public ApiResultMsg addToShoppingCart(@RequestBody Map<String, Integer> json) {
		int productpId = json.get("productpId");
		int qty = json.get("productqty");
		ApiResultMsg msg = new ApiResultMsg();
		if (productpId <= 0) {
			msg.setCode(101);
			msg.setMsg("商品ID無效");
			return msg;
		}

		String shopper = getCurrentShopper();
		ShoppingCart shoppingCart = new ShoppingCart(0, shopper, productpId, qty, new Date());

		shoppingOrderService.insertShoppingCart(shoppingCart);

		msg.setCode(0);
		msg.setMsg("添加成功！");

		int cartCount = shoppingOrderService.getShoppingCartBuyCount(shopper);
		HashMap<String, Object> data = new HashMap<>();
		data.put("cartCount", cartCount);

		msg.setData(data);

		return msg;
	}

	@GetMapping(value = "/product-{pid}", produces = "application/json;charset=utf-8")
	public Product getProduct(@PathVariable("pid") int productpId) {
		return productService.getProduct(productpId);
	}

	@GetMapping(value = "/cartlist", produces = "application/json;charset=utf-8")
	public List<ShoppingCart> getShoppingCartList() {
		String shopper = getCurrentShopper();
		return shoppingOrderService.getShoppingCartList(shopper);
	}

	@PostMapping(value = "/deletecartitems-{mode}", produces = "application/json;charset=utf-8")
	public ApiResultMsg deleteShoppingCartItems(@PathVariable("mode") String mode,
			@RequestBody(required = false) int[] cartIds) {
		if (mode.equalsIgnoreCase("all")) {
			String shopper = getCurrentShopper();
			shoppingOrderService.clearShoppingCart(shopper);
		} else {
			for (int id : cartIds) {
				shoppingOrderService.deleteShoppingCart(id);
			}
		}

		return new ApiResultMsg(0, "删除成功！", null);
	}

	@PostMapping(value = "/createorder", produces = "application/json;charset=utf-8")
	public ApiResultMsg createShoppingOrder() {

		String shopper = getCurrentShopper();
		ApiResultMsg msg = new ApiResultMsg();
		if (shoppingOrderService.createShoppingOrderByShopper(shopper)) {
			msg.setCode(0);
			msg.setMsg("恭喜你，下單成功！");
		} else {
			msg.setCode(101);
			msg.setMsg("錯誤操作，請重嘗試！");
		}

		return msg;

	}

	@RequestMapping(path = "/orders", produces = "application/json;charset=utf-8", method = RequestMethod.GET) // 等同于@GetMapping
	public List<ShoppingOrder> getShoppingOrderList() {
		String shopper = getCurrentShopper();
		return shoppingOrderService.getShoppingOrderList(shopper);
	}

	@RequestMapping(path = "/orderdetail", produces = "application/json;charset=utf-8", method = RequestMethod.POST) // 等同于@PostMapping
	public ApiResultMsg getShoppingOrderDetail(@RequestBody Map<String, String> requestJosn) {
		String orderId = requestJosn.get("orderId");
		List<ShoppingOrderDetail> orderDetails = shoppingOrderService.getShoppingOrderDetail(tryparseToInt(orderId));
		ApiResultMsg msg = new ApiResultMsg();
		if (orderDetails.size() > 0) {

			int[] productpIds = new int[orderDetails.size()];
			for (int i = 0; i < orderDetails.size(); i++) {
				productpIds[i] = orderDetails.get(i).getGoodsid();
			}

			List<Product> productList = productService.getProductListByMultIds(productpIds);
			HashMap<String, Object> data = new HashMap<>();
			data.put("details", orderDetails);
			data.put("goodss", productList);
			
			msg.setCode(0);
			msg.setData(data);

		} else {
			msg.setCode(101);
			msg.setMsg("訊息無法載入！");
		}
		
		return msg;

	}
	
	//这里示例配置多个URL请求路径
	@PostMapping(path= {"/confirmOrderCompleted","/cfmordercompl"},produces="application/json;charset=utf-8")
	public ApiResultMsg confirmOrderCompleted(@RequestBody Map<String, String> requestJosn) {
		String reqOrderId = requestJosn.get("orderId");
		ApiResultMsg msg=new ApiResultMsg();
		try {
			
			int orderId=tryparseToInt(reqOrderId);
			ShoppingOrder  order= shoppingOrderService.getShoppingOrder(orderId);
			order.setIscompleted(true);
			shoppingOrderService.updateShoppingOrder(order);
			msg.setCode(0);
			msg.setMsg("確認訂單(已收貨)");
		}catch (Exception e) {
			msg.setCode(101);
			msg.setMsg("錯誤訂單：" + e.getMessage());
		}
		
		return msg;
	}
	
	
	@PostMapping(path="/saveproduct",produces="application/json;charset=utf-8",consumes="multipart/form-data")
	public ApiResultMsg saveGoods(@RequestParam("cPhoto") MultipartFile ppic,HttpServletRequest request) {
		ApiResultMsg msg=new ApiResultMsg();
		try
		{
			Product product=new Product();
			product.setpId(tryparseToInt(request.getParameter("pId")));
			product.setpName(request.getParameter("pName"));
			product.setPrice(new BigDecimal(request.getParameter("price")));
			product.setdescription(request.getParameter("description"));
			product.setCategoryId(tryparseToInt(request.getParameter("categoryId")));
			product.setLastEditBy(getCurrentShopper());
			product.setLastEditTime(new Date());
			
			if(product.getpId()<=0) {
				productService.insertProduct(product, ppic);
			} else {
				productService.updateProduct(product, ppic);
			}
			
			msg.setCode(0);
			msg.setMsg("上傳成功！");
			msg.setData(product);
			
		}catch (Exception e) {
			msg.setCode(101);
			msg.setMsg("上傳失敗：" + e.getMessage());
		}
		
		return msg;
		
	}
	
	@GetMapping(path="/delproduct/{pId}",produces="application/json;charset=utf-8")
    public ApiResultMsg deleteProduct(@PathVariable("pId") int productpId) {
        productService.deleteProduct(productpId);
        ApiResultMsg msg=new ApiResultMsg();
        msg.setCode(0);
        msg.setMsg("删除商品成功！");
        
        return msg;
    }
	

	private int tryparseToInt(String str) {
		try {
			return Integer.parseInt(str);
		} catch (Exception e) {
			return -1;
		}
	}

}
