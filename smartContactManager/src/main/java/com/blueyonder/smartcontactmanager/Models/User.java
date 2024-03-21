package com.blueyonder.smartcontactmanager.Models;




import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Entity
@Table(name = "USERS")
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Name Field is required !!!")
    @Size(min=2,max=20,message="min 2 and max 20 characters are allowed !!")
    private String name;
    @Column(unique = true)
    private String email;

    private String password;

    private String role;

    private boolean enabled;

    private String imageUrl;
    @Column(length = 500)
    private String about;

    //fetch type lazy mtlb jab tum user print karoge ya return karoge to contactsList nahi display hogi
    //agr fetch type eager karoge to sab kuch print hoga contactsList bhi hogi

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user",fetch = FetchType.LAZY)
    private List<Contact> contactsList=new ArrayList<>();

}
