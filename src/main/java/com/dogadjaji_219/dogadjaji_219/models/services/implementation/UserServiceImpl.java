package com.dogadjaji_219.dogadjaji_219.models.services.implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dogadjaji_219.dogadjaji_219.models.entities.Role;
import com.dogadjaji_219.dogadjaji_219.models.entities.User;
import com.dogadjaji_219.dogadjaji_219.models.repositories.RoleRepository;
import com.dogadjaji_219.dogadjaji_219.models.repositories.UserRepository;
import com.dogadjaji_219.dogadjaji_219.models.services.UserService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service @RequiredArgsConstructor @Transactional @Slf4j
public class UserServiceImpl implements UserService{

    private final UserRepository _UserRepository;
    private final RoleRepository _RoleRepository;

    @Override
    public void addRoleToUser(String email, String roleName) {
        User user = _UserRepository.findByEmail(email);
        Role role = _RoleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String email) {
        return _UserRepository.findByEmail(email);
    }

    @Override
    public List<User> getUsers() {
        return _UserRepository.findAll();
    }

    @Override
    public Role saveRole(Role role) {
        return _RoleRepository.save(role);
    }

    @Override
    public User saveUser(User user) {
        return _UserRepository.save(user);
    }
    

}
