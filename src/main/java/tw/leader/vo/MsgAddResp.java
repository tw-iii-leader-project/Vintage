package tw.leader.vo;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MsgAddResp {
	
	@JsonProperty(value = "userName")
	private String userName;
	
	@JsonProperty(value = "leaveMsgContent")
	private String leaveMsgContent;

	@JsonProperty(value = "leaveMsgTime")
	private Timestamp leaveMsgTime;

	@JsonProperty(value = "starLv")
	private Integer starLv;
}
