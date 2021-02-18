package tw.leader.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import tw.leader.po.Product;
import tw.leader.po.User;
import tw.leader.vo.UserResp;

public interface FindUserInfoDao extends JpaRepository<User,Long>  {

	@Query(value="select * from userInfo where email = ?1",nativeQuery = true)
	List<User> findAllDataByEmail(String email);
	
	@Query(value="select count(*) from userInfo",nativeQuery = true)
	int selectTotalUser();
	
//	@Query(value="select * from userInfo order by userId offset (?1)*12 rows fetch next 12 rows only",nativeQuery = true)
//	List<User> findAllUser(int page);
	
	@Query(value="select * from userInfo",nativeQuery = true)
	List<User> findAllUser();
	
	@Query(value="select * from userInfo where userName like %?1%",nativeQuery = true)
	List<User> findUserByName(String userName);
	
	@Query(value="select * from userInfo where userId like %?1%",nativeQuery = true)
	List<User> findUserById(int userId);
	
	@Query(value="select * from userInfo where email like %?1%",nativeQuery = true)
	List<User> findUserByEmail(String email);
	
	@Query(value="update userInfo set roles = ?1 where userId = ?2")
	UserResp upDateUserRoles(String roles,int userId);
	// update userInfo set roles = 'ROLES_123' where userId = 2;
}
