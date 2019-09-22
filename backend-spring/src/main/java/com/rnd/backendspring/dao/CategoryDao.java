package com.rnd.backendspring.dao;

import com.rnd.backendspring.entity.CategoryBook;
import com.rnd.backendspring.model.CategoryBookRequest;

import java.time.LocalDateTime;
import java.util.List;

public interface CategoryDao {

    List<CategoryBook> listCategory();
    List<CategoryBook> findCategoryByName(String categoryName);
    CategoryBook findCategoryById(String id);
    CategoryBook createCategory(CategoryBookRequest categoryBookRequest);
    CategoryBook updateCategory(CategoryBookRequest categoryBookRequest);
    List<CategoryBook> findCategoryByCreatedAt(LocalDateTime createdAt);

}
