package com.example.blog.DTOs.Response;

import com.example.blog.DTOs.CommentDTO;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private int postId;
    private String title;
    private String summary;
    private String content;
    private CategoryDTO category;
    private Set<CommentDTO> comments;
}
