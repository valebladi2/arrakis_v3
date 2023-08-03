package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.bookUsers;
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
    public List<bookUsers> getAllBookUsers() {return bookRepo.getAllBookUsers();}

    @Override
    public bookUsers getBookUsersById(int uniqueId) {return bookRepo.findById(uniqueId).get();}

    @Override
    public bookUsers addBookUsers(bookUsers theBookUsers) {return bookRepo.save( theBookUsers );}

    @Override
    public bookUsers updateBookUsersDetails(bookUsers bookDetails) {
        return bookRepo.save(bookDetails);
    }

    @Override
    public boolean removeBookUser(int id) {
        boolean result = false;

        Optional<bookUsers> theBookUser = bookRepo.findById(id);
        if(theBookUser.isPresent())
        {
            bookRepo.delete(theBookUser.get());
            result = true;
        }

        return  result;
    }
}
