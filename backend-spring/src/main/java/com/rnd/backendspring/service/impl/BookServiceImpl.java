package com.rnd.backendspring.service.impl;

import com.rnd.backendspring.dao.BookDao;
import com.rnd.backendspring.entity.Book;
import com.rnd.backendspring.model.BookRequest;
import com.rnd.backendspring.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public Book createBook(BookRequest bookRequest, String categoryId) {
        return bookDao.createBook(bookRequest, categoryId);
    }

    @Override
    public Book updateBook(String id, BookRequest bookRequest, String categoryId) {
        return bookDao.updateBook(id, bookRequest, categoryId);
    }

    @Override
    public List<Book> findBookByAuthor(String authorBook) {
        return bookDao.findBookByAuthor(authorBook);
    }

    @Override
    public List<Book> findBookByCategory(String categoryId) {
        return bookDao.findBookByCategory(categoryId);
    }

    @Override
    public List<Book> findByTitleBook(String titleBook) {
        return bookDao.findByTitleBook(titleBook);
    }

    @Override
    public List<Book> listBookByAvailable(int availableBook) {
        return bookDao.listBookByAvailable(availableBook);
    }

    @Override
    public List<Book> listAllBook() {
        return bookDao.listAllBook();
    }
}
