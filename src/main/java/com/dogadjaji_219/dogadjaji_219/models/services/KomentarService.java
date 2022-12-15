package com.dogadjaji_219.dogadjaji_219.models.services;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dogadjaji_219.dogadjaji_219.models.entities.Dogadjaji;
import com.dogadjaji_219.dogadjaji_219.models.entities.Komentar;
import com.dogadjaji_219.dogadjaji_219.models.entities.User;
import com.dogadjaji_219.dogadjaji_219.models.in.KomentarIn;
import com.dogadjaji_219.dogadjaji_219.models.repositories.DogadjajiRepository;
import com.dogadjaji_219.dogadjaji_219.models.repositories.KomentarRepository;

@Service
public class KomentarService {

    @Autowired
    private KomentarRepository _KomentarRepository;

    @Autowired
    private DogadjajiRepository _DogadjajiRepository;

    public Komentar save(KomentarIn komentarIn, User user) {
        Komentar komentar = new Komentar();
        Optional<Dogadjaji> dogadjaji = _DogadjajiRepository.findById(komentarIn.getDogadjajiId());
        dogadjaji.ifPresent(d -> komentarIn.setDogadjajiId(d.getId()));
        komentar.setTekstKomentara(komentar.getTekstKomentara());
        komentar.setCreatedBy(user);
        komentar.setDatumVrijeme(LocalDateTime.now());
        return _KomentarRepository.save(komentar);
    }
}
