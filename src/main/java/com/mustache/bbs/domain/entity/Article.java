package com.mustache.bbs.domain.entity;

import lombok.*;

import javax.persistence.*;

@Entity // 엔티티 어노테이션을 붙여줘야 객체를 인식한다.
@NoArgsConstructor
@AllArgsConstructor
@Getter
@ToString
@Builder
public class Article {

    @Id // Entity에는 대표값이 필요하다 대표값을 지정 고유의 값
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

}