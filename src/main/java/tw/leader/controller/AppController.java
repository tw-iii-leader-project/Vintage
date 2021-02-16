package tw.leader.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.configurers.SecurityContextConfigurer;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.leader.config.Utility;
import tw.leader.dao.FindUserInfoDao;

import tw.leader.dao.UserRepository;
import tw.leader.po.Product;
import tw.leader.po.User;
import tw.leader.service.CustomUserDetailsService;
import tw.leader.vo.UserResp;

import net.bytebuddy.utility.RandomString;

@Controller
public class AppController {
	
	@Autowired
	private UserRepository uRepo;
	@Autowired
	private ObjectMapper objectMapper;
	@Autowired
	private FindUserInfoDao fDao;
	
	@Autowired
	private CustomUserDetailsService service;
//	@Autowired
//	private ProductInsertRepository pInsertRepository;
	
	
	
//	@PostMapping("/process_register")
//	public String processRegister(User user) {
//		String roles = "ROLES_USER";
//		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//		String encodedPassword = encoder.encode(user.getPassword());
//		user.setPassword(encodedPassword);
//		user.setRoles(roles);
//		uRepo.save(user);
//		return "register_success";
//	}
	
	@PostMapping("/process_register")
	public String processRegister(User user, Model m, HttpServletRequest request) 
	throws UnsupportedEncodingException, MessagingException{
		String roles = "ROLES_USER";
		user.setRoles(roles);
				
		service.register(user);
		String siteURL = Utility.getSiteURL(request);
		service.sendVerificationEmail(user, siteURL);
		
		return "register_success";
	}
	
	@GetMapping("/verify")
	public String verifyAccount(@Param("code") String code, Model m) {
		boolean verified = service.verify(code);
		
		String pageTitle = verified ? "Verification Succeeded" : "Verification Failed";
		m.addAttribute("pageTitle", pageTitle);
		return (verified ? "verify_success" : "verify_failed");
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
			return "index";
		}else {
			m.addAttribute("errors", "NO EMAIL EXIST!! PLEASE CHECK AGAIN.");
			return "resetPassword";
		}
	}
		
	
	
	
	@GetMapping("/registerProcess")
	public String registerProcess() {
		return "register_success";
	}
	
	@PostMapping(value="/panselectUserInfo.user")
	@ResponseBody
	public String selectUserInfoUser(@RequestBody UserResp userData) throws Exception {
		String email = userData.getEmail();
		List<User> uList = fDao.findAllDataByEmail(email);
		String uJson = objectMapper.writeValueAsString(uList);
		System.out.println(uJson);
		return uJson;
	}
	
	
	
	@PostMapping("/userInfoUpdate")
	public String userInfoUpdate(@RequestParam("userBirthday")String userBirthday, @RequestParam("userPhone") String userPhone, @RequestParam("gender") String gender) {
		String currentUser = GetCurrentUserAccount();
		String newRole = "ROLE_SELL";
		User user = uRepo.findByEmail(currentUser);
		user.setEmail(currentUser);
		user.setBirthday(userBirthday);
		user.setPhone(userPhone);
		user.setGender(gender);
		user.setRoles(newRole);
		uRepo.save(user);
		
		return "update_success";
	}
	
	@PostMapping("/userPicUpload")
	public ResponseEntity<?> handleFileUpload(@RequestParam("file") MultipartFile file) {
		String filemName = file.getOriginalFilename();
		filemName = "user_"+filemName;
		try {
			file.transferTo(new File("C:\\SpringBoot\\eclipse\\Workspace\\Git\\VintageTest\\src\\main\\resources\\static\\img\\userPic\\" + filemName));
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		return ResponseEntity.ok("File uploaded successfully!!");
	}
	
//	@PostMapping("/process_insert")
//	@ResponseBody
//	public String processInsert(@RequestBody Product product) {
//				
//		pInsertRepository.save(product);
//		
//		return "insert_success";
//	}
//	
//	@PostMapping("/process_update")
//	@ResponseBody
//	public String processUpdate(@RequestBody Product product) {
//		int id = product.getpId();
//		Product p = pInsertRepository.findById(id);
//		p.setpName(product.getpName());
//		p.setPrice(product.getPrice());
//		p.setcPhoto(product.getcPhoto());
//		p.setDescription(product.getDescription());
//		p.setsDescription(product.getsDescription());
//		p.setInvantory(product.getInvantory());
//		p.setpMain(product.getpMain());
//		p.setpDetail(product.getpDetail());
//		p.setpSize(product.getpSize());
//		p.setUserName(product.getUserName());
//		pInsertRepository.save(p);
//		
//		return "update_success";
//	}
	
		
	public String GetCurrentUserAccount() {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		return userName;
		// this method is for getting current user account which has login.
	}
}
