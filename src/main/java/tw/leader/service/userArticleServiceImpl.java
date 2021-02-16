package tw.leader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.leader.dao.userArticleDao;
import tw.leader.po.userArticle;
import tw.leader.vo.userArticleResp;

@Service
public class userArticleServiceImpl implements userArticleService{

	@Autowired
	private userArticleDao uADao;
	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public String getUserArticle(String email) throws Exception {
		userArticle uList = uADao.selectUserArticle(email);
		String uJson = objectMapper.writeValueAsString(uList);
		System.out.println(uJson);
		return uJson;
	}
	
	@Override
	public userArticleResp insertArticle(String email,String description,String articleContext) {
		userArticle result = uADao.selectUserArticle(email);
		if(result == null) {
			userArticle aBean = new userArticle();
			aBean.setEmail(email);
			aBean.setDescription(description);
			aBean.setArticleContext(articleContext);
			
			uADao.save(aBean);
			userArticleResp insertMsg = new userArticleResp();
			insertMsg.setMessage("文章已新增");
			return insertMsg;
		}
		else {
			userArticleResp insertMsg = new userArticleResp();
			insertMsg.setMessage("已有此文長");
			return insertMsg;

		}
	}
}
