package tw.leader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.leader.service.ShoppingCartService;
import tw.leader.vo.ShoppingCartResp;

@Controller
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService sCService;
	
	@PostMapping(value="/panfindShoppingProductQuantity")
	@ResponseBody
	public int selectShoppingProductQuantity(@RequestBody ShoppingCartResp userData) {
		String email = userData.getEmail();
		return sCService.getshoppingQuantity(email);
	}
	
	@PostMapping(value="/addshoppingCart")
	@ResponseBody
	public String insertShoppingProduct(@RequestBody ShoppingCartResp productData) {
		String email = productData.getEmail();
		int pId = productData.getpId();
		String pName = productData.getpName();
		int price = productData.getPrice();
		int amount = productData.getAmount();
		String cPhoto = productData.getcPhoto();
		ShoppingCartResp result = sCService.insertProduct(email, pId, pName, price, amount, cPhoto);
		String insertMsg = result.getMessage();
		System.out.println(insertMsg);
		return insertMsg;
	}
	
	@PostMapping(value="/panSelectShoppingCart")
	@ResponseBody
	public String selectShoppingProduct(@RequestBody ShoppingCartResp userData) throws Exception {
		String email = userData.getEmail();
		return sCService.selectshoppingCart(email);
	}
	
	@PostMapping(value="/panSelectShoppingCartPrice")
	@ResponseBody
	public int selectShoppingPrice(@RequestBody ShoppingCartResp userData) {
		String email = userData.getEmail();
		return sCService.getShoppingCartTotalPrice(email);
	}
	
	@PostMapping(value="/panDeleteShoppingProduct")
	@ResponseBody
	public String deleteShoppingProduct(@RequestBody ShoppingCartResp cartData) {
		int cartId = cartData.getCartId();
		ShoppingCartResp result = sCService.deleteProduct(cartId);
		String deleteMsg = result.getMessage();
		System.out.println(deleteMsg);
		return deleteMsg;
	}
	
	//@PostMapping(value="/")
	public void updateProductAmount(@RequestBody ShoppingCartResp cartData) {
		int amount = cartData.getAmount();
		int cartId = cartData.getCartId();
		sCService.updateshoppingCart(amount, cartId);
	}
	
	@PostMapping(value="/panShoppingCartCheckout")
	@ResponseBody
	public void checkout(@RequestBody ShoppingCartResp cartData) {
		String email = cartData.getEmail();
		sCService.payAndAddOrder(email);
	}
	
	
	
}

