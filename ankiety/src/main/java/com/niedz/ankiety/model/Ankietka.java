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

    private Integer get_id() { return Id; }

    private Integer get_tworca() { return tworca; }

    private String get_tytul() { return tytul; }

    private String get_opis() { return opis; }

    // settery
    private void set_tytul(String tytul) { this.tytul = tytul; }

    private void set_opis(String opis) { this.opis = opis; }
}
