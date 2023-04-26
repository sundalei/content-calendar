package com.example;

import java.time.LocalDateTime;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.model.Content;
import com.example.model.Status;
import com.example.model.Type;
import com.example.repository.ContentRepository;

@SpringBootApplication
public class ContentCalendarApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContentCalendarApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ContentRepository contentRepository) {
		return args -> {

			Content c = new Content(null,
                "Hello Chat GPT",
                "All about Chat GPT",
                Status.IDEA,
                Type.VIDEO,
                LocalDateTime.now(),
                null,
                "");

			contentRepository.save(c);
		};
	}

}
