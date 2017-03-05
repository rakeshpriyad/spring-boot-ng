package com.test.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import com.test.springboot.configuration.JpaConfiguration;


@Import(JpaConfiguration.class)
@SpringBootApplication(scanBasePackages={"com.test.springboot"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class SpringBootNGApp {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootNGApp.class, args);
	}
}
