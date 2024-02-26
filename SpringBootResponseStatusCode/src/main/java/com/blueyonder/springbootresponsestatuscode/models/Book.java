package com.blueyonder.springbootresponsestatuscode.models;

import lombok.*;


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
