package com.niedz.ankiety.bean;

public class Pytanie {
    public Integer id;
    public String opis;
    public Boolean zaznaczone;
    public Integer numer_pytania;

    // setery
    public void set_id(Integer id){
        this.id = id;
    }

    public void set_opis(String opis){
        this.opis = opis;
    }

    public void set_zaznaczone(Boolean zaznaczone){
        this.zaznaczone = zaznaczone;
    }

    public void set_numer_pytania(Integer numer_pytania){
        this.numer_pytania = numer_pytania;
    }

    // getery
    public Integer get_id(){
        return id;
    }

    public String get_opis(){
        return opis;
    }

    public Boolean get_zaznaczone(){
        return zaznaczone;
    }

    public Integer get_numer_pytania(){
        return numer_pytania;
    }

    // konstruktory
    public Pytanie(){
    }

    public Pytanie(Integer id, String opis, Integer numer_pytania){
        set_id(id);
        set_opis(opis);
        set_numer_pytania(numer_pytania);
        set_zaznaczone(false);
    }

}
