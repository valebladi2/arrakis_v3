package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.BookUsers;
import com.db.grad.javaapi.repository.BookUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookUsersHandler implements IBookUsersService{
    private BookUsersRepository BookRepo;

    @Autowired
    public BookUsersHandler( BookUsersRepository bookRep ) {this.BookRepo = bookRep;}

    @Override
    public List<BookUsers> getAllBookUsers() {return BookRepo.getAllBookUsers();}

}
