package com.dogadjaji_219.dogadjaji_219.models.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dogadjaji_219.dogadjaji_219.models.entities.Lokacija;

@Repository
public interface LokacijaRepository extends JpaRepository<Lokacija, Integer>{
    
}
