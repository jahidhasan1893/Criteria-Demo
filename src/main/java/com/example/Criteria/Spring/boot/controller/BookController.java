package com.example.Criteria.Spring.boot.controller;

import com.example.Criteria.Spring.boot.DTO.BookDTO;
import com.example.Criteria.Spring.boot.model.Book;
import com.example.Criteria.Spring.boot.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Md Jahid Hasan
 * Date: 12/17/24
 */
@RestController
@RequestMapping("/book")
public record BookController(BookService bookService) {


    @GetMapping("/find")
    public List<Book> getAllFiltered(@RequestBody BookDTO bookDTO){
        return bookService.getAllFiltered(bookDTO);
    }

    @PostMapping("/create")
    public Book create(@RequestBody Book book){
        return bookService.create(book);
    }
}
