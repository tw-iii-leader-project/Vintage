package tw.leader.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
	 * ***userPage頁面載入時呼叫***載入此賣家所有商品分類
	 * */
	@PostMapping(value="/panSelectMainByUserName")
	@ResponseBody
	public String selectProductMainByUserName(@RequestBody ProductResp userName) throws Exception {
		String user_acc = userName.getUser_acc();
		return pService.getProductMainByUserName(user_acc);
	}
	
	/*
	 * ***userPage頁面載入時呼叫***載入此賣家的所有商品
	 * */
	@PostMapping(value="/panSelectProductByUserName")
	@ResponseBody
	public String selectProductByUserName(@RequestBody ProductResp userName) throws Exception {
		String user_acc = userName.getUser_acc();
		return pService.getProductTotalLoad(user_acc);
	}
	
	/*
	 * ***userPage頁面呼叫***換頁查詢此賣家所有商品
	 * */
	@PostMapping(value="/panSelectProductByUserName.page")
	@ResponseBody
	public String selectProductByUserNameP(@RequestBody Map<String,String> pMap) throws Exception {
		String user_acc = null;
		int page = 0;
		if(pMap.containsKey("user_acc")) {
			user_acc = pMap.get("user_acc");
		}
		if(pMap.containsKey("page")) {
			page = Integer.parseInt(pMap.get("page"));
		}
		return pService.getProductTotal(user_acc, page);
	}
	
	/*
	 * ***userPage頁面呼叫***利用商品類別來載入此賣家商品
	 * */
	@PostMapping(value="/panSelectProductByMainAndName")
	@ResponseBody
	public String selectProductByMainAndName(@RequestBody ProductResp userData) throws Exception {
		String user_acc = userData.getUser_acc();
		String p_main = userData.getP_main();
		return pService.getProductByMainAndName(user_acc,p_main);
	}
	
	@PostMapping(value="/panSelectProductByMainAndName.page")
	public String selectProductByMainAndNameP(@RequestBody Map<String,String> pMap) throws Exception {
		String user_acc = null;
		String p_main = null;
		int page = 0;
		if(pMap.containsKey("user_acc")) {
			user_acc = pMap.get("user_acc");
		}
		if(pMap.containsKey("p_main")) {
			p_main = pMap.get("p_main");
		}
		if(pMap.containsKey("page")) {
			page = Integer.parseInt(pMap.get("page"));
		}
		
		return pService.getProductByMainAndNameP(user_acc, p_main, page);
	}
	/*
	 * ***userPage頁面呼叫***查詢此賣家所有商品之頁面資訊
	 * */
	@PostMapping(value="/panFindProductPage")
	@ResponseBody
	public String selectProductByName(@RequestBody ProductResp userData) throws Exception {
		String user_acc = userData.getUser_acc();
		return pService.getPageMessages(user_acc);
	}
	
	/*
	 * ***userPage頁面呼叫***查詢賣家分類商品之頁面資訊
	 * */
	@PostMapping(value="/panFindProductMainPage")
	@ResponseBody
	public String selectProductPageByMainAndName(@RequestBody ProductResp userData) throws Exception {
		String user_acc = userData.getUser_acc();
		String p_main = userData.getP_main();
		return pService.getPageMessageByMain(user_acc, p_main);
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
