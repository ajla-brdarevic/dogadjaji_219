package com.dogadjaji_219.dogadjaji_219.models.services.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.dogadjaji_219.dogadjaji_219.models.entities.Dogadjaji;
import com.dogadjaji_219.dogadjaji_219.models.entities.Kategorija;
import com.dogadjaji_219.dogadjaji_219.models.entities.Lokacija;
import com.dogadjaji_219.dogadjaji_219.models.in.DogadjajiIn;
import com.dogadjaji_219.dogadjaji_219.models.out.DogadjajiOut;
import com.dogadjaji_219.dogadjaji_219.models.repositories.DogadjajiRepository;
import com.dogadjaji_219.dogadjaji_219.models.services.DogadjajiService;
import com.dogadjaji_219.dogadjaji_219.models.services.KategorijaService;
import com.dogadjaji_219.dogadjaji_219.models.services.LokacijaService;

public class DogadjajiSerivceImp implements DogadjajiService{
    @Autowired
    private DogadjajiRepository _DogadjajiRepository;

    @Autowired
    private LokacijaService _LokacijaService;

    @Autowired
    private KategorijaService _KategorijaService;

    @Override
    public List<DogadjajiOut> getAll() {
        List<Dogadjaji> dogadjaji = _DogadjajiRepository.findAll();
        List<DogadjajiOut> dogadjajiOuts = new ArrayList<>();

        for (Dogadjaji dogadjaj : dogadjaji) {
            dogadjajiOuts.add(new DogadjajiOut(dogadjaj));
        }
        return dogadjajiOuts;
    }

    @Override
    public DogadjajiOut save(DogadjajiIn dogadjajiIn) {
        Dogadjaji dogadjaji = new Dogadjaji(dogadjajiIn);
        _DogadjajiRepository.save(dogadjaji);
        return new DogadjajiOut();
    }

    @Override
    public DogadjajiOut edit(Integer id, DogadjajiIn dogadjajiIn) {
        Dogadjaji dogadjaji = _DogadjajiRepository.findById(id).get();
        if(dogadjaji != null){
            dogadjaji.setName(dogadjajiIn.getName());
            dogadjaji.setDate(dogadjajiIn.getDate());
            dogadjaji.setDescription(dogadjajiIn.getDescription());
            dogadjaji.setImageEvent(dogadjajiIn.getImageEvent());

            Lokacija lokacija = _LokacijaService.getByIdDB(dogadjajiIn.getLokacijaId());
            dogadjaji.setLokacija(lokacija);

            Kategorija kategorija = _KategorijaService.getByIdDB(dogadjajiIn.getKategorijaId());
            dogadjaji.setKategorija(kategorija);

            _DogadjajiRepository.save(dogadjaji);
            return new DogadjajiOut();
        }
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        Dogadjaji dogadjaji = _DogadjajiRepository.findById(id).get();
        if(dogadjaji != null){
            _DogadjajiRepository.delete(dogadjaji);
            return true;
        }
        return false;
    }
    
}
