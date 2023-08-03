package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.BookUsers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBookUsersService {
    public List<BookUsers> getAllBookUsers();

    List<String> getAllBooksUser();
}
