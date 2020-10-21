package com.accenture.JavaQuestions;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.accenture")
public class JavaQuestionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaQuestionsApplication.class, args);
	}

}
