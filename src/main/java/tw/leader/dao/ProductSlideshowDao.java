package tw.leader.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.leader.po.Product;

public interface ProductSlideshowDao extends JpaRepository<Product,Integer> {

	
}
