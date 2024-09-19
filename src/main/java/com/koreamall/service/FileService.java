package com.koreamall.service;

import com.koreamall.dto.FileDTO;
import com.koreamall.mapper.ProductMapper;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
@Log4j2
public class FileService {
    @Autowired private ProductMapper productMapper;
    private String path = "";

//    public FileDTO get_product_file(String uuid) {
//        File file = new File(path, uuid);
//        return null;
//    }
}


