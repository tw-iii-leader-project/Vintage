package tw.leader.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.leader.po.userArticle;

public interface userArticleDao extends JpaRepository<userArticle, Integer> {

	@Query(value="select * from userArticle",nativeQuery = true)
	userArticle selectUserArticle(String email);
	
	
}
