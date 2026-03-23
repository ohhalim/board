package com.halim.board.controller;

import com.halim.board.dto.ArticleRequest;
import com.halim.board.dto.ArticleResponse;
import com.halim.board.service.ArticleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class ArticleController {
    private final ArticleService articleService;

    @PostMapping("/posts")
    public ResponseEntity<ArticleResponse> createArticle(@Valid @RequestBody ArticleRequest articleRequest) {
        return ResponseEntity.ok(articleService.createArticle(articleRequest));
    }

    @GetMapping("/posts/{articleId}")
    public ResponseEntity<ArticleResponse> getArticleById(@PathVariable Long articleId) {
        return ResponseEntity.ok(articleService.getArticleById(articleId));
    }
}