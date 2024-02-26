package com.blueyonder.springbootcoonectingdatabase.Model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "author")
@ToString
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int authorId;


    private String firstName;

    private String lastName;

    private String language;

    /***
     *   mappedBy is used to prevent the creation of extra column for reference in both the tables ..so if
     *   you want that there should be only one column in any one table then you can use mappedBy in other table
     *   and put the name of field that is used for mapping in previous table....
     *
     * @JsonBackReference is used to prevent the recursion when we are doing bidirectional mapping ...it is used
     * in dependent entity or weak entity.
     *
     */


    @OneToOne(mappedBy = "author")
    @JsonBackReference
    private Book book;



}
