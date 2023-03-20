package com.example.blog.Services;

import com.example.blog.DTOs.PostDTO;
import com.example.blog.Exceptions.APIException;
import com.example.blog.Exceptions.ResourceNotFoundException;
import com.example.blog.Mappers.CategoryMapper;
import com.example.blog.Mappers.PostMapper;
import com.example.blog.Repositories.CategoryRepository;
import com.example.blog.Repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService{

    private final PostRepository postRepository;
    private final PostMapper postMapper;
    private final CategoryMapper categoryMapper;
    private final CategoryRepository categoryRepository;

    @Override
    public PostDTO add(PostDTO postDTO) {
        var categoryId = postDTO.getCategory().getCategoryId();
        categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category", "id", Integer.toString(categoryId))
        );

        var post = postMapper.toEntity(postDTO);
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
    public PostDTO update(int postId, PostDTO postDTO) {
        var post = postRepository.findByPostId(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post", "id", Integer.toString(postId))
        );
        if(postDTO.getCategory() != null){
            var category = categoryRepository.findById(postDTO.getCategory().getCategoryId()).orElseThrow(
                    () -> new APIException("Category is invalid", HttpStatus.BAD_REQUEST)
            );
            post.setCategory(category);
        }

        post.setTitle(postDTO.getTitle());
        post.setContent(postDTO.getContent());
        post.setSummary(postDTO.getSummary());

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
