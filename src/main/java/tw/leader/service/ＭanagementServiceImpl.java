package tw.leader.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.leader.dao.FindUserInfoDao;
import tw.leader.po.User;

public class ＭanagementServiceImpl implements ManagementService{

	@Autowired
	private FindUserInfoDao fDao;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public String getTotal() throws Exception {
		int total = fDao.selectTotalUser();
		int pages = total/12;
		if((total%12) != 0) {
			pages += 1;
		}
		List<Map<String,Integer>> pageData = new ArrayList<>();
		Map<String,Integer> totalUser = new HashMap<>();
		Map<String,Integer> totalPages = new HashMap<>();
		totalUser.put("totalUser", total);
		totalPages.put("totalPages",pages);
		pageData.add(totalUser);
		pageData.add(totalPages);
		
		String pJson = objectMapper.writeValueAsString(pageData);
		System.out.println(pJson);
		return pJson;
	}
	
	@Override
	public String getAllUser() throws Exception {
		int page = 0;
		List<User> uList = fDao.findAllUser(page);
		String uJson = objectMapper.writeValueAsString(uList);
		System.out.println(uJson);
		return uJson;
	}
	
	@Override
	public String getAllUserP(int page) throws Exception {
		int rPage = page-1;
		List<User> uList = fDao.findAllUser(rPage);
		String uJson = objectMapper.writeValueAsString(uList);
		System.out.println(uJson);
		return uJson;
	}
	
	@Override
	public String getUserByName(String userName) throws Exception {
		List<User> uList = fDao.findUserByName(userName);
		String uJson = objectMapper.writeValueAsString(uList);
		System.out.println(uJson);
		return uJson;
	}
	
	
}
