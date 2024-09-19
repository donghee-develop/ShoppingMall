package com.koreamall.interceptor;

import com.koreamall.dto.CategoryDTO;
import com.koreamall.service.ProductService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;

@Component
@Log4j2
public class CategoryInterceptor implements HandlerInterceptor {
    @Autowired private ProductService productService;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        List<CategoryDTO> categories = productService.get_categories();
        request.setAttribute("categories",categories);


        return true;
    }
}
