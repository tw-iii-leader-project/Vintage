package tw.leader.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.leader.po.ShoppingCart;
import tw.leader.vo.ShoppingCartResp;

public interface ShoppingCartDao extends JpaRepository<ShoppingCart, Integer> {

//	@Query(value="insert into shoppingCart (email,pId,pName,price,amount,cPhoto) values(?1,?2,?3,?4,?5,?6)",nativeQuery = true)
//	public ShoppingCartResp insert(String email,int pId,String pName,int price,int amount,String cPhoto);

	@Query(value="select * from shoppingCart where email = ?1 and pId = ?2",nativeQuery = true)
	public List<ShoppingCart> findProductByEmailAndId(String email,int pId);
	
	@Query(value="delete from shoppingCart where cartId = ?1",nativeQuery = true)
	public ShoppingCartResp delete(int cartId);
	
	@Query(value="select * from shoppingCart where email = ?1",nativeQuery = true)
	List<ShoppingCart> findShop(String email);
}
