package tw.leader.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.leader.po.ShoppingCart;
import tw.leader.vo.ShoppingCartResp;

public interface ShoppingCartDao extends JpaRepository<ShoppingCart, Integer> {

//	@Query(value="insert into shoppingCart (email,pId,pName,price,amount,cPhoto) values(?1,?2,?3,?4,?5,?6)",nativeQuery = true)
//	public ShoppingCartResp insert(String email,int pId,String pName,int price,int amount,String cPhoto);

	@Query(value="select count(*) from shoppingCart where email = ?1",nativeQuery = true)
	public int findProductQuantity(String email);
	//select count(*) from shoppingCart where email = 'anonymousUser';
	
	@Query(value="select * from shoppingCart where email = ?1 and pId = ?2",nativeQuery = true)
	public ShoppingCart findProductByEmailAndId(String email,int pId);
	
	@Query(value="select * from shoppingCart where email = ?1",nativeQuery = true)
	List<ShoppingCart> findShop(String email);
	
	@Query(value="delete from shoppingCart where cartId = ?1",nativeQuery = true)
	public ShoppingCartResp deleteProductById(int cartId);
	
	@Query(value="update ShoppingCart set amount = ?1 where cartId = ?2",nativeQuery = true)
	public ShoppingCart updateProductAmount(int amount,int cartId);
	//update ShoppingCart set amount = 5 where cartId = 1;
	
	@Query(value="delete from ShoppingCart where email = ?1",nativeQuery = true)
	public ShoppingCartResp deleteAllProductByEmail(String email);
	// delete from ShoppingCart where email = ?1;
	
}
