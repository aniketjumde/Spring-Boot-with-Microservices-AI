package com.tca.api;

import com.tca.exception.BookAlreadyExitsException;
import com.tca.exception.BookNotFoundException;
import com.tca.model.Book;
import com.tca.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookRestController {

    @Autowired
    private BookService bookService;

    @GetMapping(value="/{id}",
                produces = "application/json")
    public ResponseEntity<Book> getBookById(@PathVariable Integer id){
        return ResponseEntity.ok(bookService.getById(id));
    }

    @GetMapping(value="/books",
                produces = "application/json")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping(value="/create",
                consumes = "application/json",
                produces = "application/json")
    public ResponseEntity<Book> saveBook(@RequestBody Book book){
        return ResponseEntity.ok(bookService.save(book));
    }

    @DeleteMapping(value="/{id}")
    public void deleteBook(@PathVariable Integer id){
        bookService.deleteById(id);
    }

    //Local Exception handing

    @ExceptionHandler(BookAlreadyExitsException.class)
    public ResponseEntity<String> handleBookAlreadyExitsException(BookAlreadyExitsException ex){
        return ResponseEntity.status(409).body(ex.getMessage());
    }

    @ExceptionHandler(BookNotFoundException.class)
    public ResponseEntity<String> handleBookNotFoundException(BookNotFoundException ex){
        return ResponseEntity.status(404).body(ex.getMessage());
    }




}
