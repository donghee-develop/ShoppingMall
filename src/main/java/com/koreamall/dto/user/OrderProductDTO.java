package com.koreamall.dto.user;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Getter
@Setter
@ToString
public class OrderProductDTO {
    private Integer no;
    private String color;
    private String size;
    private Integer amount;
    private Integer price;
}
