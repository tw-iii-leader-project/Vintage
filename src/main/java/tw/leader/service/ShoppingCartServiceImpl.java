package tw.leader.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;

import tw.leader.dao.ShoppingCartDao;
import tw.leader.po.ShoppingCart;
import tw.leader.vo.ShoppingCartResp;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService{

	@Autowired
	private ShoppingCartDao sDao;
	@Autowired
	private ObjectMapper objectMapper;
	
	@Override
	public ShoppingCartResp insertProduct(String email,int pId,String pName,int price,int amount,String cPhoto) {
		List<ShoppingCart> sList = sDao.findProductByEmailAndId(email, pId);
		if(sList == null) {
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
}

