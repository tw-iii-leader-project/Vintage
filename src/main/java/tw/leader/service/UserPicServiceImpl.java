package tw.leader.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.leader.dao.FindUserInfoDao;
import tw.leader.dao.UserPicRepository;
import tw.leader.po.User;
import tw.leader.vo.UserPicReq;
import tw.leader.vo.UserPicResp;

@Service
public class UserPicServiceImpl implements UserPicService {

	@Autowired
	private UserPicRepository userPicRepository;

	@Override
	public UserPicResp gotUserPic(UserPicReq req) {
		User user = new User();
		user = userPicRepository.findPicByEmail(req.getEmail());
		UserPicResp userPicResp = new UserPicResp();
		userPicResp.setUserPic(user.getUserPic());
		return userPicResp;
	}

}
