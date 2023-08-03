package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Books;

import java.util.List;

public interface IBookService {
    List<Books> getAllBooks();
    Books getBookById(long uniqueId);
    Books addBook(Books theBook);

    Books updateBookDetails(Books bookDetails);

    boolean removeBook(Long id);

}
