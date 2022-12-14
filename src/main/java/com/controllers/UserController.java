package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dogadjaji_219.dogadjaji_219.models.in.UserIn;
import com.dogadjaji_219.dogadjaji_219.models.out.UserOut;
import com.dogadjaji_219.dogadjaji_219.models.services.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService _UserService;

    @GetMapping(value = "/")
    public List<UserOut> getAll(){
        return _UserService.getAll();
    }

    @PostMapping(value = "/")
    public UserOut save(@RequestBody UserIn userIn) {
        return _UserService.save(userIn);
    }

    @PutMapping(value = "/")
    public UserOut edit(@RequestParam("id") String id, @RequestBody UserIn userIn) {
        return _UserService.edit(Integer.parseInt(id), userIn);
    }

    @DeleteMapping(value = "/")
    public boolean delete(@RequestParam("id") String id) {
        return _UserService.delete(Integer.parseInt(id));
    }
}
