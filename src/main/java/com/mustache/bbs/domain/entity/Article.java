package com.mustache.bbs.domain.entity;

import com.mustache.bbs.domain.dto.ArticleDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;

@Entity // 엔티티 어노테이션을 붙여줘야 객체를 인식한다.
@Table(name = "article2")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
public class Article {

    @Id // Entity에는 대표값이 필요하다 대표값을 지정 고유의 값
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    public static ArticleDto of(Article article) {
        return new ArticleDto(article.getId(), article.getTitle(), article.getContent());
    }

}