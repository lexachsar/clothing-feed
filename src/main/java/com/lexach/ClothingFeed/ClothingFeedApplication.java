package com.lexach.ClothingFeed;

import com.lexach.ClothingFeed.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ClothingFeedApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClothingFeedApplication.class, args);
	}
}
