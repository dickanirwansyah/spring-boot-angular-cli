package com.rnd.backendspring.controller;

import com.rnd.backendspring.entity.CategoryBook;
import com.rnd.backendspring.model.CategoryBookRequest;
import com.rnd.backendspring.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/api/")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "list-category-books")
    public List<CategoryBook> categoryBooks(){
        return categoryService.listCategory();
    }

    private HashMap<String, String> map=null;

    @PostMapping(value = "create-category")
    public ResponseEntity<Object> createCategory(@RequestBody @Valid CategoryBookRequest req,
                                                 BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            map = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()){
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(map, HttpStatus.NOT_ACCEPTABLE);
        }

//        List<CategoryBook> categoryBook = categoryService.findCategoryByName(req.getNameCategory());
//        if (!categoryBook.isEmpty()){
//               return new ResponseEntity<>(HttpStatus.CONFLICT);
//        }


        return new ResponseEntity<>(categoryService.createCategory(req), HttpStatus.CREATED);
    }

    @GetMapping(value = "list-categorys")
    public ResponseEntity<List<CategoryBook>> listCategoryBook(){
        return ResponseEntity.ok(
                categoryService.listCategory()
        );
    }

    @GetMapping(value = "category-byid/{id}")
    public ResponseEntity<CategoryBook> getCategoryBook(@PathVariable("id")String id){
        CategoryBook categoryBook = categoryService.findCategoryById(id);
        if (categoryBook == null){
            return ResponseEntity.badRequest().build();
        }
        return new ResponseEntity<>(categoryBook, HttpStatus.OK);
    }

    @PutMapping(value = "update-category/{id}")
    public ResponseEntity<Object> updateCategory(@PathVariable("id")String id,
                                                       @RequestBody CategoryBookRequest req,
                                                       BindingResult bindingResult){

        if (bindingResult.hasErrors()){
            map = new HashMap<>();
            for (FieldError fieldError : bindingResult.getFieldErrors()){
                map.put(fieldError.getField(), fieldError.getDefaultMessage());
            }
            return new ResponseEntity<>(map, HttpStatus.NOT_ACCEPTABLE);
        }

        CategoryBook categoryBook = categoryService.findCategoryById(id);
        if (categoryBook == null){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(categoryService.updateCategory(req), HttpStatus.OK);
    }
}
