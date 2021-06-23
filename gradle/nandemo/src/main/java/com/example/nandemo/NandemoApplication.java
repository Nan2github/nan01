package com.example.nandemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
//@EnableScheduling

public class NandemoApplication  extends SpringBootServletInitializer implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(NandemoApplication.class);

	@Value("${spring.application.name}")
	private String name;

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(NandemoApplication.class);
	}

	public static void main(String[] args) {
		logger.info("--------this is an info message");
		logger.warn("--------this is a warn message");
		logger.debug("---------this is a debug essage");
		SpringApplication.run(NandemoApplication.class, args);
	}
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

	@RequestMapping(value = "/")
	public String hello() {
		return "Hello World, I am gradle from Tomcat";
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello world from CommandLine runner, gradle");
	}

	@RequestMapping(value = "/name")
	public String name(){
		return name;
	}
}
