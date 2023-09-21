package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
        for (int i = 1; i <= 20; i++) {
            List<Post> posts = generatePosts(10); // Generate at least 10 posts
            User user = new User(i, "User" + i, "Username" + i, "user" + i + "@example.com", posts);
            users.add(user);
        }
		return users;
    }

@GetMapping("users/{userid}")
public User getUser(@PathVariable int userid){
        for( User user : users){
            if(user.getId() == userid){
                return user;
            }
        }
        return  null ;
}
    // Helper method to generate random posts
    private static List<Post> generatePosts(int count) {
        List<Post> posts = new ArrayList<>();
        Random random = new Random();

        for (int i = 1; i <= count; i++) {
            int postId = random.nextInt(1000); // Generate a random post ID
            String title = "Post " + i;
            LocalDateTime creationDate = LocalDateTime.now(); // Use the current date/time
            String content = "This is the content of Post " + i;

            Post post = new Post(postId, title, creationDate, content);
            posts.add(post);
        }

        return posts;
    }
}

class User {
	private int id ;
    private String name;
    private String username;
    private String email;
    private List<Post> posts ;
    public User(int id, String name, String username, String email, List<Post> posts) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.posts = posts;
    }


    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
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

class Post{
    private int id ;
    private String title ;
    private LocalDateTime creationDate  ;
    private String content ;

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