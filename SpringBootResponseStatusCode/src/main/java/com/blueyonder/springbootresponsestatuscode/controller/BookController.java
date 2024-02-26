package com.blueyonder.springbootresponsestatuscode.controller;



import com.blueyonder.springbootresponsestatuscode.models.Book;
import com.blueyonder.springbootresponsestatuscode.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<List<Book>> getBooks()
    {

        List<Book> list=bookService.getAllBooks();

        if(list.size()<=0)
        {

            ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        }


        return ResponseEntity.of(Optional.of(list));


    }


    //get single book handler

    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getSingleBook(@PathVariable("id")int id)
    {
        Book book=bookService.getBookById(id);

        if(book==null)
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }


        return  ResponseEntity.of(Optional.of(book));
    }


    /***

     @RequestBody convert json to the java object of type define after @RequestBody

    ***/


    // creating a book handler

    @PostMapping("/book")
    public ResponseEntity<Book> addBook(@RequestBody Book book)
    {
        Book b=null;
        try{

             b=bookService.addBook(book);

//             return ResponseEntity.ok().body(book);    I have to check the difference between above and below line


             return ResponseEntity.of(Optional.of(book));


/***         In summary, both lines of code achieve similar results in terms of returning a ResponseEntity with the book object as the body.

            However, the second line with ResponseEntity.of(Optional.of(book)) explicitly wraps the book object in an Optional,
 which can be useful for handling nullable values.

 ***/








        }
        catch(Exception e)
        {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }





    }

    //delete a book handler

@DeleteMapping("/book/{id}")
public ResponseEntity<Void> deleteBook(@PathVariable("id") int id) // We can also write ? at place of void
{
    try {
        bookService.deleteBook(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

    }
    catch(Exception e)
    {
        e.printStackTrace();

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}

@PutMapping("/book/{bookid}")
    public ResponseEntity<Book> updateBook(@RequestBody Book book, @PathVariable("bookid") int id)
{


    try{
       bookService.updateBook(id,book);

       return ResponseEntity.ok().body(book);
    }
    catch(Exception e)
    {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }




}



}
