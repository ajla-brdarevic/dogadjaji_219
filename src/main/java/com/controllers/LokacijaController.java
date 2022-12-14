package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dogadjaji_219.dogadjaji_219.models.in.LokacijaIn;
import com.dogadjaji_219.dogadjaji_219.models.out.LokacijaOut;
import com.dogadjaji_219.dogadjaji_219.models.services.LokacijaService;


@RestController
@RequestMapping("/api/lokacije")
public class LokacijaController {
    
    @Autowired
    private LokacijaService _LokacijaService;

    @GetMapping(value = "/")
    public List<LokacijaOut> getAllLokacije(){
        return _LokacijaService.getAll();
    }

    @PostMapping(value = "/")
    public LokacijaOut addLokacija(@RequestBody LokacijaIn lokacijaIn){
        return _LokacijaService.save(lokacijaIn);
    }

    @PutMapping(value = "/")
    public LokacijaOut editLokacija(@RequestParam("id") String id, @RequestBody LokacijaIn lokacijaIn){
        return _LokacijaService.edit(Integer.parseInt(id), lokacijaIn);
    }
}
