package com.halim.board.service;

import com.halim.board.dto.ArticleRequest;
import com.halim.board.dto.ArticleResponse;
import com.halim.board.entity.ArticleEntity;
import com.halim.board.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional
    public ArticleResponse createArticle(ArticleRequest articleRequest) {
        ArticleEntity article = new ArticleEntity(articleRequest.title(), articleRequest.content());
        ArticleEntity savedArticle = articleRepository.save(article);
        return ArticleResponse.from(savedArticle);
    }

    public ArticleResponse getArticleById(Long articleId) {
        ArticleEntity article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 없습니다."));
        return ArticleResponse.from(article);
    }
}
