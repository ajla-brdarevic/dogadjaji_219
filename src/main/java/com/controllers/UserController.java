package com.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogadjaji_219.dogadjaji_219.models.entities.User;
import com.dogadjaji_219.dogadjaji_219.models.services.UserService;

import lombok.RequiredArgsConstructor;

@RestController 
@RequestMapping ("/api")
@RequiredArgsConstructor
public class UserController {
    private final UserService _UserService;

    @GetMapping("/usres")
    public ResponseEntity<List<User>>getUsers(){
        return ResponseEntity.ok().body(_UserService.getUsers());
    }
}
