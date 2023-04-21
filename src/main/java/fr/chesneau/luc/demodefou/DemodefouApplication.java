package fr.chesneau.luc.demodefou;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "fr.chesneau.luc.demodefou.entities")
@EntityScan(basePackages = "fr.chesneau.luc.demodefou.entities")
public class DemodefouApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemodefouApplication.class, args);
	}

}
