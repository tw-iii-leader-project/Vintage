package tw.leader.po;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import tw.leader.po.Product;
import tw.leader.po.ShoppingCartKey;
import tw.leader.po.User;

@Entity
@Table(name = "ShoppingCart")
public class ShoppingCart {

	// useId & pId複合主鍵
	@EmbeddedId
	private ShoppingCartKey cartId;

	@MapsId("userId")
	@ManyToOne
	@JoinColumn(name = "userId", referencedColumnName = "userId")
	private User user;

	@MapsId("pId")
	@ManyToOne
	@JoinColumn(name = "pId", referencedColumnName = "pId")
	private Product product;

	//
	@Column(name = "cartStatus")
	private Integer cartStatus;
	@Column(name = "amount")
	private Integer amount;

	@Column(name = "addTime")
	private Timestamp addTime;

	@Column(name = "updateTime")
	private Timestamp updateTime;

	public ShoppingCart() {

	}

	public ShoppingCart(int userId, User user, Integer pId, Product product, Integer amount, Integer cartStatus,
			Timestamp addTime, Timestamp updateTime) {
		this.cartId = new ShoppingCartKey(userId, pId);
		this.user = user;
		this.product = product;
		this.amount = amount;
		this.cartStatus = cartStatus;
		this.addTime = addTime;
		this.updateTime = updateTime;
	}

	public ShoppingCartKey getCartId() {
		return cartId;
	}

	public void setCartId(ShoppingCartKey cartId) {
		this.cartId = cartId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getCartStatus() {
		return cartStatus;
	}

	public void setCartStatus(Integer cartStatus) {
		this.cartStatus = cartStatus;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Timestamp getAddTime() {
		return addTime;
	}

	public void setAddTime(Timestamp addTime) {
		this.addTime = addTime;
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}

}
