package tw.leader.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductResp extends ErrorResp{
	
	@JsonProperty(value="pId")
	private Integer pId;
	
	@JsonProperty(value="pName")
	private String pName;
	
	@JsonProperty(value="pMain")
	private String pMain;
	
	@JsonProperty(value="pDetail")
	private String pDetail;
	
	@JsonProperty(value="price")
	private int price;
	
	@JsonProperty(value="invantory")
	private int invantory;
	
	@JsonProperty(value="pSize")
	private String pSize;
	
	@JsonProperty(value="description")
	private String description;
	
	@JsonProperty(value="sDescription")
	private String sDescription;
	
	@JsonProperty(value="cPhoto")
	private String cPhoto;
	
	@JsonProperty(value="email")
	private String email;
	
	@JsonProperty(value="userName")
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
