package com.koreamall.dto.user;

import com.koreamall.dto.ProductDTO;
import lombok.*;
import lombok.extern.log4j.Log4j2;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Log4j2
public class CartDTO {
    private Integer no;
    private UserDTO user;
    private ProductDTO product;
    private Integer amount;
    private String color;
    private String size;


}
