package com.company.Summative2SalgadoJose.repository;

import com.company.Summative2SalgadoJose.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findAllBooksByAuthorId(int authorId);
}
