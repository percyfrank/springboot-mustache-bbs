package com.mustache.bbs.domain.dto;

import com.mustache.bbs.domain.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
@Builder
public class ArticleDto {

    private Long id;
    private String title;
    private String content;

    public Article toEntity() {
        return new Article(id,title, content);
    }

    public static ArticleDto of(Article article) {
        return ArticleDto.builder()
                .id(article.getId())
                .title(article.getTitle())
                .content(article.getTitle())
                .build();
    }
}
