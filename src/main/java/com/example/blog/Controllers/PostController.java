package com.example.blog.Controllers;

import com.example.blog.DTOs.PostDTO;
import com.example.blog.Exceptions.SuccessMessage;
import com.example.blog.Services.IPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/posts")
public class PostController {
    private final IPostService postService;

    @PostMapping
    public ResponseEntity<PostDTO> add(@RequestBody @Valid PostDTO post) {
        return new ResponseEntity<>(postService.add(post), HttpStatus.CREATED);
    }

    @GetMapping("/{postId}")
    public ResponseEntity<PostDTO> get(@PathVariable int postId) {
        return new ResponseEntity<>(postService.get(postId), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<PostDTO>> getAll() {
        return new ResponseEntity<>(postService.getAll(), HttpStatus.OK);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<PostDTO> update(@PathVariable int postId, @RequestBody @Valid PostDTO postDTO) {
        return new ResponseEntity<>(postService.update(postId, postDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<SuccessMessage> delete(@PathVariable int postId) {
        postService.delete(postId);
        return new ResponseEntity<>(new SuccessMessage(HttpStatus.OK.toString(), "Post deleted successfully"), HttpStatus.OK);
    }
}
