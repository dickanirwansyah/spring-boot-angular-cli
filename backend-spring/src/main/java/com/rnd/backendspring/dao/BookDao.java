package com.rnd.backendspring.dao;

import com.rnd.backendspring.entity.Book;
import com.rnd.backendspring.model.BookRequest;

import java.util.List;

public interface BookDao {

    Book createBook(BookRequest bookRequest, String categoryId);
    Book updateBook(String id, BookRequest bookRequest, String categoryId);
    List<Book> findBookByAuthor(String authorBook);
    List<Book> findBookByCategory(String categoryId);
    List<Book> findByTitleBook(String titleBook);
    List<Book> listBookByAvailable(int availableBook);
    List<Book> listAllBook();
}
