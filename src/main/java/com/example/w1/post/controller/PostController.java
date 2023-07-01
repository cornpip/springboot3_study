package com.example.w1.post.controller;

import com.example.w1.post.dto.PostCreateDto;
import com.example.w1.post.dto.PostDeleteDto;
import com.example.w1.post.dto.PostResponseDto;
import com.example.w1.post.dto.PostUpdateDto;
import com.example.w1.post.service.PostService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
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
    public PostResponseDto patchPost(@PathVariable Long postId, @Valid PostUpdateDto requestDto, BindingResult bindingResult) {
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if (fieldErrors.size() > 0) throw new IllegalArgumentException("Dto fail");
//        System.out.println(requestDto);
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

}
