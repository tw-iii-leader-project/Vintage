package tw.leader.service;

import tw.leader.vo.UserResp;

public interface ManagementService {

	public String getTotal() throws Exception;
	
	public String getAllUser() throws Exception;
	
	public String getAllUserP(int page) throws Exception;
	
	public String getUserById(int userId) throws Exception;
	
	public String getUserByName(String userName) throws Exception;
	
	public String getUserByEmail(String email) throws Exception;

	public UserResp getUserAuthorityResult(int userId);
}
