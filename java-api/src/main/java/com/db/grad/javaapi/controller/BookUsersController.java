package com.db.grad.javaapi.controller;

import com.db.grad.javaapi.exception.ResourceNotFoundException;
import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.bookUsers;
import com.db.grad.javaapi.service.BookHandler;
import com.db.grad.javaapi.service.BookUsersHandler;
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
public class BookUsersController {
    private BookUsersHandler BookUsersService;

    @Autowired
    public BookUsersController(BookUsersHandler bs)
    {
        BookUsersService = bs;
    }

    @GetMapping("/bookUsers")
    public List <bookUsers> getAllBookUsers() {return BookUsersService.getAllBookUsers();}

    @GetMapping("/bookUsers/{id}")
    public ResponseEntity <bookUsers> getEmployeeById(@PathVariable(value = "id") Integer id)
    throws ResourceNotFoundException {
        bookUsers books = BookUsersService.getBookUsersById(id);
        return ResponseEntity.ok().body(books);
    }

    @PostMapping("/bookUsers")
    public bookUsers createBook(@Valid @RequestBody bookUsers bookUser) {
        return BookUsersService.addBookUsers(bookUser);
    }

    @PutMapping("/bookUsers/{id}")
    public ResponseEntity < bookUsers > updateBook(@PathVariable(value = "id") Long id,
        @Valid @RequestBody bookUsers bookDetails) throws ResourceNotFoundException {

        final bookUsers updatedBooks = BookUsersService.updateBookUsersDetails(bookDetails);
        return ResponseEntity.ok(updatedBooks);
    }

    @DeleteMapping("/bookUsers/{id}")
    public Map < String, Boolean > deleteBook(@PathVariable(value = "id") Integer id)
    throws ResourceNotFoundException {
    	boolean removed = BookUsersService.removeBookUser(id);

        Map < String, Boolean > response = new HashMap <>();
        if( removed )
            response.put("deleted", Boolean.TRUE);
        else
            response.put("deleted", Boolean.FALSE);

        return response;
    }
}
