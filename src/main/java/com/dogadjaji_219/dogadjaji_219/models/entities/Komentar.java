package com.dogadjaji_219.dogadjaji_219.models.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "komentari")
public class Komentar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private LocalDateTime datumVrijeme;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User createdBy;
    private String tekstKomentara;

    @ManyToOne
    private Dogadjaji dogadjaji;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDateTime getDatumVrijeme() {
        return datumVrijeme;
    }

    public void setDatumVrijeme(LocalDateTime datumVrijeme) {
        this.datumVrijeme = datumVrijeme;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(User createdBy) {
        this.createdBy = createdBy;
    }

    public String getTekstKomentara() {
        return tekstKomentara;
    }

    public void setTekstKomentara(String tekstKomentara) {
        this.tekstKomentara = tekstKomentara;
    }

    public Dogadjaji getDogadjaji() {
        return dogadjaji;
    }

    public void setDogadjaji(Dogadjaji dogadjaji) {
        this.dogadjaji = dogadjaji;
    }

   
    
}
