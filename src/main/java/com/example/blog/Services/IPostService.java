package com.example.blog.Services;

import com.example.blog.DTOs.Requests.PostRequest;
import com.example.blog.DTOs.Response.PostDTO;

import java.util.List;

public interface IPostService {
    PostDTO add(PostRequest post);

    PostDTO get(int id);

    List<PostDTO> getAll();

    PostDTO getByTitle(String title);

    PostDTO update(int postId, PostRequest postDTO);
    void delete(int postId);
}
