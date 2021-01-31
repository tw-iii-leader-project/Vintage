package tw.leader.service;

public interface ProductService {

	public String getProductAll() throws Exception;
	
	public String getProductByMain(String p_main) throws Exception;
	
	public String getProductByMainAndDetail(String p_main,String p_detail) throws Exception;
	
	public String getProductByName(String p_name) throws Exception;
	
	public String getProductById(int p_id) throws Exception;
	
	public String getMainByUserName(String user_acc) throws Exception;
}
