package com.othdev95.timeline.repository;

import com.othdev95.timeline.Domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post,Long> {
    Post findByTitle(String Title);
}
