package tw.leader.boot.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import tw.leader.boot.domain.*;


public interface ProductServiceb {
	
	List<Productb> getProductListByPage(int pageSize,int pageNo);
	
	List<Productb> getProductListByCategory(int categoryId);
	
	List<Productb> getProductListByMultIds(int...productIds);
	
	List<Productb> getListByMultiEmail(String...email);
	
	Productb getProduct(int pId);
	
	void insertProduct(Productb product,MultipartFile uploadProductcPhoto);
	
	void updateProduct(Productb product,MultipartFile uploadProductcPhoto);
	
	void deleteProduct(int pId);
	
	
	List<GoodsCategory> getAllGoodsCategoryList();
	
	void insertGoodsCategory(GoodsCategory goodsCategory);
	
	void updateGoodsCategory(GoodsCategory goodsCategory);
	
	void deleteGoodsCategory(int id);
	
}