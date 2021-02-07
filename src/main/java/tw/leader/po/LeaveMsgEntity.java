package tw.leader.po;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name = "leaveMsg")
@Data
public class LeaveMsgEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "msgId")
	private Integer msgId;

	@Column(name = "email")
	private String email;
	
	@Column(name = "userName")
	@NotNull
	private String userName;

	@Column(name = "userPic")
	@NotNull
	private String userPic;

	@Column(name = "pId")
	@NotNull
	private Integer pId;

	@Column(name = "leaveMsgContent")
	@NotNull
	private String leaveMsgContent;

	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name = "leaveMsgTime")
	@NotNull
	private Timestamp leaveMsgTime;

	@Column(name = "starLv")
	@NotNull
	private Integer starLv;

}
