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
	private ProductServiceb productService;

	@GetMapping(value = "/categorys", produces = "application/json;charset=utf-8")
	public List<GoodsCategory> getAllGoodsCategorys() {
		return productService.getAllGoodsCategoryList();
	}

	@GetMapping(value = "/product/{cateid}", produces = "application/json;charset=utf-8")
	public List<Productb> getProductList(@PathVariable(name = "cateid") int categoryid) {
		return productService.getProductListByCategory(categoryid);
	}

	@GetMapping(value = "/product", produces = "application/json;charset=utf-8")
	public List<Productb> getProdcutList(@RequestParam(name = "pagesize", required = false) String spageSize,
			@RequestParam(name = "page", required = false) String spageNo) {

		int pageSize = tryparseToInt(spageSize);
		int pageNo = tryparseToInt(spageNo);

		pageSize = pageSize <= 0 ? 10 : pageSize;
		pageNo = pageNo <= 1 ? 1 : pageNo;
		return productService.getProductListByPage(pageSize, pageNo);
	}

	@GetMapping(value = "/productmany", produces = "application/json;charset=utf-8")
	public List<Productb> getProductListByMultIds(@RequestBody int[] pIds) {
		return productService.getProductListByMultIds(pIds);
	}

	@GetMapping(value = "/product-{pid}", produces = "application/json;charset=utf-8")
	public Productb getProduct(@PathVariable("pid") int productpId) {
		return productService.getProduct(productpId);
	}
	
	@PostMapping(path="/saveproduct",produces="application/json;charset=utf-8",consumes="multipart/form-data")
	public ApiResultMsg saveProduct(@RequestParam("cPhoto") MultipartFile ppic,HttpServletRequest request) {
		ApiResultMsg msg=new ApiResultMsg();
		try
		{
			Productb product=new Productb();
			product.setpId(tryparseToInt(request.getParameter("pId")));
			product.setpName(request.getParameter("pName"));
			product.setpMain(request.getParameter("pMain"));
			product.setpDetail(request.getParameter("pDetail"));
			product.setPrice(tryparseToInt(request.getParameter("price")));
			product.setInvantory(tryparseToInt(request.getParameter("invantory")));
			product.setpSize(request.getParameter("pSize"));
			product.setDescription(request.getParameter("description"));
			product.setsDescription(request.getParameter("sDescription"));
			product.setEmail(request.getParameter("email"));
			product.setUserName(request.getParameter("userName"));
			product.setCategoryId(tryparseToInt(request.getParameter("categoryId")));
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
