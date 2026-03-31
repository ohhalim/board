package com.halim.board.entity; // com.halim.board.entity 패키지에 속함을 선언합니다.

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "articles") 
@NoArgsConstructor
public class ArticleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; 

    @NotBlank
    @Size(max = 255)
    @Column(nullable = false, length = 255)
    private String title;

    @NotBlank
    @Lob
    @Column(nullable = false)
    private String content;

    public ArticleEntity(String title, String content) {
        this.title = title;
        this.content = content;
    }

}