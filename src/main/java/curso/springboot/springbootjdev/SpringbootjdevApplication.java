package curso.springboot.springbootjdev;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EntityScan(basePackages = "curso.springboot.model")
@ComponentScan(basePackages = {"curso.*"})
@EnableJpaRepositories(basePackages = "curso.springboot.repository")
@EnableTransactionManagement
public class SpringbootjdevApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(SpringbootjdevApplication.class, args);
	}

}
