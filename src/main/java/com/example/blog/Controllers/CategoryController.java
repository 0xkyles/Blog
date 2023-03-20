package com.example.blog.Controllers;

import com.example.blog.DTOs.CategoryDTO;
import com.example.blog.Exceptions.SuccessMessage;
import com.example.blog.Services.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDTO> add(@RequestBody @Valid CategoryDTO categoryDTO) {
        return new ResponseEntity(categoryService.add(categoryDTO), HttpStatus.CREATED);
    }

    @GetMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> get(@PathVariable int categoryId) {
        return ResponseEntity.ok((categoryService.get(categoryId)));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAll() {
        return ResponseEntity.ok((categoryService.getAll()));
    }

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDTO> update(@PathVariable int categoryId, @RequestBody @Valid CategoryDTO categoryDTO) {
        return ResponseEntity.ok(categoryService.update(categoryId, categoryDTO));
    }

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<SuccessMessage> delete(@PathVariable int categoryId) {
        categoryService.delete(categoryId);
        return new ResponseEntity<>(new SuccessMessage(HttpStatus.OK.toString(), "Category has been deleted successfully"), HttpStatus.OK);
    }
}
