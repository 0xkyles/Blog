package com.example.blog.Services;

import com.example.blog.DTOs.Requests.CategoryRequest;
import com.example.blog.DTOs.Response.CategoryDTO;

import java.util.List;

public interface ICategoryService {
    CategoryDTO add(CategoryRequest categoryDTO);
    CategoryDTO get(int id);
    List<CategoryDTO> getAll();
    CategoryDTO update(int categoryId, CategoryRequest categoryDTO);
    void delete(int categoryId);
}
