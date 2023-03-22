package com.example.blog.DTOs.Requests;

import com.example.blog.DTOs.CommentDTO;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import jakarta.validation.constraints.NegativeOrZero
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostRequest {
    @NotBlank(message = "title must not be blank")
    private String title;
    @NotBlank(message = "summary must not be blank")
    private String summary;
    @NotBlank(message = "summary must not be blank")
    private String content;
    @NegativeOrZero(message = "Post must belong to a valid category")
    private int categoryId;
    private Set<CommentDTO> comments;
}