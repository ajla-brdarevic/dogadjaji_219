package com.dogadjaji_219.dogadjaji_219.models.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dogadjaji_219.dogadjaji_219.models.entities.Role;
import com.dogadjaji_219.dogadjaji_219.models.entities.User;

@Service
public interface UserService {
    User saveUser(User user);
    Role saveRole(Role role);

    void addRoleToUser(String email, String roleName);
    User getUser(String email);
    List<User> getUsers();
}
