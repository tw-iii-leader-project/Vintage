package tw.leader.boot.mapper;

import java.util.List;

import tw.leader.boot.domain.ShopUser;

public interface ShopUserMapper {
    int deleteByPrimaryKey(String userid);

    int insert(ShopUser record);

    ShopUser selectByPrimaryKey(String userid);

    List<ShopUser> selectAll();

    int updateByPrimaryKey(ShopUser record);
}