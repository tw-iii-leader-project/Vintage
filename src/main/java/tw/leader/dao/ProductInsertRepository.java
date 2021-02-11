package tw.leader.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.leader.po.Product;
import tw.leader.vo.AdminResp;

public interface ProductInsertRepository extends JpaRepository<Product,Integer> {
		
	@Query("DELETE FROM PRODUCT WHERE pId = ?1")
	public AdminResp delete(int pId);
	
	@Query("SELECT FROM PRODUCT WHERE pId = ?1")
	public Product findById(int pId);
	
	




}