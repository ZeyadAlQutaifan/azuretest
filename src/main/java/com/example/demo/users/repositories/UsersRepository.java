package com.example.demo.users.repositories;

import com.example.demo.users.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository extends  CrudRepository<User , Integer> {
    User findByEmail(String email) ;
}
