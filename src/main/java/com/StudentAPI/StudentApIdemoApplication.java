package com.StudentAPI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;


import com.StudentAPI.Model.Student;

@SpringBootApplication
public class StudentApIdemoApplication extends SpringBootServletInitializer{

	@Override  
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application)   
	{  
	return application.sources(Student.class);  
	}  
	
	public static void main(String[] args) {
		SpringApplication.run(StudentApIdemoApplication.class, args);
		System.out.println("Appliction Running");
	}

}
