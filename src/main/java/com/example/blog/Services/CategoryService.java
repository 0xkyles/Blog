package com.example.blog.Services;

import com.example.blog.DTOs.Requests.CategoryRequest;
import com.example.blog.DTOs.Response.CategoryDTO;
import com.example.blog.Exceptions.ResourceNotFoundException;
import com.example.blog.Mappers.CategoryMapper;
import com.example.blog.Repositories.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService{
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;
    @Override
    public CategoryDTO add(CategoryRequest categoryRequest) {
        var category = categoryRepository.save(categoryMapper.objToEntity(categoryRequest));
        return categoryMapper.toDTO(category);
    }

    @Override
    public CategoryDTO get(int id) {
        var category = categoryRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Category", "id", Integer.toString(id))
        );
        return categoryMapper.toDTO(category);
    }

    @Override
    public List<CategoryDTO> getAll() {
        var categories = categoryRepository.findAll();
        return categories.stream().map(categoryMapper::toDTO).toList();
    }

    @Override
    public CategoryDTO update(int categoryId, CategoryRequest categoryRequest) {
        var category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category", "id", Integer.toString(categoryId))
        );

        category.setLabel(categoryRequest.getLabel());
        return categoryMapper.toDTO(categoryRepository.save(category));
    }

    @Override
    public void delete(int categoryId) {
        var category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category", "id", Integer.toString(categoryId))
        );
        categoryRepository.delete(category);
    }


}
