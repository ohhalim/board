package com.halim.board.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CommentRequest(
        @NotBlank(message= "내용은 필수입니다")
        @Size(min = 1, max = 1000, message = "내용은 1자 이상 1000자 이히입니다")
        String content
) {}
