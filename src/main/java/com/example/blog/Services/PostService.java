package com.example.blog.Services;

import com.example.blog.DTOs.Requests.PostRequest;
import com.example.blog.DTOs.Response.PostDTO;
import com.example.blog.Exceptions.ResourceNotFoundException;
import com.example.blog.Mappers.PostMapper;
import com.example.blog.Repositories.CategoryRepository;
import com.example.blog.Repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService{

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public PostDTO add(PostRequest postRequest) {
        int categoryId = postRequest.getCategoryId();
        var category = categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category", "id", Integer.toString(categoryId))
        );

        var post = postMapper.objToEntity(postRequest);
        post.setCategory(category);
        return postMapper.toDTO(postRepository.save(post));
    }

    @Override
    public PostDTO get(int postId) {
        var post = postRepository.findByPostId(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", Integer.toString(postId))
        );
        return postMapper.toDTO(post);
    }

    @Override
    public List<PostDTO> getAll()  {
        var posts = postRepository.findAll();
        return posts.stream().map(postMapper::toDTO).toList();
    }

    @Override
    public PostDTO getByTitle(String title) {
        var post = postRepository.findByTitle(title).orElseThrow(
                () -> new ResourceNotFoundException("Post", "title", title)
        );
        return postMapper.toDTO(post);
    }

    @Override
    public PostDTO update(int postId, PostRequest updatedPost) {
        int categoryId = updatedPost.getCategoryId();
        var post = postRepository.findByPostId(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", Integer.toString(postId))
        );
        if(post.getCategory().getCategoryId() != categoryId){
            var category = categoryRepository.findById(categoryId).orElseThrow(
                    () -> new ResourceNotFoundException("Category", "id", Integer.toString(categoryId))
            );
            post.setCategory(category);
        }

        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());
        post.setSummary(updatedPost.getSummary());

        return postMapper.toDTO(postRepository.save(post));
    }

    @Override
    public void delete(int postId) {
        var post = postRepository.findByPostId(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", Integer.toString(postId))
        );
        postRepository.delete(post);
    }
}
