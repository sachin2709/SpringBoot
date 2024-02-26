package com.blueyonder.springbootcoonectingdatabase.dao;

import com.blueyonder.springbootcoonectingdatabase.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository <Book,Integer>{
}
