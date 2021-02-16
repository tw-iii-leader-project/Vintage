package tw.leader.po;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "USERINFO")
@Data
public class User {
	@Id
	@Column(name = "userId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "userPwd")
	private String password;
	
	@Column(name = "userName")
	private String userName;
		
	@Column(name = "userBirthday")
	private String birthday;
	
	@Column(name = "userPhone")
	private String phone;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "verificationCode",updatable = false, length = 64)
	private String verificationCode;
	     
	private boolean enabled;
	
	@Column(name = "roles")
	private String roles;
	
	@Column(name = "createdTime", updatable = false)
	private Date createTime;
	
//	private String userMsg;

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
