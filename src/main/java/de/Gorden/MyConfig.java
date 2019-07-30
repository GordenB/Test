package de.Gorden;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("de.Gorden")
@PropertySource("classpath:countries.properties")
public class MyConfig {

	
}
