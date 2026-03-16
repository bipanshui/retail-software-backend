package com.bipanshu.retailsoftware.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bipanshu.retailsoftware.io.CategoryRequest;
import com.bipanshu.retailsoftware.io.CategoryResponse;
import com.bipanshu.retailsoftware.service.CategoryService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
 


@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    

    private final CategoryService categoryService;
    
    @GetMapping("/")
    public String method() {
        return "It works";
    }

    @PostMapping("/addCategory")
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse addCategory(@RequestBody CategoryRequest categoryRequest){
        
        return categoryService.add(categoryRequest);   
    }
    
}
