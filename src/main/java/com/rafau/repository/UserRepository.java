package com.rafau.repository;

import com.rafau.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by rafau on 2017-04-02.
 */
public interface UserRepository extends JpaRepository<User, Integer>{
    public User findByUsername(String username);
}
