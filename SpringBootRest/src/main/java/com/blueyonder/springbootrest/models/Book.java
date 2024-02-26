package com.blueyonder.springbootrest.models;

import lombok.*;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;



/***

 This is basically used to define schema .... for this example
 it is simple java class... but when we make some other application
 which uses db then it will be mapped to table or entity in db


 ***/

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {

    private int id;
    private String title;
    private String author;
}
