package com.example.blog.Services;

import com.example.blog.DTOs.CategoryDTO;

import java.util.List;

public interface ICategoryService {
    CategoryDTO add(CategoryDTO categoryDTO);
    CategoryDTO get(int id);
    List<CategoryDTO> getAll();
    CategoryDTO update(int categoryId, CategoryDTO categoryDTO);
    void delete(int categoryId);
}
