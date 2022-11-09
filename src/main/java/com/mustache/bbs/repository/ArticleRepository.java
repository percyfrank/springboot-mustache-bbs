package com.mustache.bbs.repository;

import com.mustache.bbs.domain.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
    // <관리대상엔티티, 대표값의 타입(Article의 대표값 id의 타입은 long)> 입력
}