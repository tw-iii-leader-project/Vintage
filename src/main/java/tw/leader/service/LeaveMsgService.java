package tw.leader.service;

import tw.leader.vo.MsgAddReq;
import tw.leader.vo.MsgAddResp;
import tw.leader.vo.ShowPorductLeaveMsgReq;
import tw.leader.vo.ShowPorductLeaveMsgResp;

public interface LeaveMsgService {
	/**
	 * 新增留言
	 * 
	 * @param req
	 * @return
	 * */
	public MsgAddResp magAdd(MsgAddReq req);
	
	/**
	 *載入頁面時顯示該商品留言 
	 * 
	 * @param req
	 * @return
	 * */
	public ShowPorductLeaveMsgResp showLeaveMsg(ShowPorductLeaveMsgReq productId);
}
