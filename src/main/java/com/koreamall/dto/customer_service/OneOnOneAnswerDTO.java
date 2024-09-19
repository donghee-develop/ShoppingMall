package com.koreamall.dto.customer_service;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OneOnOneAnswerDTO {
    private Integer no;
    private String userId;
    private Integer oneOnOneNo;
    private String answer;
    private LocalDateTime writeDateTime;
}
