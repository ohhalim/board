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

    public ArticleEntity(String title, String content) { // title(제목)과 content(내용)를 입력받아 새로운 엔티티를 초기화하는 공개(public) 생성자입니다.
        this.title = title; // 이 인스턴스의 title(제목) 필드에 매개변수로 입력받은 title(제목) 값을 할당합니다.
        this.content = content; // 이 인스턴스의 content(내용) 필드에 매개변수로 입력받은 content(내용) 값을 할당합니다.
    }
}
