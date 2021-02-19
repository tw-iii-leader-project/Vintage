package tw.leader.controller;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import tw.leader.dao.UserRepository;
import tw.leader.dao.userArticleDao;
import tw.leader.po.User;
import tw.leader.po.userArticle;

@Controller
public class blogController {
	
	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private userArticleDao aRepo;
	
	@PostMapping(value = "/userPicUpdate")
	public String userInfoUpdate(
			@RequestParam("mainImage") MultipartFile mainMultipartFile,
			@RequestParam("extraImage") MultipartFile[] extraMultipartFiles
			) throws IOException{
		String currentUser = GetCurrentUserAccount();
		userArticle user = aRepo.findByEmail(currentUser);
		
		if (user == null) {
			user = new userArticle();
			user.setEmail(currentUser);
		}
		
		String mainImageName = StringUtils.cleanPath(mainMultipartFile.getOriginalFilename());
		mainImageName = user.getArticleId() + mainImageName;
		
		user.setUserPicMain(mainImageName);
		
		int count = 0;
		for (MultipartFile extraMultipart : extraMultipartFiles) {
			String extraImageName = StringUtils.cleanPath(extraMultipart.getOriginalFilename());
			extraImageName = user.getArticleId() + extraImageName;
			
			if (count == 0) {
				user.setUserPic1(extraImageName);
			}
			
			if (count == 1) {
				user.setUserPic2(extraImageName);
			}
			
			if (count == 2) {
				user.setUserPic3(extraImageName);
			}
				
			count++;
		}
		
		userArticle saveUser = aRepo.save(user);
				
		String uploadDir = "C:\\Try\\Git\\Vintage5P02192\\src\\main\\resources\\static\\img\\userArticlePic";
		
		String fileNameMain = StringUtils.cleanPath(mainMultipartFile.getOriginalFilename());
		fileNameMain = user.getArticleId() + fileNameMain;
		
		FileUploadUtil.saveFile(uploadDir, mainMultipartFile, fileNameMain);
		

		for (MultipartFile extraMultipart : extraMultipartFiles) {
			String fileName = StringUtils.cleanPath(extraMultipart.getOriginalFilename());
			fileName = user.getArticleId() + fileName;
			
			FileUploadUtil.saveFile(uploadDir, extraMultipart, fileName);
		}
		
		return "updatePic_success";
	}
	
	public String GetCurrentUserAccount() {
		String userName = SecurityContextHolder.getContext().getAuthentication().getName();
		return userName;
		// this method is for getting current user account which has login.
	}
}
