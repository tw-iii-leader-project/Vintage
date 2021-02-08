package tw.leader.dao;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import tw.leader.po.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	@Query("SELECT u FROM userInfo AS u WHERE u.email = ?1")
	User findByEmail(String email);
	
//	@Query(value="select * from userInfo where email = ?1",nativeQuery = true)
//	List<User> findAllDataByEmail(String email);
	
//	@Modifying
//	@Query("UPDATE userInfo as u SET u.userBirthday=?1, u.userPhone=?2, u.gender=?3 where u.email=?4")
//	User updateByEmail(String userBirthday, String userPhone, String gender, String email);
}
