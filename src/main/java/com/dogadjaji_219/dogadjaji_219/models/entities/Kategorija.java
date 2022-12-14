package com.dogadjaji_219.dogadjaji_219.models.entities;

import java.util.List;

import com.dogadjaji_219.dogadjaji_219.models.in.KategorijaIn;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Kategorija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    private String icon;

    @OneToMany(mappedBy = "kategorija", fetch = FetchType.LAZY)
    private List<Dogadjaji> dogadjaji;
    
    public Kategorija(KategorijaIn kategorijaIn) {
        name = kategorijaIn.getName();
        icon = kategorijaIn.getIcon();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public List<Dogadjaji> getDogadjaji() {
        return dogadjaji;
    }

    public void setDogadjaji(List<Dogadjaji> dogadjaji) {
        this.dogadjaji = dogadjaji;
    }

    
    
}
