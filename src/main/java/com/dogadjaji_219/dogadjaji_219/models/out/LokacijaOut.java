package com.dogadjaji_219.dogadjaji_219.models.out;

import com.dogadjaji_219.dogadjaji_219.models.entities.Lokacija;

public class LokacijaOut {
    private Integer id;
    private String name;
    private String description;
    private String image;

    
    public LokacijaOut() {

    }

        
    public LokacijaOut(Lokacija lokacija) {
        id = lokacija.getId();
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

    
}
