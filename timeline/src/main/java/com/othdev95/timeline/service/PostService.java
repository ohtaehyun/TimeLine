package com.othdev95.timeline.service;

import com.othdev95.timeline.Domain.Post;
import com.othdev95.timeline.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PostService {
    @Autowired
    private PostRepository pRepo;

    public Post findPostById(Long id){
        return pRepo.findById(id).orElse(new Post());
    }

    public Boolean saveNewPost(Post post){
        post.setPTime(LocalDateTime.now());
        pRepo.save(post);
        return true;
    }

    public List<Post> getPosts(){
        return pRepo.findAll();
    }
}
