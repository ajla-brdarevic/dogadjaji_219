package com.dogadjaji_219.dogadjaji_219.models.entities;

import java.util.Set;

import com.dogadjaji_219.dogadjaji_219.models.in.UserIn;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity 
public class User {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String email;
    
    private String password;

    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;

    private Set set;

    public User(String string, String string2, Set set){
        this.set = set;

    }

    public User(UserIn userIn){
        email = userIn.getEmail();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    
}
