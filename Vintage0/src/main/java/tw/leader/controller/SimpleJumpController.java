package tw.leader.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import tw.leader.po.User;

@Controller
public class SimpleJumpController {
	@GetMapping("")
	public String ViewHomePage() {
		return "index3";
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
		return "index3";
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
