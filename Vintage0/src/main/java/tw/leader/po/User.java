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
	
	@Column(name = "roles")
	private String roles;
}
