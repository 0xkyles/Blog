package com.example.blog.Controllers;

import com.example.blog.DTOs.Requests.PostRequest;
import com.example.blog.DTOs.Response.PostDTO;
import com.example.blog.DTOs.Response.SuccessMessage;
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
    public ResponseEntity<PostDTO> add(@RequestBody @Valid PostRequest postRequest) {
        return new ResponseEntity<>(postService.add(postRequest), HttpStatus.CREATED);
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
    public ResponseEntity<PostDTO> update(@PathVariable int postId, @RequestBody @Valid PostRequest postRequest) {
        return new ResponseEntity<>(postService.update(postId, postRequest), HttpStatus.OK);
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<SuccessMessage> delete(@PathVariable int postId) {
        postService.delete(postId);
        return new ResponseEntity<>(new SuccessMessage(HttpStatus.OK.toString(), "Post deleted successfully"), HttpStatus.OK);
    }
}
