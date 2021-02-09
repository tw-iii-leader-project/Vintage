package tw.leader.boot.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import tw.leader.boot.domain.*;
import tw.leader.boot.mapper.GoodsCategoryMapper;
import tw.leader.boot.mapper.ProductMapper;
import tw.leader.boot.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
	
	private static Logger logger=LoggerFactory.getLogger(ProductServiceImpl.class);
	
	@Autowired
	private ProductMapper productMapper;
	
	@Autowired
	private GoodsCategoryMapper categoryMapper;
	
	@Override
	public List<Product> getProductListByPage(int pageSize,int pageNo){
		return productMapper.getListByPage(pageSize, pageNo);
	}
	
	@Override
	public List<Product> getProductListByCategory(int categoryId) {
		return productMapper.getList(categoryId);
	}
	
	@Override
	public List<Product> getProductListByMultIds(int... productpIds) {
		return productMapper.getListByMultIds(productpIds);
	}
	
	@Override
	public Product getProduct(int pId) {
		return productMapper.get(pId);
	}
	
	@Transactional
	@Override
	public void insertProduct(Product product, MultipartFile uploadProductcPhoto) {
		String picPath= saveGoodsPic(uploadProductcPhoto);
		if(picPath!=null && !picPath.isEmpty()) {
			
			product.setcPhoto(picPath);
		}
		productMapper.insert(product);
		
		GoodsCategory gcate= categoryMapper.get(product.getCategoryId());
		gcate.setGoodsCount(gcate.getGoodsCount()+1);
		categoryMapper.update(gcate);
		
		logger.info("inserted new product - id:" + product.getPid());
	}
	
	@Override
	public void updateProduct(Product product,MultipartFile uploadProductcPhoto) {
		String picPath= saveGoodsPic(uploadProductcPhoto);
		if(picPath!=null && !picPath.isEmpty()) {
			
			product.setcPhoto(picPath);
		}
		 productMapper.update(product);
		 
		 logger.info("update product - id:" + product.get);
	}
	
	@Transactional
	@Override
	public void deleteProduct(int pId) {
		Product p= productMapper.get(pId);
		productMapper.delete(p.getpId());
		
		GoodsCategory gcate= categoryMapper.get(p.getCategoryId());
		gcate.setGoodsCount(gcate.getGoodsCount()-1);
		categoryMapper.update(gcate);
		
		//如果有图片，则同时删除图片
		if(p.getcPhoto()!=null && !p.getcPhoto().isEmpty()) {
			
			String picPath= getRequest().getServletContext().getRealPath("/") + p.getcPhoto();
			File file = new File(picPath);
			if(file.exists()) {
				file.delete();
			}
		}
		
		logger.info("deleted product - id:" + p.getpId());
	}
	
	@Override
	public List<GoodsCategory> getAllGoodsCategoryList(){
		return categoryMapper.getAll();
	}
	
	@Override
	public void insertGoodsCategory(GoodsCategory goodsCategory) {
		categoryMapper.insert(goodsCategory);
	}
	
	@Override
	public void updateGoodsCategory(GoodsCategory goodsCategory) {
		categoryMapper.update(goodsCategory);
	}
	
	@Override
	public void deleteGoodsCategory(int id) {
		categoryMapper.delete(id);
	}


	private String saveProductcPhoto(MultipartFile uploadProductcPhoto) {
		
		if(uploadProductcPhoto==null || uploadProductcPhoto.isEmpty()) {
			return null;
		}
		
		String fileName = uploadProductcPhoto.getOriginalFilename();
		
		String extName = fileName.substring(fileName.lastIndexOf("."));
		
        String newFileName=UUID.randomUUID().toString()+extName;
		File file = new File(getFileSavePath(newFileName));
		if(!file.exists()) {
			file.getParentFile().mkdirs();
		}
		
		
		try {
			uploadProductcPhoto.transferTo(file);
			//return file.toURI().toURL().toString();
			return getUrlPath(file.getAbsolutePath());
			
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return null;
	}



	private String getFileSavePath(String fileName) {
        String realPath =getRequest().getServletContext().getRealPath("/uploadimgs/");
        return realPath + fileName;
	}

	private String getUrlPath(String filePath) {
		String rootPath= getRequest().getServletContext().getRealPath("/");
		return filePath.replace(rootPath, "").replaceAll("\\\\", "/");
	}

	private HttpServletRequest getRequest() {
        HttpServletRequest  request= ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        return request;
    }
	
	
}
