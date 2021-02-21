package tw.leader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tw.leader.service.UserPicService;
import tw.leader.vo.UserPicReq;
import tw.leader.vo.UserPicResp;

@RestController
@RequestMapping(value = "/api")
public class GotUserPicController {

	@Autowired
	private UserPicService userPicService;

	@PostMapping(value = "/gotUserPic")
	public UserPicResp gotUserPic(@RequestBody UserPicReq req) {
		return userPicService.gotUserPic(req);
	}

}
