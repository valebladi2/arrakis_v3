package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Books;
import com.db.grad.javaapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

public interface IBookService {
    public List<Books> getAllBooks();

}
