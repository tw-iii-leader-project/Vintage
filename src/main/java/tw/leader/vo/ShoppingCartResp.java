package tw.leader.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShoppingCartResp extends ShoppingCartMessage{

	@JsonProperty(value="cartId")
	private int cartId;
	
	@JsonProperty(value="email")
	private String email;
	
	@JsonProperty(value="pId")
	private int pId;
	
	@JsonProperty(value="pName")
	private String pName;
	
	@JsonProperty(value="price")
	private int price;
	
	@JsonProperty(value="amount")
	private int amount;
	
	@JsonProperty(value="cPhoto")
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
