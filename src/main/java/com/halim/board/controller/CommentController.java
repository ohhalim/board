package com.halim.board.controller;

import com.halim.board.dto.CommentRequest;
import com.halim.board.dto.CommentResponse;
import com.halim.board.service.CommentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/articles/{articleId}/comments")
    public ResponseEntity<CommentResponse> createComment(
            @PathVariable Long articleId,
            @Valid @RequestBody CommentRequest commentRequest
    ) {
        return ResponseEntity.ok(commentService.createComment(articleId, commentRequest));
    }
}
