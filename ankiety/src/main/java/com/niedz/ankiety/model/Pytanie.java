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

    private Integer id_ankiety;

    private String pytanie;

    private String opis;

    // gettery
    public Integer get_id() { return Id; }

    public Integer get_id_ankiety() { return id_ankiety; }

    public String get_pytanie() { return pytanie; }

    public String get_opis() { return opis; }

    // settery
    public void set_pytanie(String pytanie) { this.pytanie = pytanie; }

    public void set_opis(String opis) { this.opis = opis; }
}
