package tw.leader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.leader.service.ProductService;
import tw.leader.vo.ProductResp;

@Controller
public class ProductSelectController {

	@Autowired
	private ProductService pService;
	
	@PostMapping(value="/panProductSelectData")
	public @ResponseBody String productSelectAll() throws Exception {
		return pService.getProductAll();
	}
	
	@PostMapping(value="/panProductSelectByMain")
	@ResponseBody
	public String productSelectByMain(@RequestBody ProductResp main) throws Exception {
		String p_main = main.getP_main();
		return pService.getProductByMain(p_main);
	}
}
