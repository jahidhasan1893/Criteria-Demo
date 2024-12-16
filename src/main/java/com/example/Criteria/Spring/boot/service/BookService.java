package com.example.Criteria.Spring.boot.service;

import com.example.Criteria.Spring.boot.dao.BookDao;
import com.example.Criteria.Spring.boot.model.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Service
public class BookService {
    private BookDao bookDao;


}
