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
public class Pytanie {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer Id;

    private Integer idAnkiety;

    private String pytanie;

    private String opis;

    // gettery
    public Integer getId() { return Id; }

    public Integer getIdAnkiety() { return idAnkiety; }

    public String getPytanie() { return pytanie; }

    public String getOpis() { return opis; }

    // settery
    public void setPytanie(String pytanie) { this.pytanie = pytanie; }

    public void setOpis(String opis) { this.opis = opis; }
}
