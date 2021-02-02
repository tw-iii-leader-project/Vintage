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
@Table(name="LEAVE_MSG")
@Data
public class LeaveMsgEntity implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="MSG_ID")
	private Long msgId;
	
	@Column(name="USER_NAMES")
	@NotNull
	private String userName;
	
	@Column(name="USER_PIC")
	@NotNull
	private String userPic;
	
	@Column(name="PRODUCT_ID")
	@NotNull
	private Long productId;
	
	@Column(name="MSG_CONTENT")
	@NotNull
	private String msgContent;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	@Column(name="LEAVE_TIME")
	@NotNull
	private Timestamp leaveTime;
	
	@Column(name="STAR_LV")
	@NotNull
	private Integer starLv;
	
}
