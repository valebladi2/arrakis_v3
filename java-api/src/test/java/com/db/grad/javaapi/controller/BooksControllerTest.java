package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.model.Books;
import com.db.grad.javaapi.repository.BooksRepository;
import com.db.grad.javaapi.repository.BooksUsersRepository;
import com.db.grad.javaapi.service.BooksHandler;
import com.db.grad.javaapi.service.BooksUsersService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class BooksControllerTest {
    @Mock
    BooksRepository booksRepo;

    @InjectMocks
    private BooksHandler cut;

    @Test
    void getAllBooks() {
        //arrange
//        List<String> expectedList=new ArrayList<String>();
//        expectedList.add("trading_borading Ltd,active,Airbus 3.15%  USD,,123456780,900,30-07-21,USD,3.15,105.775");
//        //act
//        //assert
//
//        ArrayList<String> getAllBooksActual = new ArrayList<>();
//        System.out.println(getAllBooksActual);
//
//
//        Mockito.when(booksUsersRepo.getAllBooksUser(Mockito.any())).thenReturn(expectedList);
//        assertEquals( expectedList,booksUsersRepo.getAllBooksUser("Astra Trading Ltd"));
    }

    @Test
    void getBondsPlusMinusPosId() {
        //arrange
        List<String> expectedList=new ArrayList<String>();
        expectedList.add("trading_borading Ltd,active,Airbus 3.15%  USD,,123456780,900,30-07-21,USD,3.15,105.775");
        ArrayList<String> actualLsit = new ArrayList<>();
        actualLsit.add("trading_borading Ltd,active,Airbus 3.15%  USD,,123456780,900,30-07-21,USD,3.15,105.775");

        Books book = new Books();
        book.setBookName("book_1");
        //Mockito.when(booksRepo.save(book)).thenReturn(book);
        Mockito.when(booksRepo.getBondsPlusMinPosId(1)).thenReturn(expectedList);

        System.out.println(actualLsit);
        booksRepo.save(book);
        assertEquals( booksRepo.getBondsPlusMinPosId(1),actualLsit);
    }

    @Test
    void testGetBondsPlusMinus5Days() {
    }
}