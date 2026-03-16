package com.bipanshu.retailsoftware.io;

import java.sql.Timestamp;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryResponse {
    
     private Long id;   
     private String categoryId;
   
     private String name;
     private String description;
     private String bgColor;
     private String imgUrl;

     private Timestamp createdAt;
     private Timestamp updatedAt;
}
