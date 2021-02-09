package tw.leader.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shoppingCart")
public class ShoppingCart {
	
	@Id @Column(name="cartId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int cartId;
	
	@Column(name="email")
	private String email;
	
	@Column(name="pId")
	private int pId;
	
	@Column(name="pName")
	private String pName;
	
	@Column(name="price")
	private int price;
	
	@Column(name="amount")
	private int amount;
	
	@Column(name="cPhoto")
	private String cPhoto;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public String getcPhoto() {
		return cPhoto;
	}

	public void setcPhoto(String cPhoto) {
		this.cPhoto = cPhoto;
	}
	
	

}
