package com.dogadjaji_219.dogadjaji_219.models.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dogadjaji_219.dogadjaji_219.models.entities.Kategorija;
import com.dogadjaji_219.dogadjaji_219.models.in.KategorijaIn;
import com.dogadjaji_219.dogadjaji_219.models.out.KategorijaOut;
import com.dogadjaji_219.dogadjaji_219.models.repositories.KategorijaRepository;
import com.dogadjaji_219.dogadjaji_219.models.services.KategorijaService;

public class KategorijaServiceImpl implements KategorijaService{
    @Autowired
    private KategorijaRepository _KategorijaRepository;

    @Override
    public List<KategorijaOut> getAll() {
        List<Kategorija> kategorije = _KategorijaRepository.findAll();
        List<KategorijaOut> kategorijaOuts = new ArrayList<>();

        for (Kategorija kategorija : kategorije) {
            kategorijaOuts.add(new KategorijaOut(kategorija));
        }
        return kategorijaOuts;
    }

    @Override
    public KategorijaOut save(KategorijaIn kategorijaIn) {
        Kategorija kategorija = new Kategorija(kategorijaIn);
        _KategorijaRepository.save(kategorija);
        return new KategorijaOut();
    }

    @Override
    public KategorijaOut edit(Integer id, KategorijaIn kategorijaIn) {
        Kategorija kategorija = _KategorijaRepository.findById(id).get();
        if(kategorija != null){
            kategorija.setName(kategorijaIn.getName());
            kategorija.setIcon(kategorijaIn.getIcon());
            _KategorijaRepository.save(kategorija);
            return new KategorijaOut();
        }
        return null;
    }

    @Override
    public Kategorija getByIdDB(Integer id) {
        return _KategorijaRepository.findById(id).get();
    }

        
}
