package tw.leader.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "USERPIC")
@Data
public class UserPic {
	@Id
	@Column(name = "userPicId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userPicId;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "picture")
	private String picture;
	
	@Column(name = "uploadDate")
	private String uploadDate;

}
