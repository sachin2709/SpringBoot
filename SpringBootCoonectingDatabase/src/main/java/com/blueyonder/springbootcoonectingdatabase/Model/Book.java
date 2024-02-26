package com.blueyonder.springbootcoonectingdatabase.Model;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Entity
 @Table(name = "books")
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Book {

    @Id
    @Column(name = "book_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private String title;


    /***
     *
     * @onetone mapping is basically representing the type of mapping and cascade=CascadeType.ALL is used for
     * creating the author table before creating the book table .,,,, cascade is basically to handle the relations
     * like in below example author is related to book so before making book it created the author to maintain the
     * relation or refernce
     *
     * @JsonManagedReference is used to prevent the recursion when we are doing bidirectional mapping ...it is used
     *  in parent entity or strong entity.
     *
     */


    @OneToOne(cascade = CascadeType.ALL)
    @JsonManagedReference
    private Author author;

}
