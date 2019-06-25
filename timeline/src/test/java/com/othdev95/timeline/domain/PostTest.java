package com.othdev95.timeline.domain;

import com.othdev95.timeline.Domain.Post;
import com.othdev95.timeline.repository.PostRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

@DataJpaTest
@RunWith(SpringRunner.class)
public class PostTest {
    @Autowired
    PostRepository postRepository;

    @Before
    public void init(){
        Post post = Post.builder().title("hiramji").content("asd").pTime(LocalDateTime.now()).build();
        postRepository.save(post);
    }

    @Test
    public void 포스트_저장_확인(){
        Post post = postRepository.findByTitle("hiramji");
        assertThat(post.getContent(),is("asd"));
    }
}
