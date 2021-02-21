package tw.leader.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserPicResp {

	@JsonProperty(value = "userPic")
	private String userPic;
}
