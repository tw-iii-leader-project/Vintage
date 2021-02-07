package tw.leader.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import tw.leader.po.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT u FROM userInfo AS u WHERE u.email = ?1")
	User findByEmail(String email);
	
//	@Query(value="select * from userInfo where email = ?1",nativeQuery = true)
//	List<User> findAllDataByEmail(String email);
}
