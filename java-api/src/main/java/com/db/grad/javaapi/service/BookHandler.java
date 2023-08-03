package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookHandler implements IBookService{
    private BookRepository bookRepo;

    @Autowired
    public BookHandler( BookRepository bookRep ) {this.bookRepo = bookRep;}

    @Override
    public List<Book> getAllBooks() {return bookRepo.getAllBooks();}

    @Override
    public Book getBookById(long uniqueId) {return bookRepo.findById(uniqueId).get();}

    @Override
    public Book addBook(Book theBook) {return bookRepo.save(theBook);}

    @Override
    public Book updateBookDetails(Book bookDetails) {
        return bookRepo.save(bookDetails);
    }

    @Override
    public boolean removeBook(Long id) {
        boolean result = false;

        Optional<Book> theBook = bookRepo.findById(id);
        if(theBook.isPresent())
        {
            bookRepo.delete(theBook.get());
            result = true;
        }

        return  result;
    }

}
