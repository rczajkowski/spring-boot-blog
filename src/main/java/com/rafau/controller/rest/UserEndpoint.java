package com.rafau.controller.rest;

import com.rafau.model.User;
import com.rafau.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by rafau on 2017-04-06.
 */
@RestController
public class UserEndpoint {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/users")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @GetMapping("/api/users/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String username){
        User user = userRepository.findByUsername(username);

        if(user == null)
            return ResponseEntity.notFound().build();

        return ResponseEntity.ok(user);
    }

    @PostMapping("/api/users")
    public ResponseEntity<?> addUser(@RequestBody User user){
        if(user.getId() != null)
            return ResponseEntity.status(HttpStatus.CONFLICT).build();

        User userSaved = userRepository.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{username}")
                .buildAndExpand(userSaved.getUsername())
                .toUri();

        return ResponseEntity.created(location).body(user);
    }

    @PutMapping("/api/users/{username}")
    public ResponseEntity<?> updateUser(@PathVariable String username, @RequestBody User user){
        if(userRepository.findByUsername(username) == null)
            ResponseEntity.notFound().build();

        userRepository.save(user);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/api/users/{username}")
    public ResponseEntity<?> deleteUser(@PathVariable String username){
        User userToDelete = userRepository.findByUsername(username);

        if(userToDelete == null)
            return ResponseEntity.notFound().build();

        userRepository.delete(userToDelete);
        return ResponseEntity.noContent().build();
    }
}