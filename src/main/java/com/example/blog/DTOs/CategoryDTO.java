package com.example.blog.DTOs;

import com.example.blog.Entites.Post;
import jakarta.persistence.CascadeType;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private int categoryId;
    @NotBlank(message = "label must not be blank")
    private String label;
}
