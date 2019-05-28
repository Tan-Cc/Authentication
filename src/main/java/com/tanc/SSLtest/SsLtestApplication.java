package com.tanc.SSLtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.tanc.SSLtest"})
@EnableJpaRepositories(basePackages = "com.tanc.SSLtest.Repository")
public class SsLtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsLtestApplication.class, args);
	}

}
