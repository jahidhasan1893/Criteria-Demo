package com.example.Criteria.Spring.boot.dao;

import com.example.Criteria.Spring.boot.model.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookDao {

    @PersistenceContext
    EntityManager em;

    public List<Book> findBooksByAuthorOrTitleOrGenre(String author, String title, String genre) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);

        Root<Book> root = cq.from(Book.class);

        List<Predicate> predicates = new ArrayList<>();

        if(author!=null){
           predicates.add(cb.equal(root.get("author"), author));
        }

        if(title!=null){
            predicates.add(cb.like(root.get("title"), "%" + title + "%"));
        }

        if(genre!=null){
            predicates.add(cb.like(root.get("genre"), "%" + genre + "%"));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(cq).getResultList();

    }
}
