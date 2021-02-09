package tw.leader.boot.mapper;

import java.util.List;

import tw.leader.boot.domain.ShoppingOrder;

public interface ShoppingOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShoppingOrder record);

    ShoppingOrder selectByPrimaryKey(Integer id);

    List<ShoppingOrder> selectAll();

    int updateByPrimaryKey(ShoppingOrder record);
}