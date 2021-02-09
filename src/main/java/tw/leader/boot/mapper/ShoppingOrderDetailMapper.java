package tw.leader.boot.mapper;

import java.util.List;

import tw.leader.boot.domain.ShoppingOrderDetail;

public interface ShoppingOrderDetailMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ShoppingOrderDetail record);

    ShoppingOrderDetail selectByPrimaryKey(Integer id);

    List<ShoppingOrderDetail> selectAll();

    int updateByPrimaryKey(ShoppingOrderDetail record);

    List<ShoppingOrderDetail> selectByOrderId(int shoppingOrderId);

    void deleteByOrderId(int shoppingOrderId);
}