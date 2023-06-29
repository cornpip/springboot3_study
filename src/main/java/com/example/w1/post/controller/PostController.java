package com.example.w1.post.controller;

import com.example.w1.exception.dto.ExceptionResponseDto;
import com.example.w1.post.dto.*;
import com.example.w1.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping("")
    public PostResponseDto createPost(PostCreateDto requestDto) {
        return postService.createPost(requestDto);
    }

    @GetMapping("/{postId}")
    public PostResponseDto getPost(@PathVariable Long postId) {
        return postService.getPostById(postId);
    }

    @PatchMapping("/{postId}")
    public PostResponseDto patchPost(@PathVariable Long postId, PostUpdateDto requestDto) {
        return postService.patchPost(postId, requestDto);
    }

    @DeleteMapping("/{postId}")
    public Long deletePost(@PathVariable Long postId, PostDeleteDto requestDto) {
        return postService.deletePost(postId, requestDto);
    }

    @GetMapping("/all")
    public List<PostResponseDto> getAllPost() {
        return postService.getAllPost();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ExceptionResponseDto> postExceptionHandler(IllegalArgumentException e){
        HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
        ExceptionResponseDto response = new ExceptionResponseDto(httpStatus, e.getMessage());
        return new ResponseEntity<>(response, httpStatus);
    }

}
