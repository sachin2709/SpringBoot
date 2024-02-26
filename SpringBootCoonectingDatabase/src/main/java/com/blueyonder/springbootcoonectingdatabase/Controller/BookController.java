package com.blueyonder.springbootcoonectingdatabase.Controller;

import com.blueyonder.springbootcoonectingdatabase.Model.Book;
import com.blueyonder.springbootcoonectingdatabase.Service.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookServices bookService;

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {

        List<Book> list=bookService.getAllBooks();

        if(list.isEmpty())
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        else {
            return ResponseEntity.status(HttpStatus.CREATED).body(list);
 
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable int id) {
        try {
            Book book = bookService.getBookById(id);
            return ResponseEntity.ok(book);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book not found");
        }
    }

    @PostMapping
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        try {
            bookService.addBook(book);
            return ResponseEntity.status(HttpStatus.CREATED).body("Book added successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add book");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable int id, @RequestBody Book book) {
        try {
            bookService.updateBook(id, book);
            return ResponseEntity.ok("Book updated successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update book");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteBook(@PathVariable int id) {
        try {
            bookService.deleteBook(id);
            return ResponseEntity.ok("Book deleted successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to delete book");
        }
    }

    // Exception handler for handling generic exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred");
    }
}
