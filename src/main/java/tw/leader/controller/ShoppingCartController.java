package tw.leader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.leader.service.ShoppingCartService;
import tw.leader.vo.ShoppingCartResp;

@Controller
public class ShoppingCartController {

	@Autowired
	private ShoppingCartService sCService;
	
	@PostMapping(value="/")
	@ResponseBody
	public ShoppingCartResp insertProduct(@) {
		
	}
}
