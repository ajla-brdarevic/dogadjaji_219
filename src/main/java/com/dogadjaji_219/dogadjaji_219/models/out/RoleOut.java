package com.dogadjaji_219.dogadjaji_219.models.out;

import com.dogadjaji_219.dogadjaji_219.models.entities.Role;

public class RoleOut {
    private Integer id;
    private String name;
    
    public RoleOut() {
    }
    
    public RoleOut(Role role) {
        id = role.getId();
        name = role.getName();
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
