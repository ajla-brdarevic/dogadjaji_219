package com.dogadjaji_219.dogadjaji_219.models.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dogadjaji_219.dogadjaji_219.models.entities.User;
import com.dogadjaji_219.dogadjaji_219.models.in.UserIn;
import com.dogadjaji_219.dogadjaji_219.models.out.UserOut;

@Service
public interface UserService {
    List<UserOut> getAll();
    UserOut save(UserIn userIn);
    UserOut edit(Integer id, UserIn userIn);
    boolean delete(Integer id);
    User getByEmail(String email);
}
