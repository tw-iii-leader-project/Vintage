package tw.leader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import tw.leader.dao.ShoppingCartDao;
import tw.leader.po.ShoppingCart;
import tw.leader.vo.ShoppingCartResp;
import tw.leader.vo.ShoppingOrderResp;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{

	@Autowired
	private ShoppingCartDao sDao;
	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public int getshoppingQuantity(String email) {
		int result = sDao.findProductQuantity(email);
		return result;
	}
	
	@Override
	public ShoppingCartResp insertProduct(String email,int pId,String pName,int price,int amount,String cPhoto) {
		ShoppingCart result = sDao.findProductByEmailAndId(email, pId);
		if(result == null) {
			ShoppingCart sBean = new ShoppingCart();
			sBean.setEmail(email);
			sBean.setpId(pId);
			sBean.setpName(pName);
			sBean.setPrice(price);
			sBean.setAmount(amount);
			sBean.setcPhoto(cPhoto);
		
			sDao.save(sBean);
			ShoppingCartResp insertMsg = new ShoppingCartResp();
			insertMsg.setMessage("商品已加入購物車");
			return insertMsg;
		}
		else {
			ShoppingCartResp insertMsg = new ShoppingCartResp();
			insertMsg.setMessage("您的購物車已有此商品");
			return insertMsg;
		}
	}
	
	@Override
	public String selectshoppingCart(String email) throws Exception {
		List<ShoppingCart> sList = sDao.findShop(email);
		String sJson = objectMapper.writeValueAsString(sList);
		System.out.println(sJson);
		return sJson;
	}
	
	@Override
	public ShoppingCartResp deleteProduct(int cartId) {
		ShoppingCartResp result = sDao.deleteProductById(cartId);
		result.setMessage("商品已從購物車裏移除");
		return result;
	}
	
	@Override
	public void updateshoppingCart(int amount,int cartId) {
		sDao.updateProductAmount(amount, cartId);
		System.out.println("修改成功");
	}
	
//	public String payAndAddOrder(String email) {
//		List<ShoppingCart> sList = sDao.findShop(email);
//		String memo = "";
//		int totalPrice = 0;
//		for(ShoppingCart i: sList) {
//			memo = memo+i.getpName();
//			memo = memo+"x"+i.getAmount()+";";
//		}
//		for(ShoppingCart j:sList) {
//			total
//		}
//		System.out.println(memo);
//		
//	}
}

