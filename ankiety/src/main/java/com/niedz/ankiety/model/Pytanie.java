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

    private String pytanko;

    // gettery
    public Integer getId() { return Id; }

    public Integer getIdAnkiety() { return idAnkiety; }

    public String getPytanko() { return pytanko; }


    // settery
    public void setPytanko(String pytanie) { this.pytanko = pytanie; }

    public void setId(Integer id) {
        this.Id = id;
    }

    public void setPolling(Integer polling) {
        this.idAnkiety = polling;
    }

}
