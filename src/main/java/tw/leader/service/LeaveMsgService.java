package tw.leader.service;

import tw.leader.vo.MsgAddReq;
import tw.leader.vo.MsgAddResp;

public interface LeaveMsgService {
	/**
	 * 新增留言
	 * 
	 * @param req
	 * @return
	 * */
	public MsgAddResp magAdd(MsgAddReq req);
	
	/**
	 *顯示商品留言 
	 * 
	 * @param 
	 * @return
	 * */
	
}
