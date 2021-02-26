package tw.leader.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.leader.po.Product;

public interface ProductSelectDao extends JpaRepository<Product,Integer> {

	// 載入頁面時，查詢商品總數
	@Query(value="select count(*) from Product",nativeQuery = true)
	int selectAllTotal();
	
	// 查詢出分類商品總數
	@Query(value="select count(*) from Product where pMain = ?1",nativeQuery = true)
	int selectAllTotalByMain(String pMain);
	
	// 載入頁面時，顯示全部
	@Query(value="select * from Product order by pName offset (?1)*12 rows fetch next 12 rows only",nativeQuery = true)
	List<Product> selectAll(int page);
	// select * from Product order by pName offset (?1)*12 rows fetch next 12 rows only
	
	//查詢大項
	@Query(value="select * from product where pMain = ?1 order by pName offset (?2)*12 rows fetch next 12 rows only",nativeQuery = true)
	List<Product> selectAllByMain(String pMain,int page);
	
	//查詢大項 + 小項
	@Query(value="select * from Product where pMain = ?1 and pDetail = ?2",nativeQuery = true)
	List<Product> selectMainAndDetail(String pMain,String pDetail);
		
	// 查詢名稱  select * from Product where p_name like '%手工%';
	@Query(value="select * from Product where pName like %?1%",nativeQuery = true)
	List<Product> selectName(String pName);
	
	// 查詢商品全部資料
	@Query(value="select * from Product where pId = ?1",nativeQuery = true)
	List<Product> selectById(int pId);
	
	// 查詢賣家全部商品
	@Query(value="select * from Product where email = ?1 order by pMain",nativeQuery = true)
	List<Product> selectMainByName(String email);
	// select * from product where user_acc = 'gawrgura' order by p_main;
	
	
	// 查詢出商品總數
	@Query(value="select count(*) from Product where email = ?1",nativeQuery = true)
	int selectProductTotal(String email);
	// select count(*) from Product where user_acc = 'GawrGura';
	
	// 查詢出分類商品總數
	@Query(value="select count(*) from Product where email = ?1 and pMain = ?2",nativeQuery = true)
	int selectProductTotalByMain(String email,String pMain);
	
	// 查詢出賣家全部商品
	@Query(value="select * from Product where email = ?1 order by pMain offset (?2)*8 rows fetch next 8 rows only",nativeQuery = true)
	List<Product> selectProductByUserName(String email,int page);
	
	// 查詢賣家分類商品
	@Query(value="select * from product where email = ?1 and pMain = ?2 order by pMain offset (?3)*8 rows fetch next 8 rows only",nativeQuery = true)
	List<Product> selectProductByMainAndName(String email,String pMain,int page);
	//select * from product where p_main = '玩具' and user_acc = 'gawrgura';
	
	/*
	 * ---------------------------------------------------------------------
	 * 		IndexAndProduct
	 * */
	
	@Query(value="select Top 4* from product ORDER BY RAND()",nativeQuery = true)
	List<Product> findIndexProduct();
	// select Top 4* from product ORDER BY RAND();
	
	
	/*------------------------------------------------------
	 *  Test Dao*/
	
//	@Query(value="select * from Product where user_acc = ?1",nativeQuery = true)
//	Page<Product> selectProductPageByName(String user_acc,Pageable pageable);
	
	@Query(value="select * from Product where user_acc = ?1 order by p_main offset (?2)*3  rows fetch next 3 rows only",nativeQuery = true)
	List<Product> testSelectProductByUser(String user_acc,int page);
	// select * from Product where user_acc = 'GawrGura' order by p_id offset (1)*3  rows fetch next 3 rows only;
	

	
	
}
