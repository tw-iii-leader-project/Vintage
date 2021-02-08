package tw.leader.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tw.leader.po.ShoppingCart;
import tw.leader.po.ShoppingCartKey;
import tw.leader.po.User;

public interface ShoppingCartRepository extends CrudRepository<ShoppingCart, ShoppingCartKey> {

	List<ShoppingCart> findCartByUser(User user);

	// userId查未結商品
	@Query(value = "select c from ShoppingCart c where c.user=?1")
	List<ShoppingCart> findCartByUser_id(User user);

	// 刪除已結的商品
	@Transactional
	@Modifying
	@Query(value = "delete from ShoppingCart c where c.user=?1 and c.cartStatus=?2")
	int deleteCartByUser(User user, Integer cartStuts);
}
