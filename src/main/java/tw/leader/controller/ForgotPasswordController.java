package tw.leader.controller;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import net.bytebuddy.utility.RandomString;
import tw.leader.config.Utility;
import tw.leader.po.User;
import tw.leader.service.CustomUserDetailsService;
import tw.leader.service.UserNotFoundException;

@Controller
public class ForgotPasswordController {
	
	@Autowired
	private CustomUserDetailsService customUserDetailsService;
	
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("/forgot_password")
	public String showForgotPasswordForm(Model m) {
		m.addAttribute("pageTitle", "Forgot Pasword");
		return "forgot_password_form";
	}
	
	@PostMapping("/forgot_password")
	public String processForgotPasswordForm(HttpServletRequest request, Model m) {
		String email = request.getParameter("email");
		String token = RandomString.make(45);
		
		try {
			customUserDetailsService.updateResetPasswordToken(token, email);
			
			String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
			
			System.out.println(resetPasswordLink);
			
			sendEmail(email, resetPasswordLink);
			
			m.addAttribute("message", "We have send a reset password link to your email. Please check.");
			
		} catch (UserNotFoundException e) {
			m.addAttribute("error", e.getMessage());
		} catch (UnsupportedEncodingException | MessagingException e) {
			// TODO Auto-generated catch block
			m.addAttribute("error", "Error while sending email.");
		} 
		
		return "forgot_password_form";
	}
	
	private void sendEmail(String email, String resetPasswordLink) throws UnsupportedEncodingException, MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setFrom("LeaderAwesome@vintage.com", "Vintage Support");
		helper.setTo(email);
		
		String subject = "Here is the link to reset your password";
		
		String content = "<p>Hello,</p>"
				+ "<p>You have requested to reset your password.</p>"
				+ "<p>Click the link below to change your password:</p>"
				+ "<p><a href=\"" + resetPasswordLink + "\">Change my Password</a></p>"
				+ "<p>Ignore This Email if you do remember your password, or you have not made the request.</p>";
		
		helper.setSubject(subject);
		helper.setText(content, true);
		
		mailSender.send(message);
	}
	
	@GetMapping("/reset_password")
	public String showResetPasswordForm(@Param("token") String token, Model m) {
		User user = customUserDetailsService.get(token);
		
		if (user == null) {
			m.addAttribute("title", "Reset your password");
			m.addAttribute("message", "Invalid token");
			
			return "message";
		}
		
		m.addAttribute("token", token);
		m.addAttribute("pageTitle", "Reset Your Password");
		return "reset_password_form";
	}
	
	@PostMapping("/reset_password")
	public String processResetPassword(HttpServletRequest request, Model m) {
		String token = request.getParameter("token");
		String password = request.getParameter("password");
		
		User user = customUserDetailsService.get(token);
		
		if (user == null) {
			m.addAttribute("title", "Reset your password");
			m.addAttribute("message", "Invalid token");
			
			return "message";
		} else {
			customUserDetailsService.updatePassword(user, password);
			m.addAttribute("message", "Password Changed Successfully.");
		}
		
		return "message";
	}
}
