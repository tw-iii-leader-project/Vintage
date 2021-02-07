package tw.leader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.configurers.SecurityContextConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import tw.leader.dao.UserRepository;
import tw.leader.po.User;

@Controller
public class AppController {
	
	@Autowired
	private UserRepository uRepo;
	
	
	
	@PostMapping("/process_register")
	public String processRegister(User user) {
		String roles = "ROLES_USER";
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		user.setRoles(roles);
		uRepo.save(user);
		return "register_success";
	}
	
	@GetMapping("/list_users")
	public String viewUsersList(Model m) {
		List<User> listUsers = uRepo.findAll();
		m.addAttribute("listUsers", listUsers);
		return "users";
	}
	
	@GetMapping("/testpage1")
	public String testP1(Model m) {
		String user = GetCurrentUserAccount();
		m.addAttribute("user", user);
		return "testPage1";
	}
	
	@GetMapping("/testpage2")
	public String testP2(Model m) {
		String user = GetCurrentUserAccount();
		m.addAttribute("user", user);
		return "testPage2";
	}
		
	
	@PostMapping("/resetPassword")
	public String getPassword(
			@RequestParam("email") String email,
			@RequestParam("password") String secondPwd,
			Model m) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		if(!uRepo.findByEmail(email).getEmail().isEmpty()) {
			User user = uRepo.findByEmail(email);
			user.setPassword(encoder.encode(secondPwd));
			uRepo.save(user);
			return "testPage1";
		}else {
			m.addAttribute("errors", "NO EMAIL EXIST!! PLEASE CHECK AGAIN.");
			return "resetPassword";
		}
	}
		
	
	
	
	@GetMapping("/registerProcess")
	public String registerProcess() {
		return "register_success";
	}
	
	
	
//	@GetMapping("/userInfoUpdate")
//	public String userInfoUpdate(User user, @RequestParam("userBirthday")String userBirthday) {
//		user.setBirthday(userBirthday);
//		uRepo.save(user);
//		return "index3";
//	}
		
	public String GetCurrentUserAccount() {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		return userName;
		// this method is for getting current user account which has login.
	}
}
