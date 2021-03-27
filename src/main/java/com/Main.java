package main.java.com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("main.java.com.controller," 
		+"main.java.com.service," 
		+"main.java.com.security,"
		+"main.java.com.dao"
		//+" com.global.jdbctemplate"
		)
public class Main extends SpringBootServletInitializer {
	public static void main(String[] args) {
		SpringApplication.run(Main.class, "");
	}
}
