package tw.leader.boot.domain;


public class Product {
	private int pid;
	private String pName;
	private String pMain;
	private String pDetail;
	private int price;
	private int invatory;
	private String pSize;
	private String Description;
	private String sDescription;
	private String cPhoto;
	private String email;
	private String userName;
	private int categoryId;
	
	public Product() {
		
	}
	
	public Product(int pId,String pName,String pMain,String pDetail, int price,int invantory
			, String pSize, String Description, String sDescription, String cPhoto, String email,
			String userName, int categoryId) {
		this.pid=pId;
		this.pName=pName;
		this.pMain=pMain;
		this.pDetail=pDetail;
		this.price=price;
		this.Description=Description;
		this.sDescription=sDescription;
		this.cPhoto=cPhoto;
		this.email=email;
		this.userName=userName;
		this.categoryId=categoryId;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
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

	public int getInvatory() {
		return invatory;
	}

	public void setInvatory(int invatory) {
		this.invatory = invatory;
	}

	public String getpSize() {
		return pSize;
	}

	public void setpSize(String pSize) {
		this.pSize = pSize;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
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
	

	public int getcategoryId() {
		return categoryId;
	}

	public void setcategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
}
