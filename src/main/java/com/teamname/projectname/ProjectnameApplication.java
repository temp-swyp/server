package com.teamname.projectname;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ProjectnameApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectnameApplication.class, args);
	}

}
