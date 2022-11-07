package com.mustache.bbs.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity // 엔티티 어노테이션을 붙여줘야 객체를 인식한다.
@NoArgsConstructor
@Getter
public class Article {

    @Id // Entity에는 대표값이 필요하다 대표값을 지정 고유의 값
    @GeneratedValue
    private Long id;

    private String title;
    private String content;

    public Article(String title, String content) {
        this.title = title;
        this.content = content;
    }

}