package com.dogadjaji_219.dogadjaji_219.models.out;

import com.dogadjaji_219.dogadjaji_219.models.entities.Kategorija;

public class KategorijaOut {
    private Integer id;
    private String name;
    private String icon;

    public KategorijaOut(){

    }

    public KategorijaOut(Kategorija kategorija){
        id = kategorija.getId();
        name = kategorija.getName();
        icon = kategorija.getIcon();
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

    
}