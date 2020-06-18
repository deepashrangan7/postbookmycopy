package com.cts.postbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.cts.postbook")
public class PostbookowncopyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostbookowncopyApplication.class, args);
	System.out.println("server started at 8080!!");
	}

}
