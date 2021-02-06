package tw.leader.dao;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;

import tw.leader.po.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT u FROM userInfo AS u WHERE u.email = ?1")
	User findByEmail(String email);
			
}
