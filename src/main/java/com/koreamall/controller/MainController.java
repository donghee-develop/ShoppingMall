package com.koreamall.controller;

import com.koreamall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    @Autowired private ProductService productService;

    @GetMapping("/main")
    public void get_main(Model model){
    }
}
