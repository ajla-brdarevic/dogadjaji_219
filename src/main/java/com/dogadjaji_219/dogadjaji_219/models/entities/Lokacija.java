package com.dogadjaji_219.dogadjaji_219.models.entities;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Lokacija {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private String image;

    @OneToMany(mappedBy = "lokacija", fetch = FetchType.LAZY)
    private List<Dogadjaji> dogadjaji;
    
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<Dogadjaji> getDogadjaji() {
        return dogadjaji;
    }

    public void setDogadjaji(List<Dogadjaji> dogadjaji) {
        this.dogadjaji = dogadjaji;
    }

}
