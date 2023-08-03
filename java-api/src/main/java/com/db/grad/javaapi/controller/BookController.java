package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.Dog;
import com.db.grad.javaapi.service.BookHandler;
import com.db.grad.javaapi.service.DogHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class BookController {
    private BookHandler BookService;

    @Autowired
    public BookController(BookHandler bs)
    {
        BookService = bs;
    }

    @GetMapping("/books")
    public List <Book> getAllBooks() {
        return BookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public ResponseEntity <Book> getEmployeeById(@PathVariable(value = "id") Long id)
    throws ResourceNotFoundException {
        Book books = BookService.getBookById(id);
        return ResponseEntity.ok().body(books);
    }

    @PostMapping("/books")
    public Book createBook(@Valid @RequestBody Book book) {
        return BookService.addBook(book);
    }

    @PutMapping("/books/{id}")
    public ResponseEntity < Book > updateBook(@PathVariable(value = "id") Long id,
        @Valid @RequestBody Book bookDetails) throws ResourceNotFoundException {

        final Book updatedBooks = BookService.updateBookDetails(bookDetails);
        return ResponseEntity.ok(updatedBooks);
    }

    @DeleteMapping("/books/{id}")
    public Map < String, Boolean > deleteBook(@PathVariable(value = "id") Long id)
    throws ResourceNotFoundException {
    	boolean removed = BookService.removeBook(id);

        Map < String, Boolean > response = new HashMap <>();
        if( removed )
            response.put("deleted", Boolean.TRUE);
        else
            response.put("deleted", Boolean.FALSE);

        return response;
    }
}
