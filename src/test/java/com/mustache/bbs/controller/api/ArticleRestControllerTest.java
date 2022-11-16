package com.mustache.bbs.controller.api;

import com.mustache.bbs.controller.web.ArticleController;
import com.mustache.bbs.domain.dto.ArticleDto;
import com.mustache.bbs.domain.dto.HospitalResponse;
import com.mustache.bbs.repository.ArticleRepository;
import com.mustache.bbs.service.ArticleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ArticleRestController.class)
class ArticleRestControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    ArticleService articleService;

    @Test
    void jsonResponse() throws Exception {
        ArticleDto articleDto = ArticleDto.builder()
                .id(3L)
                .title("bbb")
                .content("aaa")
                .build();

        Long articleId = 3L;
        given(articleService.getArticleById(articleId)).willReturn(articleDto);

        mockMvc.perform(
                        get("/api/v1/articles/" + articleId))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.title").exists())
                .andExpect(jsonPath("$.content").exists())
                .andDo(print());

        verify(articleService).getArticleById(articleId);
    }
}