package tw.leader.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.leader.dao.ProductSelectDao;
import tw.leader.dao.ProductSelectPageDao;
import tw.leader.po.Product;
import tw.leader.vo.ProductReq;
import tw.leader.vo.ProductResp;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductSelectDao pSDao;
	@Autowired
	private ProductSelectPageDao pSPDao;
	@Autowired
	private ObjectMapper objectMapper ;
	
	/*
	 * *** shop頁面***載入時，查詢顯示全部資料 
	 * */
	@Override
	public String getProductAll() throws Exception{
		List<Product> pList = pSDao.selectAll();
		System.out.println("go");
		String pJson = objectMapper.writeValueAsString(pList);
		System.out.println(pJson);
		String response = pJson;
		return response;
	}
	
	/*
	 * *** Vintage全部頁面***Header區分類查詢
	 *  */
	@Override
	public String getProductByMain(String p_main) throws Exception{
		System.out.println(p_main);
		 List<Product> pList = pSDao.findByMain(p_main);
		 String pJson = objectMapper.writeValueAsString(pList);
		 System.out.println(pJson);
		 String response = pJson;
		 return response;
	}
	
	/*
	 * *** shop頁面***利用大項與細項類別查詢(待擴充!!!)
	 *  */
//	@Override
//	public String getProductByMainAndDetail(String p_main,String p_detail) throws Exception {
//		List<Product> pList = pSDao.selectMainAndDetail(p_main, p_detail);
//		String pJson = objectMapper.writeValueAsString(pList);
//		System.out.println(pJson);
//		String response = pJson;
//		return response;
//	}
	
	/*
	 * *** Vintage所有頁面***使用商品名稱查詢商品
	 *  */
	@Override
	public String getProductByName(String p_name) throws Exception {
		System.out.println(p_name);
		List<Product> pList = pSDao.selectName(p_name);
		String pJson = objectMapper.writeValueAsString(pList);
		System.out.println(pJson);
		String response = pJson;
		return response;
	}
	
	/*
	 * *** product-details頁面***查詢單件商品的所有資料 
	 * */
	@Override
	public String getProductById(int p_id) throws Exception {
		System.out.println(p_id);
		List<Product> pList = pSDao.selectById(p_id);
		String pJson = objectMapper.writeValueAsString(pList);
		System.out.println(pJson);
		String response = pJson;
		return response;
	}
	
	/*
	 * ***userPage賣家頁面***查詢此賣家所有商品類別
	 * */
	@Override
	public String getProductMainByUserName(String user_acc) throws Exception {
		List<Product> mList = pSDao.selectMainByName(user_acc);
		String pJson = objectMapper.writeValueAsString(mList);
		return pJson;
	}
	
	/*
	 * ***userPage賣家頁面***查詢出此賣家的所有商品
	 * */
	@Override
	public String getProductTotalLoad(String user_acc) throws Exception {
		int page = 0;
		List<Product> pList = pSDao.selectProductByUserName(user_acc,page);
		System.out.println(pList);
		String pJson = objectMapper.writeValueAsString(pList);
		System.out.println(pJson);
		return pJson;
	}
	
	/*
	 * ***userPage賣家頁面***查詢此賣家所有商品+分頁查詢
	 * */
	@Override
	public String getProductTotal(String user_acc,int page) throws Exception {
		int rPage = page-1;
		List<Product> pList = pSDao.selectProductByUserName(user_acc,rPage);
		System.out.println(pList);
		String pJson = objectMapper.writeValueAsString(pList);
		System.out.println(pJson);
		return pJson;
	}
	
	
	/*
	 * ***userPage賣家頁面***利用類別查詢出此賣家的所有商品
	 * */
	@Override
	public String getProductByMainAndName(String user_acc,String p_main) throws Exception {
		int page = 0;
		List<Product> pList = pSDao.selectProductByMainAndName(user_acc,p_main,page);
		String pJson = objectMapper.writeValueAsString(pList);
		String response = pJson;
		return response;
	}
	
	/*
	 * ***userPage賣家頁面***利用類別查詢出此賣家的所有商品+分頁查詢
	 * */
	public String getProductByMainAndNameP(String user_acc,String p_main,int page) throws Exception {
		int rPage = page-1;
		List<Product> pList = pSDao.selectProductByMainAndName(user_acc,p_main,rPage);
		String pJson = objectMapper.writeValueAsString(pList);
		String response = pJson;
		return response;
	}
	
	/*
	 ***取得商品總數與總頁數
	 * */
	@Override
	public String getPageMessages(String user_acc) throws Exception {
		int total = pSDao.selectProductTotal(user_acc);
		int pages = total/8;
		if((total%8) != 0) {
			pages += 1;
		};
		List<Map<String,String>> pageData = new ArrayList<>();
		Map<String,String> totalElements = new HashMap<>();
		Map<String,String> totalPages = new HashMap<>();
		totalElements.put("totalElements",Integer.toString(total));
		totalPages.put("totalPages",Integer.toString(pages));
		pageData.add(totalElements);
		pageData.add(totalPages);
		
		String pJson = objectMapper.writeValueAsString(pageData);
		System.out.println(pJson);
		return pJson;
		
	}
	
	/*
	 * ***取得分類商品總數與頁數
	 * */
	public String getPageMessageByMain(String user_acc,String p_main) throws Exception {
		int total = pSDao.selectProductTotalByMain(user_acc,p_main);
		int pages = total/8;
		if((total%8) != 0) {
			pages += 1;
		};
		List<Map<String,String>> pageData = new ArrayList<>();
		Map<String,String> totalElements = new HashMap<>();
		Map<String,String> totalPages = new HashMap<>();
		totalElements.put("totalElements",Integer.toString(total));
		totalPages.put("totalPages",Integer.toString(pages));
		pageData.add(totalElements);
		pageData.add(totalPages);
		
		String pJson = objectMapper.writeValueAsString(pageData);
		System.out.println(pJson);
		return pJson;
	}
	
	
	/*
	 * -----------------------------------------------------------
	 * 		Test class
	 * */
	
//	public String getTestProductByName(String user_acc,int pageNum) {
//		int pageSize = 4;
//		Pageable pageable = new PageRequest(pageNum -1, pageSize, );
//	}
	
	
	//ProductReq 轉 ProductEntity
	private Product setProductEntity(ProductReq req) {
		Product pBean = new Product();
		
		pBean.setP_name(req.getP_name());
		pBean.setP_main(req.getP_main());
		pBean.setP_detail(req.getP_detail());
		pBean.setPrice(req.getPrice());
		pBean.setInvantory(req.getInvantory());
		pBean.setDescription(req.getDescription());
		pBean.setS_description(req.getS_description());
		pBean.setP_img(req.getP_img());
		pBean.setUser_acc(req.getUser_acc());
		
		return pBean;
	}
	
	// ProductEntity 轉 ProductResponse
	private ProductResp setProductResp(Product pBean) {
		ProductResp pResp = new ProductResp();
		
		pResp.setP_name(pBean.getP_name());
		pResp.setP_main(pBean.getP_main());
		pResp.setP_detail(pBean.getP_detail());
		pResp.setPrice(pBean.getPrice());
		pResp.setInvantory(pBean.getInvantory());
		pResp.setDescription(pBean.getDescription());
		pResp.setS_description(pBean.getS_description());
		pResp.setP_img(pBean.getP_img());
		pResp.setUser_acc(pBean.getUser_acc());
		return pResp;
	}

	
}




















