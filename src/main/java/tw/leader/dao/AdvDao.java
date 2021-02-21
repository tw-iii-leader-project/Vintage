package tw.leader.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.leader.po.AdvMain;

public interface AdvDao extends JpaRepository<AdvMain, Integer> {

	@Query(value="select * from AdvMain where Seat = ?1",nativeQuery = true)
	List<AdvMain> findAdvMain(int seat);
	
	@Query(value="select * from AdvMain where Seat = ?1",nativeQuery = true)
	AdvMain findBySeat(int seat);
	
}
