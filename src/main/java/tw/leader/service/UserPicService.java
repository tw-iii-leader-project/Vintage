package tw.leader.service;

import tw.leader.vo.UserPicReq;
import tw.leader.vo.UserPicResp;

public interface UserPicService {
	/**
	 * 用email撈userPic
	 * 
	 * @param email
	 * @return userPic
	 * 
	 * */
	public UserPicResp gotUserPic(UserPicReq req);
}
