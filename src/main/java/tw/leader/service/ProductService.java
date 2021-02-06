package tw.leader.service;

import java.util.List;

import tw.leader.po.Product;

public interface ProductService {

	public String getProductAll() throws Exception;
	
	public String getProductByMain(String pMain) throws Exception;
	
//	public String getProductByMainAndDetail(String p_main,String p_detail) throws Exception;
	
	public String getProductByName(String pName) throws Exception;
	
	public String getProductById(int pId) throws Exception;

	public String getProductByMainAndName(String email,String pMain) throws Exception;

	public String getPageMessages(String email) throws Exception;
	
	public String getPageMessageByMain(String email,String pMain) throws Exception;
	
	public String getProductTotalLoad(String email) throws Exception;

	public String getProductMainByUserName(String email) throws Exception;
	
	public String getProductTotal(String email,int page) throws Exception;
	
	public String getProductByMainAndNameP(String email,String pMain,int page) throws Exception;
}
