package com.dogadjaji_219.dogadjaji_219.models.in;

import java.util.Date;

public class DogadjajiIn {
    private String name;
    private Date date;
    private String description;
    private String imageEvent;
    private String kategorijaId;
    private String lokacijaId;
    
    public DogadjajiIn() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getImageEvent() {
        return imageEvent;
    }
    public void setImageEvent(String imageEvent) {
        this.imageEvent = imageEvent;
    }
    public String getKategorijaId() {
        return kategorijaId;
    }
    public void setKategorijaId(String kategorijaId) {
        this.kategorijaId = kategorijaId;
    }
    public String getLokacijaId() {
        return lokacijaId;
    }
    public void setLokacijaId(String lokacijaId) {
        this.lokacijaId = lokacijaId;
    }

    
}
