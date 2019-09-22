package com.rnd.backendspring.dao.impl;

import com.rnd.backendspring.config.util.uuid.GeneratorId;
import com.rnd.backendspring.dao.CategoryDao;
import com.rnd.backendspring.entity.CategoryBook;
import com.rnd.backendspring.model.CategoryBookRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<CategoryBook> listCategory() {
        Session currSession = sessionFactory.getCurrentSession();
        String jpql = "From CategoryBook";
        Query<CategoryBook> query = currSession.createQuery(jpql, CategoryBook.class);
        List<CategoryBook> categoryBooks = query.getResultList();
        return categoryBooks;
    }

    @Override
    public List<CategoryBook> findCategoryByName(String categoryName) {
        Session currSession = sessionFactory.getCurrentSession();
        String jpql = "FROM CategoryBook CB WHERE CB.nameCategory=:nameCategory";
        Query<CategoryBook> query = currSession.createQuery(jpql, CategoryBook.class);
        query.setParameter("nameCategory", categoryName);
        List<CategoryBook> categoryBooks = query.getResultList();
        return categoryBooks;

    }

    @Override
    public CategoryBook findCategoryById(String id) {
        Session currSession = sessionFactory.getCurrentSession();
        CategoryBook categoryBook = null;


        try{
            String jpql = "FROM CategoryBook cb WHERE cb.id=:id";
            Query<CategoryBook> query = currSession.createQuery(jpql, CategoryBook.class);
            query.setParameter("id", id);
            categoryBook = query.getSingleResult();
        }catch (NoResultException e){
            e.getLocalizedMessage();
        }

        if (categoryBook == null){
            return null;
        }

        return categoryBook;
    }

    @Override
    public CategoryBook createCategory(CategoryBookRequest categoryBookRequest) {

       CategoryBook categoryBook = null;
       try{
           categoryBook = CategoryBook
                   .builder()
                   .id(GeneratorId.generateId())
                   .nameCategory(categoryBookRequest.getNameCategory())
                   .createdAt(LocalDateTime.now())
                   .updatedAt(LocalDateTime.now())
                   .build();
           sessionFactory.getCurrentSession().save(categoryBook);
       }catch (Exception e){
           e.printStackTrace();
       }
        return categoryBook;
    }

    @Override
    public CategoryBook updateCategory(CategoryBookRequest categoryBookRequest) {
        CategoryBook categoryBook = null;
        try{
            categoryBook = CategoryBook
                    .builder()
                    .id(categoryBookRequest.getId())
                    .nameCategory(categoryBookRequest.getNameCategory())
                    .createdAt(categoryBookRequest.getCreatedAt())
                    .updatedAt(LocalDateTime.now())
                    .build();
            sessionFactory.getCurrentSession().update(categoryBook);
        }catch (Exception e){
            e.printStackTrace();
        }
        return categoryBook;
    }

    @Override
    public List<CategoryBook> findCategoryByCreatedAt(LocalDateTime createdAt) {
        Session currentSession = sessionFactory.getCurrentSession();
        String jpql = "FROM CategoryBook cb WHERE cb.createdAt=:createdAt";
        Query<CategoryBook> query = currentSession.createQuery(jpql, CategoryBook.class);
        query.setParameter("createdAt", createdAt);
        List<CategoryBook> books = new ArrayList<>();
        List<CategoryBook> categoryBooks = query.getResultList();
        return categoryBooks;
    }
}
