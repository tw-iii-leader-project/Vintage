package tw.leader.boot.domain;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;


public class Productb {
	private int pId;
	private String pName;
	private String pMain;
	private String pDetail;
	private int price;
	private int invantory;
	private String pSize;
	private String description;
	private String sDescription;
	private String cPhoto;
	private String email;
	private String userName;
	private int categoryId;
	private String lastEditBy;
	private Date lastEditTime;
	
	public Productb() {
		
	}
	
	public Productb(int pId,String pName,String pMain,String pDetail, int price,int invantory
			, String pSize, String description, String sDescription, String cPhoto, String email,
			String userName, int categoryId) {
		this.pId=pId;
		this.pName=pName;
		this.pMain=pMain;
		this.pDetail=pDetail;
		this.price=price;
		this.invantory=invantory;
		this.pSize=pSize;
		this.description=description;
		this.sDescription=sDescription;
		this.cPhoto=cPhoto;
		this.email=email;
		this.userName=userName;
		this.categoryId=categoryId;
		this.lastEditBy= lastEditBy;
		this.lastEditTime= lastEditTime;
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

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public String getLastEditBy() {
		return lastEditBy;
	}

	public void setLastEditBy(String lastEditBy) {
		this.lastEditBy = lastEditBy;
	}

	public Date getLastEditTime() {
		return lastEditTime;
	}

	public void setLastEditTime(Date lastEditTime) {
		this.lastEditTime = lastEditTime;
	}

	
	
}
