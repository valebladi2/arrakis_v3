package com.db.grad.javaapi.service;

import com.db.grad.javaapi.model.Books;
import com.db.grad.javaapi.repository.BooksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookHandler implements IBookService{
    private BooksRepository bookRepo;

    @Autowired
    public BookHandler( BooksRepository bookRep ) {this.bookRepo = bookRep;}

    @Override
    public List<Books> getAllBooks() {return bookRepo.getAllBooks();}

    @Override
    public Books getBookById(long uniqueId) {return bookRepo.findById(uniqueId).get();}

    @Override
    public Books addBook(Books theBook) {return bookRepo.save(theBook);}

    @Override
    public Books updateBookDetails(Books bookDetails) {
        return bookRepo.save(bookDetails);
    }

    @Override
    public boolean removeBook(Long id) {
        boolean result = false;

        Optional<Books> theBook = bookRepo.findById(id);
        if(theBook.isPresent())
        {
            bookRepo.delete(theBook.get());
            result = true;
        }

        return  result;
    }

}
