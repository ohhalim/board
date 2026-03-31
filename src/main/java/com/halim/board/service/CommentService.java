package com.halim.board.service;

import com.halim.board.dto.CommentRequest;
import com.halim.board.dto.CommentResponse;
import com.halim.board.entity.CommentEntity;
import com.halim.board.entity.ArticleEntity;
import com.halim.board.repository.ArticleRepository;
import com.halim.board.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CommentService {
    private final ArticleRepository articleRepository;
    private final CommentRepository commentRepository;

    @Transactional
    public CommentResponse createComment(Long articleId, CommentRequest commentRequest) {
        ArticleEntity article = articleRepository.findById(articleId)
                .orElseThrow(() -> new IllegalArgumentException("게시글이 없습니다."));
        CommentEntity comment = new CommentEntity(article, commentRequest.content());
        CommentEntity savedComment = commentRepository.save(comment);
        return CommentResponse.from(savedComment);
    }
}
