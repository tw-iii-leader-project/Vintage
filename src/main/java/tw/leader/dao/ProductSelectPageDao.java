package tw.leader.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import tw.leader.po.Product;

public interface ProductSelectPageDao extends PagingAndSortingRepository<Product, Integer> {

	@Query(value="select * from Product where user_acc = ?1",nativeQuery = true)
	Page<Product> selectProductPageByName(String user_acc,Pageable pageable);
	
	
}
