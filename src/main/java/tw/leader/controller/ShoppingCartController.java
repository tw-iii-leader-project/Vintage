package tw.leader.controller;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tw.leader.po.Product;
import tw.leader.po.ShoppingCart;
import tw.leader.po.ShoppingCartKey;
import tw.leader.po.User;
import tw.leader.dao.ProductSelectDao;
import tw.leader.dao.ShoppingCartRepository;
import tw.leader.dao.UserRepository;

@Controller
public class ShoppingCartController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ProductSelectDao productSelectDao;
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;

//	public User getUser(){
//        MyUserDetails myUserDetails = (MyUserDetails)SecurityContextHolder
//                .getContext().getAuthentication().getPrincipal();
//        return userRepository.findById(myUserDetails.getUsername()).get();
//    }

	private Timestamp getCurrentTime() {
		return new Timestamp(new Date().getTime());
	}

	// 增加購物車
	@RequestMapping(value = "/addToCart", method = RequestMethod.GET)
	public String addToCart(Model model, Integer pId, Integer amount) {
		User user = getUser();
		int userId = user.getUserId();
		Product product = productSelectDao.findById(pId).get();
		ShoppingCartKey cartId = new ShoppingCartKey(userId, pId);
		ShoppingCart cart;
		if (shoppingCartRepository.findById(cartId).isPresent()) {
			// 取出同類商品
			cart = shoppingCartRepository.findById(cartId).get();
			cart.setAmount(cart.getAmount() + amount);
			cart.setUpdateTime(getCurrentTime());
		} else {
			cart = new ShoppingCart(userId, user, pId, product, amount, 1, getCurrentTime(), getCurrentTime());
		}
		shoppingCartRepository.save(cart);
//		return "redirect:json/true.json";
		return "shopPage";
	}


	// 查購物車
	@RequestMapping(value = "/shopping-cart")
	public String cart(Model model) {
		User user = getUser();
		List<ShoppingCart> carts = shoppingCartRepository.findCartByUser(user);
		model.addAttribute("carts", carts);
		return "shopping-cart";
	}

	// 計算金額
	public double cal_totalPrice() {
		int sum = 0;
		User user = getUser();
		List<ShoppingCart> carts = shoppingCartRepository.findCartByUser(user);
		for (ShoppingCart cart : carts) {
			if (cart.getCartStatus() == 1) {
				int price = cart.getProduct().getPrice() * cart.getAmount();
				sum += price * cart.getAmount();
			}
		}
		return sum;
	}

	private User getUser() {
		// TODO Auto-generated method stub
		return null;
	}

	// 刪除購物車商品
	@RequestMapping(value = "/deleteCart")
	public String deleteFromCart(Model model, Integer pId) {
		User user = getUser();
		ShoppingCartKey cartKey = new ShoppingCartKey(user.getUserId(), pId);
		shoppingCartRepository.deleteById(cartKey);
		model.addAttribute("totalPrice", cal_totalPrice());
		return "shopping-cart";
	}

	// 更新購物
	@RequestMapping(value = "/updateCart")
	public String updateCart(Model model, Integer pId, Integer amount) {
		User user = getUser();
		ShoppingCartKey cartKey = new ShoppingCartKey(user.getUserId(), pId);
		ShoppingCart cart = shoppingCartRepository.findById(cartKey).get();
		cart.setAmount(amount);
		cart.setUpdateTime(getCurrentTime());
		shoppingCartRepository.save(cart);
		model.addAttribute("totalPrice", cal_totalPrice());
		return "redirect:json/true.json";
	}

	// 更新購物車狀態
	@RequestMapping(value = "/updateCartStatus")
	public String updateCartStatus(Model model, Integer[] cartStatus) {
		User user = getUser();
		List<ShoppingCart> carts = shoppingCartRepository.findCartByUser(user);
		int i = 0;
		for (ShoppingCart cart : carts) {
			cart.setCartStatus(cartStatus[i]);
			shoppingCartRepository.save(cart);
			i++;
		}
		model.addAttribute("totalPrice", cal_totalPrice());
		return "redirect:json/true.json";
	}

}
