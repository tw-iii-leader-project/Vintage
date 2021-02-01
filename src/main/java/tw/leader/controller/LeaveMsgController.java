package tw.leader.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tw.leader.service.LeaveMsgService;
import tw.leader.vo.MsgAddReq;
import tw.leader.vo.MsgAddResp;
import tw.leader.vo.ShowPorductLeaveMsgReq;
import tw.leader.vo.ShowPorductLeaveMsgResp;

@RestController
@RequestMapping(value="/api/leaveMsg")
public class LeaveMsgController {

	@Autowired
	public LeaveMsgService leaveMsgService;
	
	@PostMapping(value="/msgAdd")
	public MsgAddResp msgAdd(@RequestBody MsgAddReq req) {
		return leaveMsgService.magAdd(req);
	} 
	
	@PostMapping(value="/showLeaveMsg")
	public ShowPorductLeaveMsgResp showLeaveMsg(@RequestBody ShowPorductLeaveMsgReq productId) {
		return leaveMsgService.showLeaveMsg(productId);
	}
	
}
