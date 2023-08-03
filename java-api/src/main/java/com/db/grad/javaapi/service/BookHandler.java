package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Books;
import com.db.grad.javaapi.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookHandler implements IBookService{
    private BooksRepository bookRepo;

    @Autowired
    public BookHandler( BooksRepository bookRep ) {this.bookRepo = bookRep;}

    @Override
    public List<Books> getAllBooks() {return bookRepo.getAllBooks();}

}
