package com.example.blog.Services;

import com.example.blog.DTOs.PostDTO;
import com.example.blog.Mappers.CategoryMapper;

import java.util.List;

public interface IPostService {
    PostDTO add(PostDTO post);

    PostDTO get(int id);

    List<PostDTO> getAll();

    PostDTO getByTitle(String title);

    PostDTO update(int postId, PostDTO postDTO);
    void delete(int postId);
}
