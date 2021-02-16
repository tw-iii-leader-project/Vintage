package tw.leader.service;

import tw.leader.vo.userArticleResp;

public interface userArticleService {

	public String getUserArticle(String email) throws Exception;
	
	public userArticleResp insertArticle(String email,String description,String articleContext);
}
