package com.crud.h2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class CrudSpringBootH2Application implements CommandLineRunner  {
	
	@Autowired
	private JdbcTemplate template;
	
	public static void main(String[] args) {
		SpringApplication.run(CrudSpringBootH2Application.class, args);
	}

	public void run(String... args) throws Exception {
		template.execute("DROP TABLE PERSONA IF EXISTS");
		template.execute("CREATE TABLE PERSONA(id INTEGER(11) PRIMARY KEY auto_increment,name VARCHAR(255))");
		
		for (int i = 0; i < 3; i++) {
			template.update("insert into persona(name)values('Persona 000"+i+"')");
		}
		
	}

}
