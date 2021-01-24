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

    private Integer idPytania;

    private String odpowiedz;

    private Integer ilosc_odpowiedzi = 0;

    // gettery
    public Integer getId() { return Id; }

    public Integer getIdPytania() { return idPytania; }

    public String getOdpowiedz() { return odpowiedz; }

    public Integer getIloscOdpowiedzi() { return ilosc_odpowiedzi; }

    // settery
    public void setOdpowiedz(String odpowiedz) { this.odpowiedz = odpowiedz; }

    public void addOdpowiedz() { this.ilosc_odpowiedzi++; }

    public void setIdPytania(Integer pId) { this.idPytania = pId; }

    public void zerujIloscOdpowiedzi() { this.ilosc_odpowiedzi = 0; }
}
