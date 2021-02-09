package tw.leader.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tw.leader.po.Product;

public interface ProductSlideshowDao extends JpaRepository<Product,Integer> {

	@Query(value="select Top 4* from Product where email = ?1 order by pId desc",nativeQuery = true)
	List<Product> findSlideshowProduct(String email);
	// select Top 5* from product where email = '1003@gmail.com' order by pid desc;
}
