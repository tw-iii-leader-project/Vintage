package tw.leader.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserResp {

	@JsonProperty(value="userId")
	private int userId;
	
	@JsonProperty(value="email")
	private String email;
	
	@JsonProperty(value="userPwd")
	private String password;
	
	@JsonProperty(value="userName")
	private String userName;
		
	@JsonProperty(value="userBirthday")
	private String birthday;
	
	@JsonProperty(value="userPhone")
	private String phone;
	
	@JsonProperty(value="gender")
	private String gender;
	
	@JsonProperty(value="roles")
	private String roles;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}
	
	
}
