package tw.leader.vo;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MsgAddResp {
	
	@JsonProperty(value ="USER_NAMES")
	private String userName;
	
	@JsonProperty(value ="USER_PIC")
	private String userPic;
	
	@JsonProperty(value ="PRODUCT_ID")
	private Long productId;
	
	@JsonProperty(value ="MSG_CONTENT")
	private String msgContent;
	
	@JsonProperty(value ="LEAVE_TIME")
	@JsonFormat(pattern = "dd-MM-yyyy ")
	private Timestamp leaveTime;
	
	@JsonProperty(value ="STAR_LV")
	private Integer starLv;


}
