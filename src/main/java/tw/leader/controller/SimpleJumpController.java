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
	
	@GetMapping("/liaohp")
	public String fashiHomePage() {
		return "index.html";
	}
	
	@GetMapping("/liaoshop")
	public String fashiShopPage() {
		return "shop.html";
	}
	
	@GetMapping("/liaoproduct")
	public String productPage() {
		return "product.html";
	}
	

}

