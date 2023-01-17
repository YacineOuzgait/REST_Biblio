package com.wcs.REST_Biblio.controller;

import org.springframework.web.bind.annotation.RestController;

import com.wcs.REST_Biblio.entity.Book;
import com.wcs.REST_Biblio.respository.BookRespository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class BookController {

    @Autowired
    BookRespository bookRespository;

    @GetMapping("/books")
    public List<Book> index(){
        return bookRespository.findAll();
    }

    @GetMapping("/books/{id}")
    public Book show(@PathVariable int id){
        return bookRespository.findById(id).get();
    }

    @PostMapping("/books/search")
    public List<Book> search(@RequestBody Map<String, String> body){
        String searchTerm = body.get("text");
        return bookRespository.findByTitleContainingOrAuthorContaining(searchTerm, searchTerm);
    }

    @PostMapping("/books")
    public Book create(@RequestBody Book book){
        return bookRespository.save(book);
    }

    @PutMapping("/books/{id}")
    public Book update(@PathVariable int id, @RequestBody Book blog){
        // getting blog
        Book bookToUpdate = bookRespository.findById(id).get();
        bookToUpdate.setTitle(blog.getTitle());
        bookToUpdate.setAuthor(blog.getAuthor());
        return bookRespository.save(bookToUpdate);
    }

    @DeleteMapping("books/{id}")
    public boolean delete(@PathVariable int id){
        bookRespository.deleteById(id);
        return true;
    }
}
