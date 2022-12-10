package com.mustache.bbs.controller.api;

import com.mustache.bbs.domain.dto.ArticleAddRequest;
import com.mustache.bbs.domain.dto.ArticleAddResponse;
import com.mustache.bbs.domain.dto.ArticleDto;
import com.mustache.bbs.domain.entity.Article;
import com.mustache.bbs.repository.ArticleRepository;
import com.mustache.bbs.service.ArticleService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/articles")
public class ArticleRestController {

    private final ArticleService articleService;

    public ArticleRestController(ArticleService articleService) {
        this.articleService = articleService;
    }

    // 게시글 전체 조회
    @GetMapping("")
    public ResponseEntity<List<ArticleDto>> getAll(Pageable pageable) {
        return ResponseEntity.ok().body(articleService.findAllArticle(pageable));
    }

    // 게시글 1개 조회
    @GetMapping("/{id}")
    public ResponseEntity<ArticleDto> get(@PathVariable Long id) {
        ArticleDto articleDto = articleService.getArticleById(id);
        return ResponseEntity.ok().body(articleDto);
    }

    // 게시글 생성
    @PostMapping("")
    public ResponseEntity<ArticleAddResponse> add(@RequestBody ArticleAddRequest articleAddRequest) {
        ArticleAddResponse articleAddResponse = articleService.addArticle(articleAddRequest);
        return ResponseEntity.ok().body(articleAddResponse);
    }
}
