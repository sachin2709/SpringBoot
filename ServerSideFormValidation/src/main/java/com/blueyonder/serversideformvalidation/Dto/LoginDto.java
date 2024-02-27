package com.blueyonder.serversideformvalidation.Dto;

import lombok.*;

import jakarta.validation.constraints.*;



@NoArgsConstructor
@Data
public class LoginDto {

    @NotBlank(message = "Username cant be empty !!")
    @Size(min=3,max=12,message = "Username must be between 3-13 characters")
    private String userName;

//    @Pattern(regexp ="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "Invalid Email !!")
    @Email(regexp ="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$",message = "Invalid Email !!")
    private String email;

    @AssertTrue(message = "Must agree terms and conditions")
    private boolean agreed;

}
