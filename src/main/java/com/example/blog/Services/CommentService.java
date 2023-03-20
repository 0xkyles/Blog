package com.example.blog.Services;

import com.example.blog.Mappers.CommentMapper;
import com.example.blog.Repositories.CommentRepository;
import com.example.blog.Repositories.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService implements ICommentService{
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
}
