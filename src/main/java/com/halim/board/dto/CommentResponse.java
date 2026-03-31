package com.halim.board.dto;

import com.halim.board.entity.CommentEntity;

public record CommentResponse(
        String content
) {
    public static CommentResponse from(CommentEntity commentEntity) {
        return new CommentResponse(
                commentEntity.getContent()
        );
    }
}
