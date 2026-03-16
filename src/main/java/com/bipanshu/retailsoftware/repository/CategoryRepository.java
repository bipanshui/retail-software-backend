package com.bipanshu.retailsoftware.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bipanshu.retailsoftware.entity.CategoryEntity;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long> {
}
