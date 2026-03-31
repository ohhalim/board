package com.halim.board.dto;

import com.halim.board.entity.ArticleEntity;

public record ArticleResponse (
        String title,
        String content
) {
    public static ArticleResponse from(ArticleEntity entity) {
        return new ArticleResponse(
                entity.getTitle(),
                entity.getContent()
        );
    }
}
