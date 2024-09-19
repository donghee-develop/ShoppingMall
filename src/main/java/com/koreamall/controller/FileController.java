package com.koreamall.controller;

import com.koreamall.dto.FileDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;

@RestController
@Log4j2
@RequestMapping("/file")
public class FileController {
    @GetMapping("/image/{uuid}")
    public ResponseEntity<byte[]> get_image_file(@PathVariable String uuid) {
        return null;
    }

}
