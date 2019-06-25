package com.othdev95.timeline.runner;

import com.othdev95.timeline.Domain.Post;
import com.othdev95.timeline.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class PostInputRunner implements CommandLineRunner {
    @Autowired
    PostService pService;
    @Override
    public void run(String... args) throws Exception {
        pService.saveNewPost(Post.builder().title("A").content("a").build());
        pService.saveNewPost(Post.builder().title("B").content("b").build());
        pService.saveNewPost(Post.builder().title("C").content("c").build());
    }
}
