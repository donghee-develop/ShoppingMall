package com.koreamall.dto.user;

import com.koreamall.dto.ProductDTO;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
@Getter
@Setter
@ToString
public class OrderDTO {
    private String id; // merchant_uid
    private UserDTO user;
    private List<OrderProductDTO> products;
    private String title; // 주문명
    private String receiverName; // 고객
    private String receiverPhone;
    private String receiverPostcode;
    private String receiverAddress;
    private String memo;
    private String impUid; // 포트원 결제 번호
    private String payMethod; // 결제수단
    private Integer paidAmount; // 총 가격
    private Long paidAt; // 결제 시작
}
