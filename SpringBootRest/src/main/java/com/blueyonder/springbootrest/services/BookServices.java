package com.blueyonder.springbootrest.services;


import com.blueyonder.springbootrest.models.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/***

 Services works at Dao layer ...basically services are responsible
 to perform any buisness logic as well as interaction to databases


 ***/

@Component
public class BookServices {


    private static List<Book> list=new ArrayList<>();

    static{
        list.add(new Book(12,"Java Complete Reference","XYZ"));
        list.add(new Book(30,"Head First to Java","ABC"));
        list.add(new Book(1293,"Think In Java","LMN"));



    }

    public List<Book> getAllBooks()
    {
        return list;
    }

    public Book getBookById(int id)
    {
        Book book=null;

        book=list.stream().filter(b->b.getId()==id).findFirst().get();

        return book;

    }

    public Book addBook(Book b)
    {
        list.add(b);
        return b;
    }


    public void deleteBook(int id) {
        list= list.stream().filter(b->b.getId()!=id).collect(Collectors.toList());
    }

    public void updateBook(int id, Book book) {

        list=list.stream().map(b->{
            if(b.getId()==id)
            {
                b.setTitle(book.getTitle());
                b.setAuthor(book.getAuthor());

            }
            return b;
        }).collect(Collectors.toList());

    }
}
