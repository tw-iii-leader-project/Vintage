package tw.leader.boot.service;

import java.util.List;

import tw.leader.boot.domain.ShopUser;

public interface ShopUserService {

	List<ShopUser> getAll();
	
	ShopUser get(String userId);
	
	String getCurrentLoginUser();
	
	String login(String uid,String pwd);
	
	void logout();
}
