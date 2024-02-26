package com.blueyonder.springbootcoonectingdatabase.Service;

import com.blueyonder.springbootcoonectingdatabase.Model.Book;
import com.blueyonder.springbootcoonectingdatabase.dao.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServices {


    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {

            List<Book> list=(List<Book>) bookRepository.findAll();

            return list;
    }

    public Book getBookById(int id) {

        Book book=null;
        try{

            book=this.bookRepository.findById(id).get();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


        return book;




    }

    public Book addBook(Book book) {
       Book result= bookRepository.save(book);

       return result;
    }

    public void updateBook(int id, Book book) {

        book.setId(id);

        bookRepository.save(book);




    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
}
