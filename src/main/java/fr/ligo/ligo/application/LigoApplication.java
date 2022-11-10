package fr.ligo.ligo.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication

@EntityScan(basePackages = { "fr.ligo.ligo.entities" })
@ComponentScan(basePackages = { "fr.ligo.ligo.services" })
//@EnableJpaRepositories(basePackages = { "" })
public class LigoApplication {

	public static void main(String[] args) {
		SpringApplication.run(LigoApplication.class, args);
	}

}
