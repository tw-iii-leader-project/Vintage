package tw.leader.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
	@Autowired
	private ObjectMapper objectMapper ;
	
	/*
	 * ***所有頁面呼叫***查詢所有商品之頁面資訊
	 * */
	@PostMapping(value="/panFindAllProductPage")
	@ResponseBody
	public String selectAllProduct() throws Exception {
		return pService.getAllProductPageMessages();
	}
	
	/*
	 * ***shop頁面呼叫***查詢所有分類商品之頁面資訊
	 * */
	@PostMapping(value="/panFindAllProductMainPage")
	@ResponseBody
	public String selectAllProductByMain(@RequestBody ProductResp userData) throws Exception {
		String pMain = userData.getpMain();
		return pService.getAllProductPageMessagesByMain(pMain);
	}
	
	/*
	 * ***所有頁面皆可呼叫***查詢全部商品
	 * */
	@PostMapping(value="/panProductSelectAll")
	public @ResponseBody String productSelectAll() throws Exception {
		return pService.getProductAllLoad();
	}
	
	/*
	 * ***所有頁面皆可呼叫***查詢全部商品+分頁查詢
	 * */
	@PostMapping(value="/panProductSelectAll.page")
	@ResponseBody
	public String productSelectAllP(@RequestBody Map<String,String> pMap) throws Exception {
		int page = 0;
		if(pMap.containsKey("page")) {
			page = Integer.parseInt(pMap.get("page"));
		}
		return pService.getProductAllP(page);
	}
	
	
	/*
	 * ***所有頁面皆可呼叫***藉由類別來查詢商品
	 * */
	@PostMapping(value="/panProductSelectByMain")
	@ResponseBody
	public String productSelectByMain(@RequestBody ProductResp main) throws Exception {
		String pMain = main.getpMain();
		return pService.getProductByMain(pMain);
	}
	
	@PostMapping(value="/panProductSelectByMain.page")
	@ResponseBody
	public String productSelectByMainP(@RequestBody Map<String,String> pMap) throws Exception {
		String pMain = null;
		int page = 0;
		if(pMap.containsKey("pMain")) {
			pMain = pMap.get("pMain");
		}
		if(pMap.containsKey("page")) {
			page = Integer.parseInt(pMap.get("page"));
		}
		return pService.getProductByMainP(pMain,page);
	}
	
	/*
	 * ***所有頁面皆可呼叫***藉由商品名稱來查詢(不分大小寫)(相識關鍵字)皆可搜尋
	 * */
	@PostMapping(value="/panProductSelectByName")
	@ResponseBody
	public String productSelectByName(@RequestBody ProductResp data) throws Exception {
		String pName = data.getpName();
		return pService.getProductByName(pName);
	}
	
	/*
	 * ***商品連結呼叫***帶商品ID進商品頁面
	 * */
	@GetMapping(value="/panProductPage")
	public String productJumPage(@RequestParam int id,Model m) {
		System.out.println(id);
		String user = GetCurrentUserAccount();
		m.addAttribute("user", user);
		m.addAttribute("secretProductId", id);
		return "product";
	}
	
	/*
	 * ***賣家連結呼叫***帶賣家ID進賣家頁面
	 * */
	@GetMapping(value="/panUserPage")
	public String userJumPage(@RequestParam String email,Model m) {
		String user = GetCurrentUserAccount();
		m.addAttribute("user", user);
		m.addAttribute("secretUserEmail",email);
		return "blog-details";
	}
	
	/*
	 * ***全部頁面皆可呼叫***代賣家進自己頁面
	 * */
	@GetMapping(value="/panUserControlPage")
	public String usercontrolPage(@RequestParam String email,Model m) {
		m.addAttribute("user",email);
		System.out.println(email);
		return "blog-details";
	}
	
	/*
	 * ***全部頁面皆可呼叫***代商品類別值進shop頁
	 * */
	@GetMapping(value="/panAllPageMainLink")
	public String allPageMainLink(@RequestParam String pMain,Model m) {
		m.addAttribute("allPageMainValue",pMain);
		System.out.println(pMain);
		return "shop";
	}
	
	/*
	 * ***全部頁面皆可呼叫***代商品名稱進shop頁
	 * */
	@GetMapping(value="/panAllPageFormLink")
	public String allPageFormLink(@RequestParam String pName,Model m) {
		m.addAttribute("allPageFormValue",pName);
		System.out.println(pName);
		return "shop";
	}

	/*
	 * ***Product頁面載入時呼叫***載入此商品的所有資料
	 * */
	@PostMapping(value="/panProductDetailSelect")
	@ResponseBody
	public String productSelectById(@RequestBody ProductResp id) throws Exception {
		int p_id = id.getpId();
		return pService.getProductById(p_id);
	}
	
	/*
	 * ***userPage頁面載入時呼叫***載入此賣家所有商品分類
	 * */
	@PostMapping(value="/panSelectMainByUserName")
	@ResponseBody
	public String selectProductMainByUserName(@RequestBody ProductResp userData) throws Exception {
		String email = userData.getEmail();
		return pService.getProductMainByUserName(email);
	}
	
	/*
	 * ***userPage頁面載入時呼叫***載入此賣家的所有商品
	 * */
	@PostMapping(value="/panSelectProductByUserName")
	@ResponseBody
	public String selectProductByUserName(@RequestBody ProductResp userData) throws Exception {
		String email = userData.getEmail();
		return pService.getProductTotalLoad(email);
	}
	
	/*
	 * ***userPage頁面呼叫***換頁查詢此賣家所有商品
	 * */
	@PostMapping(value="/panSelectProductByUserName.page")
	@ResponseBody
	public String selectProductByUserNameP(@RequestBody Map<String,String> pMap) throws Exception {
		String email = null;
		int page = 0;
		if(pMap.containsKey("email")) {
			email = pMap.get("email");
		}
		if(pMap.containsKey("page")) {
			page = Integer.parseInt(pMap.get("page"));
		}
		return pService.getProductTotal(email, page);
	}
	
	/*
	 * ***userPage頁面呼叫***利用商品類別來載入此賣家商品
	 * */
	@PostMapping(value="/panSelectProductByMainAndName")
	@ResponseBody
	public String selectProductByMainAndName(@RequestBody ProductResp userData) throws Exception {
		String email = userData.getEmail();
		String pMain = userData.getpMain();
		return pService.getProductByMainAndName(email,pMain);
	}
	
	@PostMapping(value="/panSelectProductByMainAndName.page")
	public String selectProductByMainAndNameP(@RequestBody Map<String,String> pMap) throws Exception {
		String email = null;
		String pMain = null;
		int page = 0;
		if(pMap.containsKey("email")) {
			email = pMap.get("email");
		}
		if(pMap.containsKey("pMain")) {
			pMain = pMap.get("pMain");
		}
		if(pMap.containsKey("page")) {
			page = Integer.parseInt(pMap.get("page"));
		}
		
		return pService.getProductByMainAndNameP(email, pMain, page);
	}
	/*
	 * ***userPage頁面呼叫***查詢此賣家所有商品之頁面資訊
	 * */
	@PostMapping(value="/panFindProductPage")
	@ResponseBody
	public String selectProductByName(@RequestBody ProductResp userData) throws Exception {
		String email = userData.getEmail();
		return pService.getPageMessages(email);
	}
	
	/*
	 * ***userPage頁面呼叫***查詢賣家分類商品之頁面資訊
	 * */
	@PostMapping(value="/panFindProductMainPage")
	@ResponseBody
	public String selectProductPageByMainAndName(@RequestBody ProductResp userData) throws Exception {
		String email = userData.getEmail();
		String pMain = userData.getpMain();
		return pService.getPageMessageByMain(email, pMain);
	}
	
	public String GetCurrentUserAccount() {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		return userName;
		// this method is for getting current user account which has login.
	}
	
	
	/*
	 * ------------------------------------------------------------
	 * 		IndexAndProductPage
	 * */
	
	@PostMapping(value="/panIndexProduct")
	@ResponseBody
	public String findIndexProduct() throws Exception {
		return pService.findIndexProduct();
	}
	
	/*-------------------------------------------------------------
	 * Test controller*/
	
	@GetMapping(value="/panTestPage")
	public String testUserJumPage() {
		return "test";
	}
	
	@PostMapping(value="/panTestJsonData")
	@ResponseBody
	public String panTestJsonData() throws Exception {
		List<Map<String,String>> tList = new ArrayList<>();
		Map<String,String> tMap1 = new HashMap<>();
		Map<String,String> tMap2 = new HashMap<>();
		tMap1.put("name", "GawrGura");
		tMap1.put("msg","AAAAAAAAAAAAAAA");
		tList.add(tMap1);
		tMap2.put("name", "Ina");
		tMap2.put("msg","inaina~i~na~");
		tList.add(tMap2);
		System.out.println(tList);
		String tJson = objectMapper.writeValueAsString(tList);
		System.out.println(tJson);
		return tJson;
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
	
//	@PostMapping(value="/panTestSelectMainByName")
//	@ResponseBody
//	public String testSelectProductByName(@RequestBody ProductResp userName) throws Exception {
//		String user_acc = userName.getUser_acc();
//		return pService.getMainByUserName(user_acc);
//	}
	
//	@GetMapping(value="/panTestSelectProductAll")
//	public String testSelectProductAll() throws Exception {
//		int page = 0;
//		int pageSize = 8;
//		String user_acc = "GawrGura";
//		System.out.println(page+pageSize+user_acc);
//		String pJson = pService.getPageMessages(user_acc,pageSize,page);
//		System.out.println(pJson);
//		return "test";
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
