package com.othdev95.timeline.Domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long idx;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private LocalDateTime pTime;

    @Builder
    public Post(long idx, String title, String content, LocalDateTime pTime) {
        this.idx = idx;
        this.title = title;
        this.content = content;
        this.pTime = pTime;
    }
}

