package io.project.Adminlogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@CrossOrigin(origins="*")
public class AdminloginApplication {

	
	@GetMapping("/")
	public String login(){
		return "authenticated successfully" ;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AdminloginApplication.class, args);
	}

}
