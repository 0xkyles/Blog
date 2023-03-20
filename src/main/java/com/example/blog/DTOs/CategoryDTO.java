package com.example.blog.DTOs;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDTO {
    private int categoryId;
    @NotBlank(message = "label must not be blank")
    private String label;
}
