package tw.leader.service;

import tw.leader.vo.ShoppingCartResp;

public interface ShoppingCartService {

	public ShoppingCartResp insertProduct(String email,int pId,String pName,int price,int amount,String cPhoto);
}
