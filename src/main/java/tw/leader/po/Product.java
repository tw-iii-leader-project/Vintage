package tw.leader.po;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class Product implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id 
	@Column(name="pId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pId;
	
	@Column(name="pName")
	private String pName;
	
	@Column(name="pMain")
	private String pMain;
	
	@Column(name="pDetail")
	private String pDetail;
	
	@Column(name="price")
	private int price;
	
	@Column(name="invantory")
	private int invantory;
	
	@Column(name="pSize")
	private String pSize;
	
	@Column(name="description")
	private String description;
	
	@Column(name="sDescription")
	private String sDescription;
	
	@Column(name="cPhoto")
	private String cPhoto;
	
	@Column(name="email")
	private String email;
	
	@Column(name="userName")
	private String userName;

	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpMain() {
		return pMain;
	}

	public void setpMain(String pMain) {
		this.pMain = pMain;
	}

	public String getpDetail() {
		return pDetail;
	}

	public void setpDetail(String pDetail) {
		this.pDetail = pDetail;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getInvantory() {
		return invantory;
	}

	public void setInvantory(int invantory) {
		this.invantory = invantory;
	}

	public String getpSize() {
		return pSize;
	}

	public void setpSize(String pSize) {
		this.pSize = pSize;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getsDescription() {
		return sDescription;
	}

	public void setsDescription(String sDescription) {
		this.sDescription = sDescription;
	}
	
	public String getcPhoto() {
		return cPhoto;
	}

	public void setcPhoto(String cPhoto) {
		this.cPhoto = cPhoto;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	
	
}
