package com.bipanshu.retailsoftware.service;

import java.util.List;

import com.bipanshu.retailsoftware.io.CategoryRequest;
import com.bipanshu.retailsoftware.io.CategoryResponse;

public interface CategoryService {
     
      CategoryResponse add(CategoryRequest categoryRequest);

      List<CategoryResponse> list();
}
