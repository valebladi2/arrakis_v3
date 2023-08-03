package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.bookUsers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBookUsersService {
    List<bookUsers> getAllBookUsers();
    bookUsers getBookUsersById(int uniqueId);
    bookUsers addBookUsers(bookUsers theBookUsers);
    bookUsers updateBookUsersDetails(bookUsers bookDetails);
    boolean removeBookUser(int id);
}
