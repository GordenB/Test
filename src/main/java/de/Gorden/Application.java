package de.Gorden;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import ch.qos.logback.core.db.dialect.MySQLDialect;

@SpringBootApplication
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(MyConfig.class, args);

	}

}
