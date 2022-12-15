package com.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dogadjaji_219.dogadjaji_219.models.entities.Komentar;
import com.dogadjaji_219.dogadjaji_219.models.entities.User;
import com.dogadjaji_219.dogadjaji_219.models.in.KomentarIn;
import com.dogadjaji_219.dogadjaji_219.models.services.KomentarService;

@RestController
@RequestMapping("/api/komentari")
public class KomentarController {

    @Autowired
    private KomentarService _KomentarService;
    
    @PostMapping("")
    public ResponseEntity<Komentar> createComment(@RequestBody KomentarIn komentarIn, @AuthenticationPrincipal User user) {
        Komentar komentar = _KomentarService.save(komentarIn, user);
        return ResponseEntity.status(HttpStatus.OK).body(komentar);
    }
    
}
