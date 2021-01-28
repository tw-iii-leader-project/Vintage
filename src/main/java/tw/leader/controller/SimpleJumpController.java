package tw.leader.controller;

import java.io.File;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class SimpleJumpController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@GetMapping("/liaoIndex")
	public String fashiHomePage() {
		return "index.html";
	}
	
	@GetMapping("/liaoShop")
	public String fashiShopPage() {
		return "shop.html";
	}
	
	@GetMapping("/liaoProduct")
	public String productPage() {
		return "product.html";
	}
	
	@GetMapping("/liaoBlog")
	public String blogPage() {
		return "blog";
	}
	
	@GetMapping("/liaoBlogDetails")
	public String blogDetailsPage() {
		return "blog-details";
	}
	
	@GetMapping("/liaoCheckOut")
	public String checkOutPage() {
		return "check-out";
	}
	
	@GetMapping("/liaoContact")
	public String contactPage() {
		return "contact";
	}
	
	@GetMapping("/liaoFaq")
	public String faqPage() {
		return "faq";
	}

	@GetMapping("/liaoLogin")
	public String loginPage() {
		return "login"; 
	}
	
	@GetMapping("/liaoMain")
	public String mainPage() {
		return "main";
	}
	
	@GetMapping("/liaoRegister")
	public String registerPage() {
		return "register";
	}
	
	@GetMapping("/liaoShoppingCart")
	public String shoppingCartPage() {
		return "shopping-cart";
	}
	
	@GetMapping("/liaoUploader")
	public String uploaderPage() {
		return "uploader";
	}
}

