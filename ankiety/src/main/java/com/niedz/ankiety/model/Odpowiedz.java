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
public class Odpowiedz {

    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private Integer id_pytania;

    private String odpowiedz;

    private Integer ilosc_odpowiedzi = 0;

    // gettery
    public Integer get_id() { return Id; }

    public Integer get_id_pytania() { return id_pytania; }

    public String get_odpowiedz() { return odpowiedz; }

    public Integer get_ilosc_odpowiedzi() { return ilosc_odpowiedzi; }

    // settery
    public void set_odpowiedz(String odpowiedz) { this.odpowiedz = odpowiedz; }

    public void add_odpowiedz() { this.ilosc_odpowiedzi++; }

    public void zeruj_ilosc_odpowiedzi() { this.ilosc_odpowiedzi = 0; }
}
