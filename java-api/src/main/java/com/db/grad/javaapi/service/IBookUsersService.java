package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Books;
import com.db.grad.javaapi.model.BookUsers;
import com.db.grad.javaapi.repository.BookUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IBookUsersService {
    public List<BookUsers> getAllBookUsers();
}
