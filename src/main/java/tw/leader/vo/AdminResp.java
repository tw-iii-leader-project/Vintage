package tw.leader.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class AdminResp {

	@JsonProperty(value="ACTION_CODE")
	private String actionCode;
	
	@JsonProperty(value="MESSAGE")
	private String message;
}
