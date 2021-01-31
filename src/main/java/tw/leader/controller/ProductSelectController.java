package tw.leader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.leader.service.ProductService;
import tw.leader.vo.ProductResp;

@Controller
public class ProductSelectController {

	@Autowired
	private ProductService pService;
	
	@PostMapping(value="/panProductSelectData")
	public @ResponseBody String productSelectAll() throws Exception {
		return pService.getProductAll();
	}
	
	@PostMapping(value="/panProductSelectByMain")
	@ResponseBody
	public String productSelectByMain(@RequestBody ProductResp main) throws Exception {
		String p_main = main.getP_main();
		return pService.getProductByMain(p_main);
	}
	
	@PostMapping(value="/panProductSelectByName")
	@ResponseBody
	public String productSelectByName(@RequestBody ProductResp name) throws Exception {
		String p_name = name.getP_name();
		return pService.getProductByName(p_name);
	}
	
	@GetMapping(value="/panProductPageTest")
	public String productJumPageTest(@RequestParam int id,Model m) {
		System.out.println(id);
		m.addAttribute("secretProductId", id);
		return "test";
	}
	
	@GetMapping(value="/panProductPage")
	public String productJumPage(@RequestParam int id,Model m) {
		System.out.println(id);
		m.addAttribute("secretProductId", id);
		return "product";
	}
	
	@GetMapping(value="/panUserPage")
	public String userJumPage(@RequestParam String userName,Model m) {
		System.out.println(userName+"1");
		m.addAttribute("secretUserName",userName);
		return "blog-details";
	}
	
	@PostMapping(value="/panSelectMainByName")
	@ResponseBody
	public String selectMainByName(@RequestBody ProductResp userName) throws Exception {
		String user_acc = userName.getUser_acc();
		System.out.println(user_acc+"2");
		return pService.getMainByUserName(user_acc);
	}
	
	@PostMapping(value="/panProductDetailSelect")
	@ResponseBody
	public String productSelectById(@RequestBody ProductResp id) throws Exception {
		int p_id = id.getP_id();
		return pService.getProductById(p_id);
	}
	
}
