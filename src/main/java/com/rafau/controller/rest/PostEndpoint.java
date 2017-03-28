package com.rafau.controller.rest;

import com.rafau.model.Post;
import com.rafau.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by rafau on 2017-03-15.
 */
@RestController
public class PostEndpoint {

    private PostRepository postRepository;

    @Autowired
    public PostEndpoint(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping("/api/posts")
    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @GetMapping("/api/posts/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable Integer id) {
        Post post = postRepository.findOne(id);
        if (post != null)
            return ResponseEntity.ok(post);
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("api/posts")
    public ResponseEntity<?> savePost(@RequestBody Post post) {
        if (post.getId() != null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        Post PostToSave = postRepository.save(post);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{/id}").buildAndExpand(PostToSave.getId())
                .toUri();

        return ResponseEntity.created(location).body(post);
    }

    @DeleteMapping("api/posts/{id}")
    public ResponseEntity<?> deletePostById(@PathVariable Integer id) {
        Post postToDelete = postRepository.findOne(id);
        if (postToDelete == null) {
            System.out.println("Post not found");
            return ResponseEntity.notFound().build();
        }

        postRepository.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @PutMapping("api/posts/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable Integer id, @RequestBody Post post) {
        if (postRepository.findOne(id) == null) {
            System.out.println("Post with id " + id + " not found");
            return ResponseEntity.notFound().build();
        }

        postRepository.save(post);
        return ResponseEntity.ok().body(post);
    }
}