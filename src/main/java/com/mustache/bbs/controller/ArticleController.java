package com.mustache.bbs.controller;

import com.mustache.bbs.domain.dto.ArticleDto;
import com.mustache.bbs.domain.entity.Article;
import com.mustache.bbs.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/articles")
@Slf4j
public class ArticleController {

    private final ArticleRepository articleRepository;

    public ArticleController(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    @GetMapping(value = "/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping(value = "/posts")
    public String createArticle(ArticleDto form) {
        log.info(form.toString());

        // 1. Dto를 Entity로 변환
        Article articleEntity = form.toEntity();
        log.info(articleEntity.toString());

        // 2. Repository에게 Entity를 DB에 저장하게 한다.
        Article saved = articleRepository.save(articleEntity);
        log.info(saved.toString());

        return "redirect:/articles/" + saved.getId();
    }
}
