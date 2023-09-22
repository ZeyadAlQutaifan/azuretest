package com.example.demo.post;


import com.example.demo.post.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {
    @Autowired
    PostService postService ;

    @GetMapping("/")
    public List<Post> findAllPost(){
        return  postService.findAllPosts();
    }
    @GetMapping("/{id}")
    public List<Post> findPostsByUserId(@PathVariable int id){
        return  postService.findPostsByUserId(id) ;
    }

    @PostMapping("/save-post")
    public Post createPost(@RequestBody Post post){
        return  postService.createPost(post);
    }
}
