package com.dogadjaji_219.dogadjaji_219.models.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.dogadjaji_219.dogadjaji_219.models.entities.Kategorija;
import com.dogadjaji_219.dogadjaji_219.models.in.KategorijaIn;
import com.dogadjaji_219.dogadjaji_219.models.out.KategorijaOut;

@Service
public interface KategorijaService {

    List<KategorijaOut> getAll();

    KategorijaOut save(KategorijaIn kategorijaIn);
    
    KategorijaOut edit(Integer id, KategorijaIn kategorijaIn);

    Kategorija getByIdDB(Integer id);
}
