package com.dogadjaji_219.dogadjaji_219.models.entities;

import java.util.ArrayList;
import java.util.Collection;

import com.dogadjaji_219.dogadjaji_219.models.in.UserIn;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity @Setter @Getter
public class User {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;
    
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;

    public User(){

    }

    public User(UserIn userIn){
        email = userIn.getEmail();
    }
}
