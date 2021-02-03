package tw.leader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.leader.dao.ProductSelectDao;
import tw.leader.po.Product;
import tw.leader.vo.ProductReq;
import tw.leader.vo.ProductResp;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductSelectDao pSDao;
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
	 * ***userPage賣家頁面***查詢出此賣家的所有商品
	 * */
	@Override
	public String getMainByUserName(String user_acc) throws Exception {
		List<Product> mList = pSDao.selectMainByName(user_acc);
		String mJson = objectMapper.writeValueAsString(mList);
		System.out.println(mJson);
		return mJson;
	}
	
	/*
	 * ***userPage賣家頁面***利用類別查詢出此賣家的所有商品
	 * */
	@Override
	public String getProductByMainAndName(String p_main,String user_acc) throws Exception {
		List<Product> pList = pSDao.selectProductByMainAndName(p_main, user_acc);
		String pJson = objectMapper.writeValueAsString(pList);
		String response = pJson;
		return response;
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




















