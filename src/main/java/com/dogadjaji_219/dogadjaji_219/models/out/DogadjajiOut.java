package com.dogadjaji_219.dogadjaji_219.models.out;

import java.util.Date;

import com.dogadjaji_219.dogadjaji_219.models.entities.Dogadjaji;

public class DogadjajiOut {
    private Integer id;
    private String name;
    private Date date;
    private String description;
    private String imageEvent;
    private String kategorija;
    private String lokacija;
    public DogadjajiOut() {
    }

    public DogadjajiOut(Dogadjaji dogadjaji){
        name = dogadjaji.getName();
        date = dogadjaji.getDate();
        description = dogadjaji.getDescription();
        imageEvent = dogadjaji.getImageEvent();
        kategorija = dogadjaji.getKategorija().getName();
        lokacija = dogadjaji.getLokacija().getName();
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

    public String getKategorija() {
        return kategorija;
    }

    public void setKategorija(String kategorija) {
        this.kategorija = kategorija;
    }

    public String getLokacija() {
        return lokacija;
    }

    public void setLokacija(String lokacija) {
        this.lokacija = lokacija;
    }

    
}
