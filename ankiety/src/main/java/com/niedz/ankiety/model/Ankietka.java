package com.niedz.ankiety.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Ankietka {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private Integer tworca;

    private String tytul;

    private String opis;

    // gettery

    public Integer getId() { return Id; }

    public Integer getTworca() { return tworca; }

    public String getTytul() { return tytul; }

    public String getOpis() { return opis; }

    // settery
    public void setTytul(String tytul) { this.tytul = tytul; }

    public void setOpis(String opis) { this.opis = opis; }
}
