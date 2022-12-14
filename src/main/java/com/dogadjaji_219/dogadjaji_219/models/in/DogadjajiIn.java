package com.dogadjaji_219.dogadjaji_219.models.in;

import java.util.Date;

public class DogadjajiIn {
    private String name;
    private Date date;
    private String description;
    private String imageEvent;
    private Integer kategorijaId;
    private Integer lokacijaId;
    
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
    public Integer getKategorijaId() {
        return kategorijaId;
    }
    public void setKategorijaId(Integer kategorijaId) {
        this.kategorijaId = kategorijaId;
    }
    public Integer getLokacijaId() {
        return lokacijaId;
    }
    public void setLokacijaId(Integer lokacijaId) {
        this.lokacijaId = lokacijaId;
    }

    
}
