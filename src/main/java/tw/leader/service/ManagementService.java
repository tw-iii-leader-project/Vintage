package tw.leader.service;

public interface ManagementService {

	public String getTotal() throws Exception;
	
	public String getAllUser() throws Exception;
	
	public String getAllUserP(int page) throws Exception;
	
	public String getUserByName(String userName) throws Exception;
}
