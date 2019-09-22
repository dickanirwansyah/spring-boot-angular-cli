package com.rnd.backendspring.service;

import com.rnd.backendspring.entity.Book;
import com.rnd.backendspring.model.BookRequest;

import java.util.List;

public interface BookService {

    Book createBook(BookRequest bookRequest, String categoryId);
    Book updateBook(String id, BookRequest bookRequest, String categoryId);
    List<Book> findBookByAuthor(String authorBook);
    List<Book> findBookByCategory(String categoryId);
    List<Book> findByTitleBook(String titleBook);
    List<Book> listBookByAvailable(int availableBook);
    List<Book> listAllBook();
}
