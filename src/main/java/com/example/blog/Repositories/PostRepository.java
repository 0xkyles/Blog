package com.example.blog.Repositories;

import com.example.blog.Entites.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
    Optional<Post> findByTitle(String title);
    Optional<Post> findByPostId(int postId);
}
