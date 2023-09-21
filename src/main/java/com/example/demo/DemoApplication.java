package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}

@RestController("/greeting")
class Test{
	@GetMapping("/")
	public String greeting(){
		return "hello";
	}

	@GetMapping("/hello")
	public String hello(){
		return "Hello Nadia\n This is the first web service in my project \n I have decide to make the first end-point return Your name, \n LOVE YOU";
	}
}
