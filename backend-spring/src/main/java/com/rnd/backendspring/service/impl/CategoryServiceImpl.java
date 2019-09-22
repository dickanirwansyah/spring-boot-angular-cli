package com.rnd.backendspring.service.impl;

import com.rnd.backendspring.dao.CategoryDao;
import com.rnd.backendspring.entity.CategoryBook;
import com.rnd.backendspring.model.CategoryBookRequest;
import com.rnd.backendspring.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public List<CategoryBook> listCategory() {
        return categoryDao.listCategory();
    }

    @Override
    public List<CategoryBook> findCategoryByName(String categoryName) {
        return categoryDao.findCategoryByName(categoryName);
    }

    @Override
    public CategoryBook findCategoryById(String id) {
        return categoryDao.findCategoryById(id);
    }

    @Override
    public CategoryBook createCategory(CategoryBookRequest categoryBookRequest) {
        return categoryDao.createCategory(categoryBookRequest);
    }

    @Override
    public CategoryBook updateCategory(CategoryBookRequest categoryBookRequest) {
        return categoryDao.updateCategory(categoryBookRequest);
    }

    @Override
    public List<CategoryBook> findCategoryByCreatedAt(LocalDateTime createdAt) {
        return categoryDao.findCategoryByCreatedAt(createdAt);
    }
}
