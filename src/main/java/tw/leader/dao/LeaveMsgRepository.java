package tw.leader.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.leader.po.LeaveMsgEntity;

public interface LeaveMsgRepository extends JpaRepository<LeaveMsgEntity, Long> {
	
	@Query(value="select * from LEAVE_MSG where PRODUCT_ID = ?1", nativeQuery = true)
	List<LeaveMsgEntity> findByProductId(Long productId);
}
