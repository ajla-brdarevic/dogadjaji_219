package com.dogadjaji_219.dogadjaji_219.models.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dogadjaji_219.dogadjaji_219.models.entities.Role;
import com.dogadjaji_219.dogadjaji_219.models.in.RoleIn;
import com.dogadjaji_219.dogadjaji_219.models.out.RoleOut;

@Service
public interface RoleService {
    List<RoleOut> getAll();

    RoleOut save(RoleIn roleIn);

    RoleOut edit(Integer id, RoleIn roleIn);

    boolean delete(Integer id);

    Role getByIdDB(Integer id);

    Role getByName(String name);
}
