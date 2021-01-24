package com.niedz.ankiety.bean;

public class Pytanie {
    public Integer Id;
    public String opis;
    public Boolean zaznaczone;
    public Integer numer_pytania;

    // setery
    public void setId(Integer id){ this.Id = id; }

    public void setOpis(String opis){ this.opis = opis; }

    public void setZaznaczone(Boolean zaznaczone){ this.zaznaczone = zaznaczone;  }

    public void setNumerPytania(Integer numer_pytania){ this.numer_pytania = numer_pytania; }

    // getery
    public Integer getId(){ return Id; }

    public String getOpis(){ return opis; }

    public Boolean getZaznaczone(){ return zaznaczone; }

    public Integer getNumerPytania(){ return numer_pytania; }

    // konstruktory
    public Pytanie(){
    }

    public Pytanie(Integer id, String opis, Integer numer_pytania){
        setId(id);
        setOpis(opis);
        setNumerPytania(numer_pytania);
        setZaznaczone(false);
    }

}
