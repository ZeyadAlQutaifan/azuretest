package com.example.demo.post;

import com.example.demo.post.models.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepository extends CrudRepository<Post, Integer> {
    List<Post> findByUserId(Integer userID);
}
