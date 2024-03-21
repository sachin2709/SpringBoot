package com.blueyonder.smartcontactmanager.Models;

//import jakarta.persistence.*;
import lombok.Data;

import lombok.NoArgsConstructor;
import org.springframework.scheduling.support.SimpleTriggerContext;

import javax.persistence.*;


@NoArgsConstructor
@Entity
@Table(name = "CONTACT")
@Data
public class Contact {

    @Id
    private  int cId;

    private String name;
    private  String work;
    private String email;
    private String phone;
    private  String image;
    @Column(length = 1000)
    private String description;




    @ManyToOne
    private  User user;



}
