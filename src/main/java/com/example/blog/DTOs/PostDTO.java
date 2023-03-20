package com.example.blog.DTOs;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {
    private int postId;
    @NotBlank(message = "title must not be blank")
    private String title;
    @NotBlank(message = "summary must not be blank")
    private String summary;
    @NotBlank(message = "summary must not be blank")
    private String content;
    private CategoryDTO category;
    private Set<CommentDTO> comments;
}
