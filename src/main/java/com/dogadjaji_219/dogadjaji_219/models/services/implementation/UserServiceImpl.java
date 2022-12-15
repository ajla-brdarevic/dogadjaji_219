package com.dogadjaji_219.dogadjaji_219.models.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dogadjaji_219.dogadjaji_219.models.entities.Role;
import com.dogadjaji_219.dogadjaji_219.models.entities.User;
import com.dogadjaji_219.dogadjaji_219.models.in.UserIn;
import com.dogadjaji_219.dogadjaji_219.models.out.UserOut;
import com.dogadjaji_219.dogadjaji_219.models.repositories.UserRepository;
import com.dogadjaji_219.dogadjaji_219.models.services.RoleService;
import com.dogadjaji_219.dogadjaji_219.models.services.UserService;

@Service 
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository _UserRepository;

    @Autowired
    private RoleService _RoleService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public boolean delete(Integer id) {
        User user = _UserRepository.findById(id).get();
        if(user != null){
            _UserRepository.delete(user);
            return true;
        }
        return false;
    }

    @Override
    public UserOut edit(Integer id, UserIn userIn) {
        User user = _UserRepository.findById(id).get();
        if(user != null){
            user.setEmail(userIn.getEmail());
            _UserRepository.save(user);
            return new UserOut(user);
        }
        return null;
    }

    @Override
    public List<UserOut> getAll() {
        List<User> users = _UserRepository.findAll();
        List<UserOut> userOuts = new ArrayList<>();

        for (User user : users) {
            userOuts.add(new UserOut(user));
        }
        return userOuts;
    }

    @Override
    public User getByEmail(String email) {
        return _UserRepository.getByEmail(email);
    }

    @Override
    public UserOut save(UserIn userIn) {
        User user = new User(userIn);
        Role role = _RoleService.getByName("user");

        if(role != null){
            user.setPassword(getEncodedPassword(userIn.getPassword()));
            user.setRole(role);
            _UserRepository.save(user);
            return new UserOut(user);
        }
        return null;
    }

    private String getEncodedPassword(String password){
        return passwordEncoder.encode(password);
    }
}