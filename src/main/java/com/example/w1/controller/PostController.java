package com.example.w1.controller;

import com.example.w1.dto.PostRequestDto;
import com.example.w1.dto.PostResponseDto;
import com.example.w1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService){
        this.postService = postService;
    }

    @PostMapping("")
    public PostResponseDto createPost(PostRequestDto requestDto) {
        System.out.println(requestDto.toString());
        return postService.createPost(requestDto);
    }

    @GetMapping("/{postId}")
    public String getPost(@PathVariable Integer postId) {
        return "";
    }

    @PatchMapping("/{postId}")
    public String patchPost(@PathVariable Integer postId) {
        return "";
    }

    @DeleteMapping("/{postId}")
    public String deletePost(@PathVariable Integer postId) {
        return "";
    }

    @GetMapping("/all")
    public String getAllPost() {
        return "";
    }

}
