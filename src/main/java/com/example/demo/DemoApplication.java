package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {


		SpringApplication.run(DemoApplication.class, args);
    }

}

@RestController("/greeting")
class Test {
	List<User> users = new ArrayList<>();

    @GetMapping("/hello")
    public String hello() {
        return "<h2> Hello Nadia\n This is the first web service in my project </h2>" +
                "<br> <h2>I have decide to make the first end-point return Your name,</h2> " +
                "<h1>LOVE YOU</h1>";
    }

    @GetMapping("/users")
    public List<User> getUsers() {
		int id = 0 ;
		users.add(new User(id ++ , "ahmad", "zeyad21kh", "zeyad@ze.com"));
		users.add(new User(id ++ , "mohammad", "aaaa", "zeyad@ze.com"));
		users.add(new User(id ++ , "ali", "ahd5ddf", "zeyad@ze.com"));
		users.add(new User(id ++ , "khalid", "id44fff", "zeyad@ze.com"));
		return users;
    }



}

class User {
	private int id ;
    private String name;
    private String username;
    private String email;
    public User(int id , String name, String username, String email) {
		this.id = id ;
        this.name = name;
        this.username = username;
        this.email = email;
    }
}