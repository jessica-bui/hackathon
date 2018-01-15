package com.company.hackathon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.company.hackathon.config.ControllerConfig;
import com.company.hackathon.config.HttpClientConfig;

@SpringBootApplication(scanBasePackages = "com.company.hackathon")
@EnableTransactionManagement
@EnableJpaRepositories("com.company.hackathon.dao")
@EntityScan("com.company.hackathon.entity")
@Import({ ControllerConfig.class, HttpClientConfig.class })
public class HackathonRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(HackathonRestApplication.class, args);
	}
}
