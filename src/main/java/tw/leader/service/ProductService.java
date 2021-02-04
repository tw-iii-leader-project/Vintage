package tw.leader.service;

import java.util.List;

import tw.leader.po.Product;

public interface ProductService {

	public String getProductAll() throws Exception;
	
	public String getProductByMain(String p_main) throws Exception;
	
//	public String getProductByMainAndDetail(String p_main,String p_detail) throws Exception;
	
	public String getProductByName(String p_name) throws Exception;
	
	public String getProductById(int p_id) throws Exception;

	public String getProductByMainAndName(String p_main,String user_acc) throws Exception;

	public String getPageMessages(String user_acc) throws Exception;
	
	public String getProductTotal(String user_acc) throws Exception;
}
