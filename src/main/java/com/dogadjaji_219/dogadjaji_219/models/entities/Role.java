package com.dogadjaji_219.dogadjaji_219.models.entities;

import java.util.List;

import com.dogadjaji_219.dogadjaji_219.models.in.RoleIn;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Entity @Getter @Setter  
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(max=255)
    private String name;

    @OneToMany(mappedBy = "role", fetch = FetchType.EAGER)
    private List<User> users;

    public Role() {
    }

    public Role(RoleIn roleIn){
        name = roleIn.getName();
    }
}
