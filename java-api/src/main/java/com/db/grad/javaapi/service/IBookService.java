package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IBookService {
    public List<Book> getAllBooks();
    public Book getBookById(long uniqueId);
    public Book addBook(Book theBook);

    public Book updateBookDetails(Book bookDetails);

    public boolean removeBook(Long id);

}
