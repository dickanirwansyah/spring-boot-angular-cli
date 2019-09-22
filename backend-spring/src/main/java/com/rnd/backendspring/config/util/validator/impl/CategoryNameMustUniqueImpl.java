package com.rnd.backendspring.config.util.validator.impl;

import com.rnd.backendspring.config.util.validator.CategoryNameMustUnique;
import com.rnd.backendspring.dao.CategoryDao;
import com.rnd.backendspring.entity.CategoryBook;
import com.rnd.backendspring.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.List;

@Component
public class CategoryNameMustUniqueImpl implements ConstraintValidator<CategoryNameMustUnique, String> {

    private final CategoryService categoryService;

    @Autowired
    public CategoryNameMustUniqueImpl(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @Override
    public void initialize(CategoryNameMustUnique constraintAnnotation) {

    }

    @Override
    public boolean isValid(String categoryName, ConstraintValidatorContext context) {
        List<CategoryBook> categoryBooks = categoryService.findCategoryByName(categoryName);
        if (!categoryBooks.isEmpty() && categoryBooks != null){
            return false;
        }
        return true;
    }
}
