package com.example.blog.Mappers;

import com.example.blog.DTOs.CommentDTO;
import com.example.blog.DTOs.PostDTO;
import com.example.blog.Entites.Comment;
import com.example.blog.Entites.Post;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PostMapper implements IMapper<Post, PostDTO>{
    private final ModelMapper modelMapper;

    @Override
    public Post toEntity(PostDTO d) {
        return modelMapper.map(d, Post.class);
    }

    @Override
    public PostDTO toDTO(Post e) {
        return modelMapper.map(e, PostDTO.class);
    }
}
