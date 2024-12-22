package com.example.Criteria.Spring.boot.service;

import com.example.Criteria.Spring.boot.DTO.BookDTO;
import com.example.Criteria.Spring.boot.model.Book;
import com.example.Criteria.Spring.boot.repository.BookRepository;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public record BookService(BookRepository bookRepository) {


    public List<Book> getAllFiltered(BookDTO bookDTO) {
        return bookRepository.findBooksByAuthorOrTitleOrGenre(bookDTO.author(),bookDTO.title(),bookDTO.genre());
    }

    public Book create(Book book) {
        bookRepository.save(book);
        return book;
    }
}
