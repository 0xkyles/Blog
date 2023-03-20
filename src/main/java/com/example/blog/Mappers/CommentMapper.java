package com.example.blog.Mappers;

import com.example.blog.DTOs.CommentDTO;
import com.example.blog.Entites.Comment;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentMapper implements IMapper<Comment, CommentDTO>{
    private final ModelMapper modelMapper;

    @Override
    public Comment toEntity(CommentDTO d) {
        return modelMapper.map(d, Comment.class);
    }

    @Override
    public CommentDTO toDTO(Comment e) {
        return modelMapper.map(e, CommentDTO.class);
    }
}
