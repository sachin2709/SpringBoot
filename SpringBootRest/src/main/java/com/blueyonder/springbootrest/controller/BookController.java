package com.blueyonder.springbootrest.controller;


import com.blueyonder.springbootrest.models.Book;
import com.blueyonder.springbootrest.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller

@RestController  /*** if we have annoted @Restcontroller then no need to give annotation @responsebody ***/
public class BookController {

    @Autowired
    BookServices bookService;


    /***

    There is a inbuilt dependency in spring boot that is Jacson which is responsible to convert a java object to json while responsing
    and json to java object while requesting



     ***/

    // get all book handler

    @GetMapping("/book")
    public List<Book> getBooks()
    {
       return bookService.getAllBooks();
    }


    //get single book handler

    @GetMapping("/book/{id}")
    public Book getSingleBook(@PathVariable("id")int id)
    {
        return bookService.getBookById(id);
    }


    /***

     @RequestBody convert json to the java object of type define after @RequestBody

    ***/


    // creating a book handler

    @PostMapping("/book")
    public Book addBook(@RequestBody Book book)
    {
        Book b=bookService.addBook(book);

        return b;

    }

    //delete a book handler

@DeleteMapping("/book/{id}")
public void deleteBook(@PathVariable("id") int id)
{

    bookService.deleteBook(id);

}

@PutMapping("/book/{bookid}")
    public Book updateBook(@RequestBody Book book, @PathVariable("bookid") int id)
{

    bookService.updateBook(id,book);

    return book;
}



}
