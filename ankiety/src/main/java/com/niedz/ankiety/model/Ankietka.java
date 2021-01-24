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

    private Integer getId() { return Id; }

    private Integer getTworca() { return tworca; }

    private String getTytul() { return tytul; }

    private String getOpis() { return opis; }

    // settery
    private void setTytul(String tytul) { this.tytul = tytul; }

    private void setOpis(String opis) { this.opis = opis; }
}
