package com.dogadjaji_219.dogadjaji_219.models.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dogadjaji_219.dogadjaji_219.models.entities.Role;
import com.dogadjaji_219.dogadjaji_219.models.in.RoleIn;
import com.dogadjaji_219.dogadjaji_219.models.out.RoleOut;
import com.dogadjaji_219.dogadjaji_219.models.repositories.RoleRepository;
import com.dogadjaji_219.dogadjaji_219.models.services.RoleService;

public class RoleServiceImpl implements RoleService{
    @Autowired
    private RoleRepository _RoleRepository;

    @Override
    public List<RoleOut> getAll() {
        List<Role> roles = _RoleRepository.findAll();
        List<RoleOut> roleOuts = new ArrayList<>();

        for (Role role : roles) {
            roleOuts.add(new RoleOut(role));
        }
        return roleOuts;
    }

    @Override
    public RoleOut save(RoleIn roleIn) {
        Role role = new Role(roleIn);
        _RoleRepository.save(role);
        return new RoleOut();
    }

    @Override
    public RoleOut edit(Integer id, RoleIn roleIn) {
        Role role = _RoleRepository.findById(id).get();
        if(role != null){
            role.setName(roleIn.getName());
            _RoleRepository.save(role);
            return new RoleOut();
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Role role = _RoleRepository.findById(id).get();
        if(role != null){
            _RoleRepository.delete(role);
            return true;
        }
        return false;
    }

    @Override
    public Role getByIdDB(Integer id) {
        return _RoleRepository.findById(id).get();
    }

    @Override
    public Role getByName(String name) {
        return _RoleRepository.getByName(name);
    }

}
