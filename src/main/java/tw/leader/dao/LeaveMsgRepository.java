package tw.leader.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.leader.po.LeaveMsgEntity;

public interface LeaveMsgRepository extends JpaRepository<LeaveMsgEntity, Long> {
	
}
