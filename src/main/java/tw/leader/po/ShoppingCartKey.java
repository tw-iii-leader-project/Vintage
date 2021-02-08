package tw.leader.po;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class ShoppingCartKey implements Serializable {

	private int userId;
	private int pId;

	public ShoppingCartKey() {

	}

	public ShoppingCartKey(int userId, int pId) {
		this.userId = userId;
		this.pId = pId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String toString() {
		return "ShoppingCartKey [userId=" + userId + ", pId=" + pId;
	}
}
