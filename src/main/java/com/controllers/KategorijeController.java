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

import com.dogadjaji_219.dogadjaji_219.models.in.KategorijaIn;
import com.dogadjaji_219.dogadjaji_219.models.out.KategorijaOut;
import com.dogadjaji_219.dogadjaji_219.models.services.KategorijaService;

@RestController
@RequestMapping("/api/kategorije")
public class KategorijeController {

    @Autowired
    private KategorijaService _KategorijaService;

    @GetMapping(value = "/")
    public List<KategorijaOut> getAllDogadjaje(){
        return _KategorijaService.getAll();
    }

    @PostMapping(value = "/")
    public KategorijaOut addKategorija(@RequestBody KategorijaIn kategorijaIn){
        return _KategorijaService.save(kategorijaIn);
    }

    @PutMapping(value = "/")
    public KategorijaOut editKategorija(@RequestParam("id") String id, @RequestBody KategorijaIn kategorijaIn){
        return _KategorijaService.edit(Integer.parseInt(id), kategorijaIn);
    }
}
