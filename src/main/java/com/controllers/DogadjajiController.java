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

import com.dogadjaji_219.dogadjaji_219.models.in.DogadjajiIn;
import com.dogadjaji_219.dogadjaji_219.models.out.DogadjajiOut;
import com.dogadjaji_219.dogadjaji_219.models.services.DogadjajiService;

@RestController
@RequestMapping("/api/dogadjaji")
public class DogadjajiController {
    
    @Autowired
    private DogadjajiService _DogadjajiService;

    @GetMapping(value = "/")
    public List<DogadjajiOut> getAll(){
        return _DogadjajiService.getAll();
    }

    @PostMapping(value = "/")
    public DogadjajiOut save(@RequestBody DogadjajiIn dogadjajiIn) {
        return _DogadjajiService.save(dogadjajiIn);
    }

    @PutMapping(value = "/")
    public DogadjajiOut edit(@RequestParam("id") String id, @RequestBody DogadjajiIn dogadjajiIn) {
        return _DogadjajiService.edit(Integer.parseInt(id), dogadjajiIn);
    }

    @DeleteMapping(value = "/")
    public boolean delete(@RequestParam("id") String id) {
        return _DogadjajiService.delete(Integer.parseInt(id));
    }
}
