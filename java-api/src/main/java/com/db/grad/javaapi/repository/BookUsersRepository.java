package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Trade;
import com.db.grad.javaapi.model.bookUsers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookUsersRepository extends JpaRepository<bookUsers, Integer>
{
    @Query(nativeQuery = true, value = "select * from bookUsers")
    List<bookUsers> getAllBookUsers();
}