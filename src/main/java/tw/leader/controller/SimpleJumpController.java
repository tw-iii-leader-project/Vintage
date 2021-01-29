package tw.leader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleJumpController {
	
	@GetMapping("/liaohp")
	public String fashiHomePage() {
		return "index.html";
	}
	
	@GetMapping("/liaoshop")
	public String fashiShopPage() {
		return "shop.html";
	}
	
	@GetMapping("/liaoproduct")
	public String productPage() {
		return "product.html";
	}
	
	@GetMapping("/contact")
	public String contactPage() {
		return "contact";
	}
	

}

