package tw.leader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleJumpController {
	
	@GetMapping("/index")
	public String homePage() {
		return "index";
	}
	
	@GetMapping("/shop")
	public String shopPage() {
		return "shop";
	}
	
	@GetMapping("/blog")
	public String blogPage() {
		return "blog";
	}
	
	@GetMapping("/contact")
	public String contactPage() {
		return "contact";
	}
	
	@GetMapping("/blogDetails")
	public String blogDetailsPage() {
		return "blogDetails";
	}
	
	@GetMapping("/shoppingCart")
	public String shoppingCartPage() {
		return "shoppingCart";
	}
	
	@GetMapping("/checkout")
	public String checkoutPage() {
		return "checkout";
	}
	
	@GetMapping("/faq")
	public String faqPage() {
		return "faq";
	}
	
	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}
	
	@GetMapping("/Login")
	public String loginPage() {
		return "Login";
	}
	
	@GetMapping("/product")
	public String productPage() {
		return "product";
	}
	
	

}

