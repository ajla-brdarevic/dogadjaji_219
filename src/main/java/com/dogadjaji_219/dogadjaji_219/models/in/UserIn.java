package com.dogadjaji_219.dogadjaji_219.models.in;

import io.micrometer.common.lang.Nullable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserIn {
    @Nullable
    private Integer id;
    private String email;
    private String password;
    
    public UserIn() {
    }

    
}
