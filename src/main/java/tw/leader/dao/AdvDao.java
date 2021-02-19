package tw.leader.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.leader.po.AdvMain;

public interface AdvDao extends JpaRepository<AdvMain, Integer> {

	@Query(value="select * from AdvMain",nativeQuery = true)
	List<AdvMain> findAdvMain();
	
}
