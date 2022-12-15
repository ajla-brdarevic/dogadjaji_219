package com.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dogadjaji_219.dogadjaji_219.models.in.RoleIn;
import com.dogadjaji_219.dogadjaji_219.models.out.RoleOut;
import com.dogadjaji_219.dogadjaji_219.models.services.RoleService;

@RestController
@RequestMapping("/api/role")
public class RoleController {
    @Autowired
    private RoleService _RoleService;

    @GetMapping(value = "/")
    public List<RoleOut> getAll(){
        return _RoleService.getAll();
    }

    @PostMapping(value = "/")
    public RoleOut addKategorija(@RequestBody RoleIn roleIn){
        return _RoleService.save(roleIn);
    }

    @PostMapping(value = "/")
    public RoleOut edit(@RequestParam("id") String id, @RequestBody RoleIn roleIn) {
        return _RoleService.edit(Integer.parseInt(id), roleIn);
    }

    @PostMapping(value = "/")
    public boolean delete(@RequestParam("id") String id) {
        return _RoleService.delete(Integer.parseInt(id));
    }
}
