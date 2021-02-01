package tw.leader.dao;

import java.util.List;

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
	
	@Query(value="select * from Product where user_acc = ?1",nativeQuery = true)
	List<Product> selectMainByName(String user_acc);
	
//	@Query(value="select ?1 from Product where user_acc = ?2",nativeQuery = true)
//	List<Product> selectMainByName(String title ,String user_acc);
	//select distinct p_main from Product where user_acc = 'GawrGura';
	
}
