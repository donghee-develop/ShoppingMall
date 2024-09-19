package com.koreamall.mapper;


import com.koreamall.dto.FileDTO;
import com.koreamall.dto.customer_service.OneOnOneAnswerDTO;
import com.koreamall.dto.customer_service.OneOnOneDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CustomerServiceMapper {

        List<OneOnOneDTO> selectOneOnOnes(@Param("query") String query, @Param("keyword") String keyword);
        OneOnOneDTO selectOneOnOneByNo(Integer no);
        void insertOneOnOnePost(OneOnOneDTO oneOnOneDTO);
        void updateOneOnOnePostViewCount(Integer no);
        void insertOneOnOneFiles(OneOnOneDTO oneOnOneDTO);

        //files
        FileDTO selectOneOnOneFileByUUID(String UUID);
        void insertOneOnOneAnswerOfOneOnOneNo(OneOnOneAnswerDTO oneOnOneAnswerDTO);

        //rest
        Boolean selectOneOnOneIsOpened(Integer no);

        Boolean selectOneOnOnePasswordIsCorrect(
                @Param("no") Integer no,
                @Param("password") String password
        );

}
