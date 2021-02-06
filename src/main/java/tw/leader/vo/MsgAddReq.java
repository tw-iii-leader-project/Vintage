package tw.leader.vo;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class MsgAddReq {

	@JsonProperty(value ="USER_NAMES")
	private String userName;
	
	@JsonProperty(value ="MSG_CONTENT")
	private String msgContent;
	
	@JsonProperty(value ="LEAVE_TIME")
	private Timestamp leaveTime;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getMsgContent() {
		return msgContent;
	}

	public void setMsgContent(String msgContent) {
		this.msgContent = msgContent;
	}

	public Timestamp getLeaveTime() {
		return leaveTime;
	}

	public void setLeaveTime(Timestamp leaveTime) {
		this.leaveTime = leaveTime;
	}
	
	
}
