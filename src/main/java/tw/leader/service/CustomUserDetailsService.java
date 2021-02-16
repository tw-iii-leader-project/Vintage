package tw.leader.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import net.bytebuddy.utility.RandomString;
import tw.leader.controller.CustomUserDetails;
import tw.leader.dao.UserRepository;
import tw.leader.po.User;

@Service
@Transactional
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository uRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private JavaMailSender mailSender;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = uRepo.findByEmail(email);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return new CustomUserDetails(user);
	}

	public User register(User user) {

		if (isEmailUnique(user.getEmail())) {
			String encodedPassword = passwordEncoder.encode(user.getPassword());
			user.setPassword(encodedPassword);
			user.setCreateTime(new Date());
			user.setEnabled(false);

			String randomCode = RandomString.make(64);
			user.setVerificationCode(randomCode);

			return uRepo.save(user);
		}
//		user.setUserMsg("Account has already Exist. Please Choose another one.");
		return user;
	}

	public void sendVerificationEmail(User user, String siteURL)
			throws MessagingException, UnsupportedEncodingException {
		String toAddress = user.getEmail();
		String fromAddress = "zo17751991@gmail.com";
		String senderName = "The Vintage Team";
		String subject = "Please verify your registration";
		String content = "Dear [[name]],<br>" + "Please click the link below to verify your registration:<br>"
				+ "<h3><a href=\"[[URL]]\" target=\"_self\">VERIFY</a></h3>" + "Thank you,<br>" + "The Vintage Team.";

		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setFrom(fromAddress, senderName);
		helper.setTo(toAddress);
		helper.setSubject(subject);

		content = content.replace("[[name]]", user.getUserName());
		String verifyURL = siteURL + "/verify?code=" + user.getVerificationCode();

		content = content.replace("[[URL]]", verifyURL);

		helper.setText(content, true);

		mailSender.send(message);

	}
	
	public boolean isEmailUnique(String email) {
		User existUser = uRepo.findByEmail(email);
		return existUser == null;
	}
	
	public boolean verify(String verificationCode) {
		User user = uRepo.findByVerificationCode(verificationCode);
		
		if (user == null || user.isEnabled()) {
			return false;
		}else {
			uRepo.enabled(user.getUserId());
			
			return true;
		}
	}

}
