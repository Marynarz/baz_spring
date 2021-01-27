package com.niedz.ankiety.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Rola {
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name= "id_roli")
    private Integer Id;

    private String rola;

    public void setRola(String s){ this.rola = s; }

    public String getRola(){ return rola; }
}
