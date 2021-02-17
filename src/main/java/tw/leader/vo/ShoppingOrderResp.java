package tw.leader.vo;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ShoppingOrderResp extends ErrorResp{

	@JsonProperty(value="orderId")
	private int orderId;
	
	@JsonProperty(value="email")
	private String email;
	
	@JsonProperty(value="memo")
	private String memo;
	
	@JsonProperty(value="totalPrice")
	private int totalPrice;
	
	@JsonProperty(value="orderTime")
	private Timestamp orderTime;

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public int getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Timestamp getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Timestamp orderTime) {
		this.orderTime = orderTime;
	}
	
	
}
