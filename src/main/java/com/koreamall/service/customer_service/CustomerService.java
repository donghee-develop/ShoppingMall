package com.koreamall.service.customer_service;

import com.koreamall.dto.FileDTO;
import com.koreamall.dto.customer_service.OneOnOneAnswerDTO;
import com.koreamall.dto.customer_service.OneOnOneDTO;
import com.koreamall.mapper.CustomerServiceMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

@Service
public class CustomerService {
    private final String filePath = "/Users/donghui/Desktop/Board";

    @Autowired
    private CustomerServiceMapper customerServiceMapper;

    // 문의 게시물 가져오기
    public List<OneOnOneDTO> get_posts(String query, String keyword) {
        return customerServiceMapper.selectOneOnOnes(query,keyword);
    }

    // 해당 번호의 문의 게시물 하나를 가져오기
    public OneOnOneDTO get_post(Integer postNo) {
        return customerServiceMapper.selectOneOnOneByNo(postNo);
    }

    // 문의 게시물 작성
    public void create_post(OneOnOneDTO oneOnOneDTO) {
        // 게시물 insert(작성)한다
        customerServiceMapper.insertOneOnOnePost(oneOnOneDTO);
        // 파일 로컬 저장 시도 저장 못하면 그대로 종료
        if (!create_files(oneOnOneDTO.getFiles())) {
            return;
        }
        // 게시물의 파일들을 insert 한다
        customerServiceMapper.insertOneOnOneFiles(oneOnOneDTO);
    }

    private boolean create_files(List<FileDTO> fileDTOS) {
        for (FileDTO fileDTO : fileDTOS) {
            File newFile = new File(filePath, fileDTO.getSaveFileName());
            try (FileOutputStream fos = new FileOutputStream(newFile)) {
                fos.write(fileDTO.getData());
            } catch (Exception e) {
                System.out.println("파일 저장 중 오류.. " + e.getMessage());
                return false;
            }
        }
        return true;
    }

    // one_on_one 게시판 파일 가져오기
    public FileDTO get_file_of_one_on_one(String UUID){
        return customerServiceMapper.selectOneOnOneFileByUUID(UUID);
    }

    public void create_answer(OneOnOneAnswerDTO oneOnOneAnswerDTO){
        customerServiceMapper.insertOneOnOneAnswerOfOneOnOneNo(oneOnOneAnswerDTO);
    }
    // rest
    // 게시물 비공개 공개
    public Boolean get_post_isOpened(Integer no){
        return customerServiceMapper.selectOneOnOneIsOpened(no);
    }

    public Boolean get_post_password_isCorrect(Integer postNo, String password){
        return customerServiceMapper.selectOneOnOnePasswordIsCorrect(postNo,password);
    }

    // 문의 조회수 1 증가
    public void increase_post_view_count(Integer postNo){
        customerServiceMapper.updateOneOnOnePostViewCount(postNo);
    }


}




