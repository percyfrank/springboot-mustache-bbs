package com.mustache.bbs.service;

import com.mustache.bbs.domain.dto.ArticleAddRequest;
import com.mustache.bbs.domain.dto.ArticleAddResponse;
import com.mustache.bbs.domain.dto.ArticleDto;
import com.mustache.bbs.domain.entity.Article;
import com.mustache.bbs.repository.ArticleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    public final ArticleRepository articleRepository;

    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public List<ArticleDto> findAllArticle(Pageable pageable) {
        Page<Article> articles = articleRepository.findAll(pageable);
        return articles.stream().map(ArticleDto::of).collect(Collectors.toList());
    }

    public ArticleDto getArticleById(Long id) {
        Article article = articleRepository.findById(id).orElseThrow(() -> new RuntimeException("해당 article이 없습니다."));
        return ArticleDto.of(article);

//        Optional<Article> optArticle = articleRepository.findById(id);
//        Article article = optArticle.get();
//        ArticleDto articeDto = Article.of(article);
//        return articeDto;
    }

    public ArticleAddResponse addArticle(ArticleAddRequest articleAddRequest) {
        Article articleEntity = articleAddRequest.toEntity();
        Article savedArticle = articleRepository.save(articleEntity);

        return ArticleAddResponse.of(savedArticle);
    }
}
