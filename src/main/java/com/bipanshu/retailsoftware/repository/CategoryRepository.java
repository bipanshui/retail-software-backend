package com.bipanshu.retailsoftware.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bipanshu.retailsoftware.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {

    boolean existsByName(String name);
    Optional<CategoryEntity> findByCategoryId(String CategoryId);
}
