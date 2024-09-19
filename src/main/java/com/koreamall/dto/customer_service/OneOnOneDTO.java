package com.koreamall.dto.customer_service;

import com.koreamall.dto.FileDTO;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OneOnOneDTO {
    private Integer no;
    private String title;
    private String writer;
    private String content;
    private LocalDateTime nowDateTime;
    private Integer viewCount;
    private Boolean isOpened;
    private Boolean isAnswered;
    private String password;
    private List<FileDTO> files;
    private List<OneOnOneAnswerDTO> answers;

}
