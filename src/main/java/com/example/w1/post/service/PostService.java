package com.example.w1.post.service;

import com.example.w1.post.dto.*;
import com.example.w1.post.entity.Post;
import com.example.w1.post.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PostService {
    private final PostRepository postRepository;

    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public PostResponseDto createPost(PostCreateDto requestDto) {
        Post post = new Post(requestDto);
        Post savePost = postRepository.save(post);
        return new PostResponseDto(savePost);
    }

    public PostResponseDto getPostById(Long postId) {
        return new PostResponseDto(this.findPostById(postId));
    }

    @Transactional
    public PostResponseDto patchPost(Long postId, PostUpdateDto requestDto) {
        Post post = this.userValidateReturnPost(postId, requestDto);
        post.update(requestDto);
        return new PostResponseDto(post);
    }

    public Long deletePost(Long postId, PostDeleteDto requestDto) {
        userValidateReturnPost(postId, requestDto);
        postRepository.deleteById(postId);
        return postId;
    }

    public List<PostResponseDto> getAllPost() {
        return postRepository.findAllByOrderByCreatedAtAsc().stream().map(PostResponseDto::new).toList();
    }

    private Post findPostById(Long postId) {
        return postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("해당 PostId는 없습니다"));
//        return postRepository.getReferenceById(postId);
    }

    private Post userValidateReturnPost(Long postId, PostUserDto requestDto){
        Post post = this.findPostById(postId);
        if(!requestDto.getUsername().equals(post.getUsername()) || !requestDto.getPassword().equals(post.getPassword())) throw new IllegalArgumentException("잘못된 User 정보입니다.");
        return post;
    }
}
