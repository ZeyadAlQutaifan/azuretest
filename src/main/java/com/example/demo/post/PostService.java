package com.example.demo.post;


import com.example.demo.post.models.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {
    @Autowired
    PostRepository postRepository ;
    public List<Post> findPostsByUserId(int id) {
      return   postRepository.findByUserId(id) ;
    }

    public Post createPost(Post post) {
        return postRepository.save(post);
    }

    public List<Post> findAllPosts() {
        return (List<Post>) postRepository.findAll();
    }
}
