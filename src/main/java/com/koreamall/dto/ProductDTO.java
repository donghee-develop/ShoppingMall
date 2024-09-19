package com.koreamall.dto;

import lombok.*;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    private Integer no;
    private CategoryDTO category;
    private String name;
    private Integer price;
    private String tag;
    private String colors;
    private String describe;
    private String material;
    private String sizes;
    private List<FileDTO> images;
}
