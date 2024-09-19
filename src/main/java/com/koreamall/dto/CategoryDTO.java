package com.koreamall.dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.util.List;


@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Log4j2
public class CategoryDTO {
    private Integer no;
    private String name;
    // 하나의 카테고리에 여러 개의 프로덕트가 존재할 수 있음
    // 내 카테고리의 하위 카테고리들 선언
    // 카테고리를 전부 조회해서 매핑해서 넣어야 함
    private List<CategoryDTO> children;
}
