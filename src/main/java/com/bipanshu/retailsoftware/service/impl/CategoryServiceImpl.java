package com.bipanshu.retailsoftware.service.impl;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
        
        if(categoryRepository.existsByName(categoryRequest.getName())){
            return CategoryResponse.builder()
                            .name("Category with name "+categoryRequest.getName() + "exists in the database")
                            .build();
        }
        
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

    @Override
    public List<CategoryResponse> list() {
         return categoryRepository.findAll()
                .stream()
                .map(categoryEntity -> convertToResponse(categoryEntity))
                .collect(Collectors.toList());
    }

    @Override
    public void delete(String categoryId){
        CategoryEntity categoryEntity = categoryRepository.findByCategoryId(categoryId)
                          .orElseThrow(() -> new RuntimeException("Category with id " + categoryId + " doesn't exist here bro"));
        categoryRepository.delete(categoryEntity);                  
    }
    
}
