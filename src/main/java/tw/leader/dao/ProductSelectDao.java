package tw.leader.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.leader.po.Product;

public interface ProductSelectDao extends JpaRepository<Product,Integer> {

	// 載入頁面時，顯示全部
	@Query(value="select * from Product",nativeQuery = true)
	List<Product> selectAll();
		
	//查詢大項
	@Query(value="select u from Product u where u.p_main = ?1")
	List<Product> findByMain(String p_main);
	
	//查詢大項 + 小項
	@Query(value="select * from Product where p_main = ?1 and p_detail = ?2",nativeQuery = true)
	List<Product> selectMainAndDetail(String p_main,String p_detail);
		
	// 查詢名稱  select * from Product where p_name like '%手工%';
	@Query(value="select * from Product where p_name like %?1%",nativeQuery = true)
	List<Product> selectName(String p_name);
	
	// 查詢商品全部資料
	@Query(value="select * from Product where p_id = ?1",nativeQuery = true)
	List<Product> selectById(int p_id);
	
	// 查詢賣家全部商品
	@Query(value="select * from Product where user_acc = ?1 order by p_main",nativeQuery = true)
	List<Product> selectMainByName(String user_acc);
	// select * from product where user_acc = 'gawrgura' order by p_main;
	
	// 查詢賣家分類商品
	@Query(value="select * from product where p_main = ?1 and user_acc = ?2",nativeQuery = true)
	List<Product> selectProductByMainAndName(String p_main,String user_acc);
	//select * from product where p_main = '玩具' and user_acc = 'gawrgura';
	
	
	
	/*------------------------------------------------------
	 *  Test Dao*/
	
	@Query(value="select * from Product where user_acc = ?1 order by p_main",nativeQuery = true)
	Page<Product> selectProductPageByName(String user_acc,Pageable pageable);
	
	
	
	
	
	
	
	
}
