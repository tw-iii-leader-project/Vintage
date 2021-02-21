package tw.leader.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.leader.po.User;

public interface UserPicRepository extends JpaRepository<User, Long> {

	@Query(value = "select * from userInfo where email =?1", nativeQuery = true)
	User findPicByEmail(String email);
}
