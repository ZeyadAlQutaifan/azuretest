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
		return "<h2> Hello Nadia\n This is the first web service in my project </h2>" +
				"<br> <h2>I have decide to make the first end-point return Your name,</h2> " +
				"<h1>LOVE YOU</h1>";
	}
}
