package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {


        SpringApplication.run(DemoApplication.class, args);
    }

}

@RestController("/greeting")
class Test {

    @Autowired
    UsersRepository usersRepository;


    @GetMapping("/hello")
    public String hello() {
        return "<h2> Hello Nadia\n This is the first web service in my project </h2>" +
                "<br> <h2>I have decide to make the first end-point return Your name,</h2> " +
                "<h1>LOVE YOU</h1>";
    }

    @GetMapping("/users")
    public List<Users> getUsers() {
        return usersRepository.findAll();
    }


    @GetMapping("users/{userid}")
    public Optional<Users> getUser(@PathVariable int userid) {
        return usersRepository.findById(userid);
    }
}

@Table
class Users {
   @Id
   private int id;
    private String name;
    private String username;
    private String email;

    public Users(int id, String name, String username, String email) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}

class Post {
    private int id;
    private String title;
    private LocalDateTime creationDate;
    private String content;

    public Post(int id, String title, LocalDateTime creationDate, String content) {
        this.id = id;
        this.title = title;
        this.creationDate = creationDate;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

@Repository
interface UsersRepository extends CrudRepository<Users, Integer> {
    List<Users> findAll();
}