package com.bipanshu.retailsoftware.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.bipanshu.retailsoftware.io.CategoryRequest;
import com.bipanshu.retailsoftware.io.CategoryResponse;
import com.bipanshu.retailsoftware.service.CategoryService;

import lombok.RequiredArgsConstructor;

import org.springframework.boot.micrometer.observation.autoconfigure.ObservationProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
 
import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {
    

    private final CategoryService categoryService;
    
    @GetMapping
    public List<CategoryResponse> listCategories(){
        return categoryService.list();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CategoryResponse addCategory(@RequestBody CategoryRequest categoryRequest){
        
        return categoryService.add(categoryRequest);   
    }
    
    @DeleteMapping("/{categoryId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCategory(@PathVariable String categoryId){
        
        try{
            categoryService.delete(categoryId);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND , e.getMessage());
        }
    }

}
