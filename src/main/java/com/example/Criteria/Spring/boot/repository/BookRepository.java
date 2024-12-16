package com.example.Criteria.Spring.boot.repository;

import com.example.Criteria.Spring.boot.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
