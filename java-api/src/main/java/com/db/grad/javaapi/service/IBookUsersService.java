package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.BookUsers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBookUsersService {
    List<BookUsers> getAllBookUsers();
    BookUsers getBookUsersById(int uniqueId);
    BookUsers addBookUsers(BookUsers theBookUsers);
    BookUsers updateBookUsersDetails(BookUsers bookDetails);
    boolean removeBookUser(int id);
}
