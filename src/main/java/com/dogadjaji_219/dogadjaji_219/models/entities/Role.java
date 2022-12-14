package com.dogadjaji_219.dogadjaji_219.models.entities;

import java.util.List;

import com.dogadjaji_219.dogadjaji_219.models.in.RoleIn;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Role {
    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany (mappedBy = "role", fetch = FetchType.EAGER)
    private List<User> users;

    public Role() {
    }

    public Role(RoleIn roleIn){
        name = roleIn.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    
}
