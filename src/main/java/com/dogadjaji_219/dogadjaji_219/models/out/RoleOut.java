package com.dogadjaji_219.dogadjaji_219.models.out;

import com.dogadjaji_219.dogadjaji_219.models.entities.Role;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class RoleOut {
    private Integer id;
    private String name;
    public RoleOut() {
    }

    public RoleOut(Role role){
        id = role.getId();
        name = role.getName();
    }
}

