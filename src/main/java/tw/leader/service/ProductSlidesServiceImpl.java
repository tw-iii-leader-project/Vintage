package tw.leader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import tw.leader.dao.ProductSlideshowDao;
import tw.leader.po.Product;

@Service
public class ProductSlidesServiceImpl implements ProductSlidesService{

	@Autowired
	private ProductSlideshowDao sDao;
	
	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public String getSlidesProduct(String email) throws Exception{
		List<Product> pList = sDao.findSlideshowProduct(email);
		String pJson = objectMapper.writeValueAsString(pList);
		System.out.println(pJson);
		return pJson;
	}
}
