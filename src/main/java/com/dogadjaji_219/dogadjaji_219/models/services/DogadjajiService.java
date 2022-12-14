package com.dogadjaji_219.dogadjaji_219.models.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dogadjaji_219.dogadjaji_219.models.in.DogadjajiIn;
import com.dogadjaji_219.dogadjaji_219.models.out.DogadjajiOut;

@Service
public interface DogadjajiService {
    List<DogadjajiOut> getAll();

    DogadjajiOut save(DogadjajiIn dogadjajiIn);
    
    DogadjajiOut edit(Integer id, DogadjajiIn roleIn);
    
    boolean delete(Integer id);
}
