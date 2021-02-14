package tw.leader.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.leader.service.ManagementService;

@Controller
public class MemberManagement {

	private ManagementService mService;
	
	@PostMapping(value="/panFindPages")
	@ResponseBody
	public String findPages() throws Exception {
		return mService.getTotal();
	}
	
	@PostMapping(value="/panFindAllUser")
	@ResponseBody
	public String findAllUserLond() throws Exception {
		return mService.getAllUser();
	}
	
	@PostMapping(value="/panFindAllUser.page")
	@ResponseBody
	public String findAllUserPage(@RequestBody Map<String,String> pMap) throws Exception {
		int page = 0;
		if(pMap.containsKey("page")) {
			page = Integer.parseInt(pMap.get("page"));
		}
		return mService.getAllUserP(page);
	}
}
