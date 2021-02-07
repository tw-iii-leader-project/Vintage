package tw.leader.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.leader.po.LeaveMsgEntity;

public interface LeaveMsgRepository extends JpaRepository<LeaveMsgEntity, Long> {
	@Query(value = "select * from leaveMsg where pId = ?1", nativeQuery = true)
	List<LeaveMsgEntity> findByPId(Integer integer);
}
