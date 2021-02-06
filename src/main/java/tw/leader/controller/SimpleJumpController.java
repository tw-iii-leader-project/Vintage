package tw.leader.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SimpleJumpController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@GetMapping("/index")
	public String fashiHomePage() {
		return "index.html";
	}
	
	@GetMapping("/shop")
	public String fashiShopPage() {
		return "shop.html";
	}
	
	@GetMapping("/product")
	public String productPage() {
		return "product.html";
	}
	
	@GetMapping("/blog")
	public String blogPage() {
		return "blog";
	}
	
	@GetMapping("/blogDetails")
	public String blogDetailsPage() {
		return "blog-details";
	}
	
	@GetMapping("/checkOut")
	public String checkOutPage() {
		return "check-out";
	}
	
	@GetMapping("/contact")
	public String contactPage() {
		return "contact";
	}
	
	@GetMapping("/faq")
	public String faqPage() {
		return "faq";
	}

	@GetMapping("/login")
	public String loginPage() {
		return "login"; 
	}
	
	@GetMapping("/main")
	public String mainPage() {
		return "main";
	}
	
	@GetMapping("/register")
	public String registerPage() {
		return "register";
	}
	
	@GetMapping("/shoppingCart")
	public String shoppingCartPage() {
		return "shopping-cart";
	}
	
	@GetMapping("/uploader")
	public String uploaderPage() {
		return "uploader";
	}
}

