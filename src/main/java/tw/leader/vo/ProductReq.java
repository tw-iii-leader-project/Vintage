package tw.leader.vo;


import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductReq {
	
	@JsonProperty(value="p_id")
	private Integer p_id;
	
	@JsonProperty(value="p_name")
	private String p_name;
	
	@JsonProperty(value="p_main")
	private String p_main;
	
	@JsonProperty(value="p_detail")
	private String p_detail;
	
	@JsonProperty(value="price")
	private int price;
	
	@JsonProperty(value="invantory")
	private int invantory;
	
	@JsonProperty(value="description")
	private String description;
	
	@JsonProperty(value="s_description")
	private String s_description;
	
	@JsonProperty(value="p_img")
	private String p_img;
	
	@JsonProperty(value="user_acc")
	private String user_acc;

	public Integer getP_id() {
		return p_id;
	}

	public void setP_id(Integer p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_main() {
		return p_main;
	}

	public void setP_main(String p_main) {
		this.p_main = p_main;
	}

	public String getP_detail() {
		return p_detail;
	}

	public void setP_detail(String p_detail) {
		this.p_detail = p_detail;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getS_description() {
		return s_description;
	}

	public void setS_description(String s_description) {
		this.s_description = s_description;
	}

	public String getP_img() {
		return p_img;
	}

	public void setP_img(String p_img) {
		this.p_img = p_img;
	}

	public String getUser_acc() {
		return user_acc;
	}

	public void setUser_acc(String user_acc) {
		this.user_acc = user_acc;
	}

}
