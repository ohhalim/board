package com.halim.board.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ArticleRequest (
        @NotBlank(message = "제목은 필수입니다")
        @Size(min = 1, max = 200, message = "제목은 1자 이상 200자 이하입니다")
        String title,

        @NotBlank(message = "내용은 필수입니다")
        @Size(min = 1, max = 1000, message = "내용은 1자 이상 1000자 이히입니다")
        String content
) {}