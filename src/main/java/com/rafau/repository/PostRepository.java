package com.rafau.repository;

import com.rafau.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rafau on 2017-03-15.
 */
@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

    List<Post> findAllByOrderByDateDesc();
}
