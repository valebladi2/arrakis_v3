package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.bookUsers;
import com.db.grad.javaapi.repository.BookUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBookUsersService {
    public List<bookUsers> getAllBookUsers();
    public bookUsers getBookUsersById(int uniqueId);
    public bookUsers addBookUsers(bookUsers theBookUsers);
    public bookUsers updateBookUsersDetails(bookUsers bookDetails);
    public boolean removeBookUser(int id);
}
