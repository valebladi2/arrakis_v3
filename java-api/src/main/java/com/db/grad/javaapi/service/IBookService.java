package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> getAllBooks();
    Book getBookById(long uniqueId);
    Book addBook(Book theBook);

    Book updateBookDetails(Book bookDetails);

    boolean removeBook(Long id);

}
