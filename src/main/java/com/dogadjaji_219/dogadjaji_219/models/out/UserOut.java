package com.dogadjaji_219.dogadjaji_219.models.out;

import com.dogadjaji_219.dogadjaji_219.models.entities.User;

public class UserOut {
    private Integer id;
    private String email;
    private String roleName;
    public UserOut() {
    }
    public UserOut(User user) {
        id = user.getId();
        email = user.getEmail();
        roleName = user.getRole().getName();
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
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    
    
}
