package tw.leader.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.leader.po.User;
import tw.leader.po.userArticle;

public interface userArticleDao extends JpaRepository<userArticle, Integer> {

	@Query(value="select * from userArticle where email = ?1",nativeQuery = true)
	List<userArticle> selectUserArticle(String email);
	
	@Query(value="update userArticle set description = ?1 where email = ?2",nativeQuery = true)
	public userArticle updateUserDescription(String description,String email);
	
	@Query(value="update userArticle set articleContext = ?1 where email = ?2",nativeQuery = true)
	public userArticle updateUserArticle(String articleContext,String email);
	
	@Query("SELECT u FROM userInfo AS u WHERE u.email = ?1")
	userArticle findByEmail(String email);
	
}
