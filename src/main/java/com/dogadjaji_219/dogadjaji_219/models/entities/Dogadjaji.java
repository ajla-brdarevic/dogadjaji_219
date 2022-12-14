package com.dogadjaji_219.dogadjaji_219.models.entities;

import java.util.Date;

import com.dogadjaji_219.dogadjaji_219.models.in.DogadjajiIn;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Dogadjaji {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    
    private Date date;
    
    private String description;
    
    private String imageEvent;
    
    @ManyToOne
    private Lokacija lokacija;
    
    @ManyToOne
    private Kategorija kategorija;

    public Dogadjaji(DogadjajiIn dogadjajiIn){
        name = dogadjajiIn.getName();
        date = dogadjajiIn.getDate();
        description = dogadjajiIn.getDescription();
        imageEvent = dogadjajiIn.getImageEvent();

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

    public Lokacija getLokacija() {
        return lokacija;
    }

    public void setLokacija(Lokacija lokacija) {
        this.lokacija = lokacija;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }
   
}
