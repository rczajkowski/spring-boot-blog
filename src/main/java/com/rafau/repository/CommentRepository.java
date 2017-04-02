package com.rafau.repository;

/**
 * Created by rafau on 2017-04-02.
 */

import com.rafau.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

    public List<Comment> findAllByUserId(Integer userId);

    public List<Comment> findAllByPostId(Integer postId);
}
