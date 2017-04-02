package com.rafau.controller.rest;

import com.rafau.model.Comment;
import com.rafau.model.User;
import com.rafau.repository.CommentRepository;

import com.rafau.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

/**
 * Created by rafau on 2017-04-02.
 */
@RestController
public class CommentEndpoint {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/api/{postId}/comments")
    public List<Comment> getAllCommentsByPostId(@PathVariable Integer postId){
        return commentRepository.findAllByPostIdOrderByDateDesc(postId);
    }

    @GetMapping("/api/{username}/comments")
    public List<Comment> getAllCommentsByUserId(@PathVariable String username){
        return commentRepository.findAllByUserUsernameOrderByDateDesc(username);
    }

    @PostMapping("api/{username}/comments")
    public ResponseEntity<?> addComment(@PathVariable String username, @RequestBody Comment comment){
        User user = userRepository.findByUsername(username);

        if(user == null)
            return ResponseEntity.notFound().build();

        comment.setUser(user);

        Comment commentSaved = commentRepository.save(comment);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(commentSaved.getId()).toUri();

        return ResponseEntity.created(location).body(comment);
    }

    @PutMapping("api/comments/{id}")
    public ResponseEntity<Comment> editComment(@PathVariable Integer id, @RequestBody Comment comment){
        if(commentRepository.findOne(id) == null)
            return ResponseEntity.notFound().build();

        commentRepository.save(comment);
        return ResponseEntity.ok().body(comment);
    }

    @DeleteMapping("api/comments/{id}")
    public ResponseEntity<?> deleteComment(@PathVariable Integer id){
        Comment commentToDelete = commentRepository.findOne(id);

        if(commentToDelete == null)
            return ResponseEntity.notFound().build();

        commentRepository.delete(commentToDelete);
        return ResponseEntity.noContent().build();
    }
}