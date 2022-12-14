package com.dogadjaji_219.dogadjaji_219.models.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dogadjaji_219.dogadjaji_219.models.entities.Lokacija;
import com.dogadjaji_219.dogadjaji_219.models.in.LokacijaIn;
import com.dogadjaji_219.dogadjaji_219.models.out.LokacijaOut;
import com.dogadjaji_219.dogadjaji_219.models.repositories.LokacijaRepository;
import com.dogadjaji_219.dogadjaji_219.models.services.LokacijaService;

public class LokacijaServiceImpl implements LokacijaService{
    @Autowired
    private LokacijaRepository _LokacijaRepository;

    @Override
    public List<LokacijaOut> getAll() {
        List<Lokacija> lokacije = _LokacijaRepository.findAll();
        List<LokacijaOut> LokacijaOuts = new ArrayList<>();

        for (Lokacija lokacija : lokacije) {
            LokacijaOuts.add(new LokacijaOut(lokacija));
        }
        return LokacijaOuts;
    }

   /* @Override
    public LokacijaOut save(LokacijaIn lokacijaIn) {
        Lokacija lokacija = new Lokacija(lokacijaIn);
        _LokacijaRepository.save(lokacija);
        return new LokacijaOut();
    }*/

    @Override
    public LokacijaOut edit(Integer id, LokacijaIn lokacijaIn) {
        Lokacija lokacije = _LokacijaRepository.findById(id).get();
        if(lokacije != null){
            lokacije.setName(lokacijaIn.getName());
            _LokacijaRepository.save(lokacije);
            return new LokacijaOut();
        }
        return null;
    }

   
    @Override
    public Lokacija getByIdDB(Integer id) {
        return _LokacijaRepository.findById(id).get();
    }

   

    
}
