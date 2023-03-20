package com.example.blog.Mappers;

import com.example.blog.DTOs.CategoryDTO;
import com.example.blog.Entites.Category;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class CategoryMapper implements IMapper<Category, CategoryDTO> {
    private final ModelMapper modelMapper;

    @Override
    public Category toEntity(CategoryDTO d) {
        return modelMapper.map(d, Category.class);
    }

    @Override
    public CategoryDTO toDTO(Category e) {
        return modelMapper.map(e, CategoryDTO.class);
    }
}
