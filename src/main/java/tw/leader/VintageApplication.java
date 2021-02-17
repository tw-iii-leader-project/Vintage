package tw.leader;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@MapperScan(basePackages = "tw.leader.boot.mapper")
@EnableTransactionManagement
public class VintageApplication {

	public static void main(String[] args) {
		SpringApplication.run(VintageApplication.class, args);
	}

}
