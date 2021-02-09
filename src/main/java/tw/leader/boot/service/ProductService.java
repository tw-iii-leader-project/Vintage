package tw.leader.boot.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tw.leader.boot.domain.*;


public interface ProductService {
	
	List<Product> getProductListByPage(int pageSize,int pageNo);
	
	List<Product> getProductListByCategory(int categoryId);
	
	List<Product> getProductListByMultIds(int...productIds);
	
	Product getProduct(int pId);
	
	void insertProduct(Product product,MultipartFile uploadProductPhoto);
	
	void updateProduct(Product product,MultipartFile uploadProductPhoto);
	
	void deleteProduct(int pId);
	
	List<GoodsCategory> getAllGoodsCategoryList();
	
	void insertGoodsCategory(GoodsCategory goodsCategory);
	
	void updateGoodsCategory(GoodsCategory goodsCategory);
	
	void deleteGoodsCategory(int id);
	
}
