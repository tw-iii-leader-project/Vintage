package tw.leader.service;

import tw.leader.vo.ShoppingCartResp;

public interface ShoppingCartService {

	public int getshoppingQuantity(String email);
	
	public ShoppingCartResp insertProduct(String email,int pId,String pName,int price,int amount,String cPhoto);

	public String selectshoppingCart(String email) throws Exception;
	
	public ShoppingCartResp deleteProduct(int cartId);
	
	public void updateshoppingCart(int amount,int cartId);
	
	public int getShoppingCartTotalPrice(String email);
	
	public void payAndAddOrder(String email);
}
