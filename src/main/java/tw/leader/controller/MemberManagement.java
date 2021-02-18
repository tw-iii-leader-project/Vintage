package tw.leader.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.leader.service.ManagementService;
import tw.leader.vo.UserResp;

@Controller
public class MemberManagement {

	@Autowired
	private ManagementService mService;
	
	@GetMapping("/panUserManagement")
	public String toManagementPage() {
		return "UserManagement";
	}
	
	@GetMapping("/panMember")
	public String toMemberManagementPage() {
		return "MemderManagement";
	}
	
	@GetMapping("/panAdvertisement")
	public String toAdvertisementManagementPage() {
		return "UserManagement";
	}
	
	@GetMapping("/panContact")
	public String toContactManagementPage() {
		return "UserManagement";
	}
	
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
	
//	@PostMapping(value="/panFindAllUser.page")
//	@ResponseBody
//	public String findAllUserPage(@RequestBody Map<String,String> pMap) throws Exception {
//		int page = 0;
//		if(pMap.containsKey("page")) {
//			page = Integer.parseInt(pMap.get("page"));
//		}
//		return mService.getAllUserP(page);
//	}
	
	@PostMapping(value="/panFindUserById.management")
	@ResponseBody
	public String findUserById(@RequestBody UserResp userData) throws Exception {
		int userId = userData.getUserId();
		return mService.getUserById(userId);
	}
	
	@PostMapping(value="/panFindUserByName.management")
	@ResponseBody
	public String findUserByName(@RequestBody UserResp userData) throws Exception {
		String userName = userData.getUserName();
		return mService.getUserByName(userName);
	}
	
	@PostMapping(value="/panFindUserByEmail.management")
	@ResponseBody
	public String findUserByEmail(@RequestBody UserResp userData) throws Exception {
		String email = userData.getEmail();
		return mService.getUserByEmail(email);
	}
	
	@PostMapping(value="/panSetUserAuthority")
	@ResponseBody
	public String setUserAuthority(@RequestBody UserResp userData) {
		int userId = userData.getUserId();
		return mService.getUserAuthority(userId);
	}
}
