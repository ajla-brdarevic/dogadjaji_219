package com.dogadjaji_219.dogadjaji_219.models.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dogadjaji_219.dogadjaji_219.models.entities.Lokacija;
import com.dogadjaji_219.dogadjaji_219.models.in.LokacijaIn;
import com.dogadjaji_219.dogadjaji_219.models.out.LokacijaOut;

@Service
public interface LokacijaService {
    public List<LokacijaOut> getAll();

    public LokacijaOut save(LokacijaIn lokacijaIn);

    public LokacijaOut edit(Integer id, LokacijaIn lokacijaIn);

    Lokacija getByIdDB(Integer id);
}
