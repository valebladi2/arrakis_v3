package com.db.grad.javaapi.repository;
import com.db.grad.javaapi.model.Books;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Books, Long>
{
    @Query(nativeQuery = true, value = "select * from books")
    List<Books> getAllBooks();
}