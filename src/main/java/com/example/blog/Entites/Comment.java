package com.example.blog.Entites;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;

@Entity
@Data
@Table(name="comments")
public class Comment {
    @Id
    private int  commentId;
    @Column(nullable = false)
    private String body;
    @ManyToOne
    @JoinColumn(name="post_id", referencedColumnName = "postId", nullable = false)
    private Post post;

    private void setPost(Post post) {
        this.post = post;
        if(post.getComments() == null) {
            post.setComments(new HashSet<>());
        }

        post.getComments().add(this);
    }
}
