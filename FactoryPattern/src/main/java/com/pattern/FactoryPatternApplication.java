package com.pattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.pattern.repository")
public class FactoryPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(FactoryPatternApplication.class, args);
	}

	@Bean
	public ProtoTypeFalse getProtoTypeFalse() {
		return new ProtoTypeFalse();
	}

	@Bean
	@Scope(scopeName = "prototype")
	public ProtoTypeTrue getProtoTypeTrue() {
		return new ProtoTypeTrue();
	}

}
