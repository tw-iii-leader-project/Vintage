package tw.leader.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.leader.po.Product;
import tw.leader.vo.adminResp;

public interface ProductInsertRepository extends JpaRepository<Product,Integer> {
//
//	@Query("INSERT INTO PRODUCT (pName, pMain, pDetail, price, invvantory, pSize, description, sDescription, cPhoto, email, userName)" + 
//			"VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)")
//	public adminResp insert(String pName, String pMain, String pDetail, int price, int invantory, String pSize, String description, String cPhoto, String email, String userName);
//	
//	@Query("DELETE FROM PRODUCT WHERE pId = ?1")
//	public adminResp delete(int pId);
//	
	@Query(value="SELECT FROM PRODUCT WHERE pId = ?1",nativeQuery = true)
	public Product findById(int pId);
	
	




}
