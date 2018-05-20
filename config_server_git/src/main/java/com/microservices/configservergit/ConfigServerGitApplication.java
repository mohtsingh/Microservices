package com.microservices.configservergit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableConfigServer
@ComponentScan(basePackages="com.microservices")
public class ConfigServerGitApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerGitApplication.class, args);
	}
}