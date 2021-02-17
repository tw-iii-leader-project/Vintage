package tw.leader.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.leader.po.ShoppingOrder;

public interface ShoppingOrderDao extends JpaRepository<ShoppingOrder, Integer> {

	@Query(value="select * from ShoppingOrder where email = ?1",nativeQuery = true)
	List<ShoppingOrder> findOrder(String email);
	// select * from ShoppingOrder where email = ?1;

	
}
