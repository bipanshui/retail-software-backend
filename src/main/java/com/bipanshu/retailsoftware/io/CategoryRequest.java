package com.bipanshu.retailsoftware.io;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class CategoryRequest {
   
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;

 
     private String categoryId;

      
     private String name;
     private String description;
     private String bgColor;
     private String imgUrl;

     
      
     private Timestamp createdAt;
     
     private Timestamp updatedAt;
}
