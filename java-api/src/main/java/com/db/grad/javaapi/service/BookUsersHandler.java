package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.bookUsers;
import com.db.grad.javaapi.repository.BookUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookUsersHandler implements IBookUsersService{
    private BookUsersRepository bookRepo;

    @Autowired
    public BookUsersHandler( BookUsersRepository bookRep ) {this.bookRepo = bookRep;}

    @Override
    public List<bookUsers> getAllBookUsers() {return bookRepo.getAllBookUsers();}

}
