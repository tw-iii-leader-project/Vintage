package tw.leader.po;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shoppingOrder")
public class ShoppingOrder {
	
	@Id @Column(name="orderId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int orderId;
	
	@Column(name="email")
	private String email;
	
	@Column(name="memo")
	private String memo;
	
	@Column(name="totalPrice")
	private int totalPrice;
	
	@Column(name="orderTime")
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
