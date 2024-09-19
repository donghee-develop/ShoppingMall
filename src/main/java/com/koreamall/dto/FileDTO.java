package com.koreamall.dto;

import lombok.*;

import java.util.Base64;

@Getter
@Setter
@Builder
@ToString(exclude = {"data", "url"})
@AllArgsConstructor
@NoArgsConstructor
public class FileDTO {
    private String UUID;
    private String originalFileName;
    private String saveFileName;
    private byte[] data;
    private String url;


//    데이터가 있을 땐 컨트롤러 없이 다음과 같이 넣을 수 있음 (이미지가 백그라운드일 때도 가능)
    public void setData(byte[] data) {
        this.data = data;
        try{
            this.url = Base64.getEncoder().encodeToString(data);
       }catch(Exception e){
           e.printStackTrace();
       }
    }
}
