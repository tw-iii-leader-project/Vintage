package tw.leader.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tw.leader.service.userArticleService;
import tw.leader.vo.userArticleResp;

@Controller
public class userArticleController {
	
	@Autowired
	private userArticleService uAService;

	@PostMapping(value="/panInsertArticle")
	@ResponseBody
	public String insertUserArticle(@RequestBody userArticleResp articleData) {
		String email = articleData.getEmail();
		String description = articleData.getDescription();
		String articleContext = articleData.getArticleContext();
		userArticleResp result = uAService.insertArticle(email, description, articleContext);
		String message = result.getMessage();
		return message;
	}
}
