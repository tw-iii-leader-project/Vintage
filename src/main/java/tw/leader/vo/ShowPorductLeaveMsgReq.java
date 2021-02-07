package tw.leader.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class ShowPorductLeaveMsgReq {

	@JsonProperty(value = "pId")
	private Integer pId;
}
