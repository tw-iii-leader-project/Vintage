package com.vintage;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import tw.leader.dao.UserRepository;
import tw.leader.po.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
	
	@Autowired
	private UserRepository uRepo;
	
	@Autowired
	private TestEntityManager entityManager;
	
//	@Test
//	public void testCreateUser() {
//		User user = new User();
//		user.setEmail("jerry008@gmail.com");
//		user.setPassword("fireworks097");
//		user.setFirstName("Gordon");
//		user.setLastName("Ramsey");
//		
//		User savedUser = uRepo.save(user);
//		
//		User existUser = entityManager.find(User.class, savedUser.getId());
//		
//		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
//	}
	
	@Test
	public void testFindUserByEmail() {
		String email = "jerry0078@gmail.com";
		
		User user = uRepo.findByEmail(email);
		assertThat(user).isNotNull();
	}
	
//	@Test
//	public void testFindPasswordByEmail() {
//		String email = "jerry0078@gmail.com";
//		
//		User user = uRepo.findPasswordByEmail(email);
//		System.out.println(user.getPassword());
//		assertThat(user).isNotNull();
//	}
	
	
}
