package tw.leader.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tw.leader.po.User;

@Controller
public class SimpleJumpController {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	@GetMapping("")
	public String ViewHomePage() {
		return "index";
	}
	
	@GetMapping("/shopPage")
	public String fashiShopPage() {
		return "shop";
	}
	
	@GetMapping("/product")
	public String productPage() {
		return "product";
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
	
	@GetMapping("/shoppingCart")
	public String shoppingCartPage() {
		return "shopping-cart";
	}
	
	@GetMapping("/uploader")
	public String uploaderPage() {
		return "uploader";
	}
	
	
	@GetMapping("/registerNow")
	public String toRegister(Model m) {
		m.addAttribute("users", new User());
		return "register3";
	}
	
	@GetMapping("/forgetPassword")
	public String forgetPassword() {
		return "resetPassword";
	}
	
	@GetMapping("/loginPage")
	public String viewLoginPage() {
		return "login3";
	}
	
	@GetMapping("/toHomePage")
	public String viewHomePage(Model m) {
		String user = GetCurrentUserAccount();
		m.addAttribute("user", user);
		return "index";
	}
	
	@GetMapping("/personalInfo")
	public String viewPersonalInfo() {
		return "personalInfo";
	}
	
	@GetMapping("/toUserInfoDetail")
	public String toUserInfoDetail(Model m) {
		String user = GetCurrentUserAccount();
		m.addAttribute("user", user);
		return "UserInfoDetail";
	}
	
	@GetMapping("/toActivity")
	public String viewActivityPage(Model m) {
//		String user = GetCurrentUserAccount();
//		m.addAttribute("user", user);
		return "Activity";
	}
	
	public String GetCurrentUserAccount() {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		return userName;
		// this method is for getting current user account which has login.
	}
}

