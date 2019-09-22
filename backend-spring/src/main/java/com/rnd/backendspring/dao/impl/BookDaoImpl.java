package com.rnd.backendspring.dao.impl;

import com.rnd.backendspring.dao.BookDao;
import com.rnd.backendspring.dao.CategoryDao;
import com.rnd.backendspring.entity.Book;
import com.rnd.backendspring.entity.CategoryBook;
import com.rnd.backendspring.model.BookRequest;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.NoResultException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public class BookDaoImpl implements BookDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private CategoryDao categoryDao;

    @Override
    public Book createBook(BookRequest bookRequest, String categoryId) {
        Book objBook = null;
        try{
            CategoryBook categoryBook = categoryDao.findCategoryById(categoryId);
            objBook = Book.builder()
                    .id(UUID.randomUUID().toString().substring(12))
                    .titleBook(bookRequest.getTitleBook())
                    .authorBook(bookRequest.getAuthorBook())
                    .availableBook(bookRequest.getAvailableBook())
                    .categoryBook(categoryBook)
                    .createdAt(LocalDateTime.now())
                    .updatedAt(LocalDateTime.now())
                    .build();
            sessionFactory.getCurrentSession().save(objBook);
        }catch (Exception e){
            e.getLocalizedMessage();
        }

        return objBook;
    }

    @Override
    public Book updateBook(String id, BookRequest bookRequest, String categoryId) {
        Book objBook = null;
        try{
            CategoryBook categoryBook = categoryDao.findCategoryById(categoryId);
            objBook = Book.builder()
                    .id(id)
                    .titleBook(bookRequest.getTitleBook())
                    .authorBook(bookRequest.getAuthorBook())
                    .availableBook(bookRequest.getAvailableBook())
                    .categoryBook(categoryBook)
                    .createdAt(objBook.getCreatedAt())
                    .updatedAt(LocalDateTime.now())
                    .build();
            sessionFactory.getCurrentSession().update(objBook);
        }catch (Exception e){
            e.getLocalizedMessage();
        }
        return objBook;
    }

    @Override
    public List<Book> findBookByAuthor(String authorBook) {
        List<Book> books = null;

        try{
            Session currSession = sessionFactory.getCurrentSession();
            Query<Book> queryBook = currSession.createQuery(
                    "FROM Book b WHERE b.authorBook LIKE CONCAT('%',:authorBook,'%')",
                    Book.class);
            queryBook.setParameter("authorBook", authorBook);
            books = queryBook.getResultList();
        }catch (NoResultException e){
            e.getLocalizedMessage();
        }

        return books;
    }

    @Override
    public List<Book> findBookByCategory(String categoryId) {
        List<Book> books = null;
        try{
            Session currSession = sessionFactory.getCurrentSession();
            Query<Book> queryBook = currSession.createQuery(
                    "From Book b WHERE b.categoryBook.id = :categoryId",
                    Book.class);
            queryBook.setParameter("categoryId", categoryId);
            books = queryBook.getResultList();
        }catch (NoResultException e){
            e.getLocalizedMessage();
        }
        return books;
    }

    @Override
    public List<Book> findByTitleBook(String titleBook) {
        List<Book> books = null;
        try{
            Session currSession = sessionFactory.getCurrentSession();
            Query<Book> queryBook = currSession.createQuery(
                    "FROM Book b WHERE b.titleBook LIKE CONCAT('%',:titleBook,'%')",
                    Book.class);
            queryBook.setParameter("titleBook", titleBook);
            books = queryBook.getResultList();
        }catch (NoResultException e){
            e.getLocalizedMessage();
        }
        return books;
    }

    @Override
    public List<Book> listBookByAvailable(int availableBook) {

        List<Book> books = null;
        try{
            Session currSession = sessionFactory.getCurrentSession();
            Query<Book> queryBook = currSession
                    .createQuery("FROM Book b WHERE b.availableBook=:availableBook",
                            Book.class);
            queryBook.setParameter("availableBook", availableBook);
            books = queryBook.getResultList();
        }catch (NoResultException e){
            e.getLocalizedMessage();
        }
        return books;
    }

    @Override
    public List<Book> listAllBook() {
        List<Book> books = null;
        try{
            Session currSession = sessionFactory.getCurrentSession();
            Query<Book> queryBook = currSession
                    .createQuery("FROM Book b ORDER BY b.titleBook ASC",
                            Book.class);
            books = queryBook.getResultList();
        }catch (NoResultException e){
            e.getLocalizedMessage();
        }
        return books;
    }
}
