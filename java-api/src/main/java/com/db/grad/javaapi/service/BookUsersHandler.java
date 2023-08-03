package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.BookUsers;
import com.db.grad.javaapi.repository.BookUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookUsersHandler implements IBookUsersService{
    private BookUsersRepository bookRepo;

    @Autowired
    public BookUsersHandler( BookUsersRepository bookRep ) {this.bookRepo = bookRep;}

    @Override
    public List<BookUsers> getAllBookUsers() {return bookRepo.getAllBookUsers();}

    @Override
    public BookUsers getBookUsersById(int uniqueId) {return bookRepo.findById(uniqueId).get();}

    @Override
    public BookUsers addBookUsers(BookUsers theBookUsers) {return bookRepo.save( theBookUsers );}

    @Override
    public BookUsers updateBookUsersDetails(BookUsers bookDetails) {
        return bookRepo.save(bookDetails);
    }

    @Override
    public boolean removeBookUser(int id) {
        boolean result = false;

        Optional<BookUsers> theBookUser = bookRepo.findById(id);
        if(theBookUser.isPresent())
        {
            bookRepo.delete(theBookUser.get());
            result = true;
        }

        return  result;
    }
}
