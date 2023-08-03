package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Books;
import com.db.grad.javaapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookHandler implements IBookService{
    private BookRepository bookRepo;

    @Autowired
    public BookHandler( BookRepository bookRep ) {this.bookRepo = bookRep;}

    @Override
    public List<Books> getAllBooks() {return bookRepo.getAllBooks();}

}
