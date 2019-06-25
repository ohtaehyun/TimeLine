package com.othdev95.timeline.service;


import com.othdev95.timeline.Domain.Post;
import com.othdev95.timeline.repository.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostServiceTest {
    @Autowired
    PostRepository postRepository;

    @Autowired
    PostService pService;
    @Test
    public void 포스트_생성_확인(){
        Post p1 = Post.builder().title("hi").content("asd").pTime(LocalDateTime.now()).build();
        pService.saveNewPost(p1);
        Post p = pService.findPostById(p1.getIdx());

        assertThat(p.getTitle(),is("hi"));
        System.out.println("!!!!!!!!"+p.getTitle());
    }
}
