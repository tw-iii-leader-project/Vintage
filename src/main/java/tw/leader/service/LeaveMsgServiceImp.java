package tw.leader.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tw.leader.dao.LeaveMsgRepository;
import tw.leader.po.LeaveMsgEntity;
import tw.leader.vo.MsgAddReq;
import tw.leader.vo.MsgAddResp;

@Service
public class LeaveMsgServiceImp implements LeaveMsgService {

	@Autowired
	private LeaveMsgRepository leaveMsgRepository;

	/**
	 * 新增留言實作
	 * */
	@Override
	public MsgAddResp magAdd(MsgAddReq req) {
		leaveMsgRepository.save(setLeaveMsgEntity(req)); // 存進資料庫
		return setMsgAddResp(setLeaveMsgEntity(req)); // 回傳封裝成JSON的資料
	}
	
	/**
	 * 商品留言顯示
	 * */
	
	
	
	
	
	
	
	/**
	 * 前端JSON接到的資料從ApplyMemberReq存到MemberEntity
	 * 
	 * @param req
	 * @return
	 */
	private LeaveMsgEntity setLeaveMsgEntity(MsgAddReq req) {
		LeaveMsgEntity leaveMsgEntity = new LeaveMsgEntity();
		leaveMsgEntity.setUserName(req.getUserName());
		leaveMsgEntity.setMsgContent(req.getMsgContent());
		leaveMsgEntity.setLeaveTime(Timestamp.valueOf(LocalDateTime.now()));
		leaveMsgEntity.setUserPic(req.getUserPic());
		leaveMsgEntity.setProductId(req.getProductId());
		leaveMsgEntity.setStarLv(req.getStarLv());
		return leaveMsgEntity;
	}

	/**
	 * 把資料從LeaveMsgEntity存到MsgAddResp
	 * 
	 * @param memberEntity
	 * @return
	 * 
	 */
	private MsgAddResp setMsgAddResp(LeaveMsgEntity leaveMsgEntity) {
		MsgAddResp msgAddResp = new MsgAddResp();
		msgAddResp.setUserName(leaveMsgEntity.getUserName());
		msgAddResp.setMsgContent(leaveMsgEntity.getMsgContent());
		msgAddResp.setLeaveTime(leaveMsgEntity.getLeaveTime());
		msgAddResp.setUserPic(leaveMsgEntity.getUserPic());
		msgAddResp.setStarLv(leaveMsgEntity.getStarLv());
		return msgAddResp;
	}

}
