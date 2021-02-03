package tw.leader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.leader.service.ProductService;
import tw.leader.vo.ProductResp;

/**
 * @author iii
 *
 */
@Controller
public class ProductSelectController {

	@Autowired
	private ProductService pService;
	
	/*
	 * ***所有頁面皆可呼叫***查詢全部商品
	 * */
	@PostMapping(value="/panProductSelectAll")
	public @ResponseBody String productSelectAll() throws Exception {
		return pService.getProductAll();
	}
	
	/*
	 * ***所有頁面皆可呼叫***藉由類別來查詢商品
	 * */
	@PostMapping(value="/panProductSelectByMain")
	@ResponseBody
	public String productSelectByMain(@RequestBody ProductResp main) throws Exception {
		String p_main = main.getP_main();
		return pService.getProductByMain(p_main);
	}
	
	/*
	 * ***所有頁面皆可呼叫***藉由商品名稱來查詢(不分大小寫)(相識關鍵字)皆可搜尋
	 * */
	@PostMapping(value="/panProductSelectByName")
	@ResponseBody
	public String productSelectByName(@RequestBody ProductResp name) throws Exception {
		String p_name = name.getP_name();
		return pService.getProductByName(p_name);
	}
	
	/*
	 * ***商品連結呼叫***帶商品ID進商品頁面
	 * */
	@GetMapping(value="/panProductPage")
	public String productJumPage(@RequestParam int id,Model m) {
		System.out.println(id);
		m.addAttribute("secretProductId", id);
		return "product";
	}
	
	/*
	 * ***賣家連結呼叫***帶賣家ID進賣家頁面
	 * */
	@GetMapping(value="/panUserPage")
	public String userJumPage(@RequestParam String userName,Model m) {
		m.addAttribute("secretUserName",userName);
		return "blog-details";
	}

	/*
	 * ***Product頁面載入時呼叫***載入此商品的所有資料
	 * */
	@PostMapping(value="/panProductDetailSelect")
	@ResponseBody
	public String productSelectById(@RequestBody ProductResp id) throws Exception {
		int p_id = id.getP_id();
		return pService.getProductById(p_id);
	}
	
	/*
	 * ***userPage頁面載入時呼叫***載入此賣家的所有商品
	 * */
	@PostMapping(value="/panSelectMainByName")
	@ResponseBody
	public String selectProductByName(@RequestBody ProductResp userName) throws Exception {
		String user_acc = userName.getUser_acc();
		return pService.getMainByUserName(user_acc);
	}
	
	/*
	 * ***userPage頁面呼叫***利用商品類別來載入此賣家商品
	 * */
	@PostMapping(value="/panSelectProductByMainAndName")
	@ResponseBody
	public String selectProductByMainAndName(@RequestBody ProductResp userData) throws Exception {
		String p_main = userData.getP_main();
		String user_acc = userData.getUser_acc();
		return pService.getProductByMainAndName(p_main, user_acc);
	}
	
	
	
	/*-------------------------------------------------------------
	 * Test controller*/
	
	@GetMapping(value="/panTestPage")
	public String testUserJumPage() {
		return "test";
	}
	
//	@GetMapping(value="/panProductPageTest")
//	public String productJumPageTest(@RequestParam int id,Model m) {
//		System.out.println(id);
//		m.addAttribute("secretProductId", id);
//		return "test";
//	}
	
//	@GetMapping(value="/panUserPage")
//	public String testUserJumPage(@RequestParam String userName,Model m) {
//		m.addAttribute("secretUserName",userName);
//		return "test";
//	}
	
	@PostMapping(value="/panTestSelectMainByName")
	@ResponseBody
	public String testSelectProductByName(@RequestBody ProductResp userName) throws Exception {
		String user_acc = userName.getUser_acc();
		return pService.getMainByUserName(user_acc);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
