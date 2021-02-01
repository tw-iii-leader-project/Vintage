package tw.leader.vo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import tw.leader.po.LeaveMsgEntity;

@Data
public class ShowPorductLeaveMsgResp {
	
	
	@JsonProperty(value="LeaveMsgList")
	private List<LeaveMsgEntity> leaveMsgList;

}
