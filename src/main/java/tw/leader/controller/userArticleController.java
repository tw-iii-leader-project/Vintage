package tw.leader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.leader.po.userArticle;
import tw.leader.service.userArticleService;
import tw.leader.vo.UserResp;
import tw.leader.vo.userArticleResp;

@Controller
public class userArticleController {
	
	@Autowired
	private userArticleService uAService;

	@PostMapping(value="/panfindUserArticle")
	@ResponseBody
	public String findUserArticle(@RequestBody UserResp userData) throws Exception {
		String email = userData.getEmail();
		return uAService.getUserArticle(email);
	}
	
	@PostMapping(value="/panInsertDescription")
	@ResponseBody
	public String insertUserDescription(@RequestBody userArticleResp articleData) {
		String email = articleData.getEmail();
		String description = articleData.getDescription();
		userArticleResp result = uAService.insertDescription(email, description);
		String message = result.getMessage();
		return message;
	}
	
	@PostMapping(value="/panInsertArticle")
	@ResponseBody
	public String insertUserArticle(@RequestBody userArticleResp articleData) {
		String email = articleData.getEmail();
		String articleContext = articleData.getArticleContext();
		userArticleResp result = uAService.insertArticle(email, articleContext);
		String message = result.getMessage();
		return message;
	}
	
	
}
