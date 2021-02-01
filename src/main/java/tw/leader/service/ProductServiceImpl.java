package tw.leader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	@Override
	public String getProductAll() throws Exception{
		List<Product> pList = pSDao.selectAll();
		System.out.println("go");
		String pJson = objectMapper.writeValueAsString(pList);
		System.out.println(pJson);
		String response = pJson;
		return response;
	}
	
	@Override
	public String getProductByMain(String p_main) throws Exception{
		System.out.println(p_main);
		 List<Product> pList = pSDao.findByMain(p_main);
		 String pJson = objectMapper.writeValueAsString(pList);
		 System.out.println(pJson);
		 String response = pJson;
		 return response;
	}
	
	@Override
	public String getProductByMainAndDetail(String p_main,String p_detail) throws Exception {
		List<Product> pList = pSDao.selectMainAndDetail(p_main, p_detail);
		String pJson = objectMapper.writeValueAsString(pList);
		System.out.println(pJson);
		String response = pJson;
		return response;
	}
	
	@Override
	public String getProductByName(String p_name) throws Exception {
		System.out.println(p_name);
		List<Product> pList = pSDao.selectName(p_name);
		String pJson = objectMapper.writeValueAsString(pList);
		System.out.println(pJson);
		String response = pJson;
		return response;
	}
	
	@Override
	public String getProductById(int p_id) throws Exception {
		System.out.println(p_id);
		List<Product> pList = pSDao.selectById(p_id);
		String pJson = objectMapper.writeValueAsString(pList);
		System.out.println(pJson);
		String response = pJson;
		return response;
	}
	
	@Override
	public String getMainByUserName(String user_acc) throws Exception {
		List<Product> mList = pSDao.selectMainByName(user_acc);
		String mJson = objectMapper.writeValueAsString(mList);
		System.out.println(mJson);
		return mJson;
	}
	
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




















