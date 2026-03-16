package com.bipanshu.retailsoftware.service.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.bipanshu.retailsoftware.entity.CategoryEntity;
import com.bipanshu.retailsoftware.io.CategoryRequest;
import com.bipanshu.retailsoftware.io.CategoryResponse;
import com.bipanshu.retailsoftware.repository.CategoryRepository;
import com.bipanshu.retailsoftware.service.CategoryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{


    private final CategoryRepository categoryRepository;

    @Override
    public CategoryResponse add(CategoryRequest categoryRequest) {
         
        CategoryEntity newCategory =  convertToEntity(categoryRequest);
        newCategory = categoryRepository.save(newCategory);
        return convertToResponse(newCategory);
    }

    private CategoryEntity convertToEntity(CategoryRequest categoryRequest){
        return CategoryEntity.builder()
                        .categoryId(UUID.randomUUID().toString())
                        .name(categoryRequest.getName())
                        .description(categoryRequest.getDescription())
                        .bgColor(categoryRequest.getBgColor())
                        .build();
    }

    private CategoryResponse convertToResponse(CategoryEntity categoryEntity){
        return CategoryResponse.builder()
                        .categoryId(categoryEntity.getCategoryId())
                        .name(categoryEntity.getName())
                        .description(categoryEntity.getDescription())
                        .bgColor(categoryEntity.getBgColor())
                        .imgUrl(categoryEntity.getImgUrl())
                        .createdAt(categoryEntity.getCreatedAt())
                        .updatedAt(categoryEntity.getUpdatedAt())
                        .build();

    }
    
}
