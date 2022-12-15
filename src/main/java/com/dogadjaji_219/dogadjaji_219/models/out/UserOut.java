package com.dogadjaji_219.dogadjaji_219.models.out;

import com.dogadjaji_219.dogadjaji_219.models.entities.User;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
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

    
    
}
