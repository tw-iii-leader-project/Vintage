package tw.leader.boot.mapper;

import java.util.List;

import tw.leader.boot.domain.ShoppingOrder;

public interface ShoppingOrderExtMapper {
	
	List<ShoppingOrder> selectAllByShopper(String shopper);
}
