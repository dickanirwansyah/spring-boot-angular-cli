package com.rnd.backendspring.controller;

import com.rnd.backendspring.entity.Book;
import com.rnd.backendspring.entity.CategoryBook;
import com.rnd.backendspring.model.ApiResponse;
import com.rnd.backendspring.model.BookRequest;
import com.rnd.backendspring.service.BookService;
import com.rnd.backendspring.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private CategoryService categoryService;

    @PostMapping(value = "/create-book/{categoryId}")
    public ResponseEntity<ApiResponse<Book>> createBook(@RequestBody BookRequest bookRequest,
                                                        @PathVariable("categoryId")String categoryId){

        CategoryBook categoryBook = findCategoryBookById(categoryId);
        if (categoryBook == null){
            return ResponseEntity.badRequest().body(ApiResponse.badRequestException());
        }

        Book createBook = bookService.createBook(bookRequest, categoryId);
        return ResponseEntity.ok().body(ApiResponse.okRequestException(createBook));
    }

    @PutMapping(value = "/update-book/{bookId}/{categoryId}")
    public ResponseEntity<ApiResponse<Book>> updateBook(@RequestBody BookRequest bookRequest,
                                                        @PathVariable("categoryId") String categoryId,
                                                        @PathVariable("bookId")String bookId){

        CategoryBook categoryBook = findCategoryBookById(categoryId);
        if (categoryBook == null){
            return ResponseEntity.badRequest()
                    .body(ApiResponse.badRequestException());
        }

        Book updatedBook = bookService.updateBook(bookId, bookRequest, categoryId);
        return ResponseEntity.ok().body(ApiResponse.okRequestException(updatedBook));
    }

    @GetMapping(value = "/findbook-author")
    public ResponseEntity<ApiResponse<List<Book>>> findBookByAuthor(@RequestParam("authorBook")String authorBook){
        List<Book> booksByAuthor = bookService.findBookByAuthor(authorBook);
        if (booksByAuthor.isEmpty() && booksByAuthor.size() < 1){
            return ResponseEntity.badRequest()
                    .body(ApiResponse.badRequestException());
        }

        return ResponseEntity.ok().body(ApiResponse.okRequestException(booksByAuthor));
    }

    private CategoryBook findCategoryBookById(String categoryId){
        CategoryBook categoryBook = categoryService.findCategoryById(categoryId);
        return categoryBook;
    }

}
