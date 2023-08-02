package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.User;
import com.db.grad.javaapi.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UsersHandler implements UsersService {
    private UsersRepository itsUserRepo;

    @Autowired
    public UsersHandler( UsersRepository userRepo)
    {
        itsUserRepo = userRepo;
    }
    @Override
    public List<User> getAllUsers()
    {
        return itsUserRepo.findAllUsers();
    }
}
