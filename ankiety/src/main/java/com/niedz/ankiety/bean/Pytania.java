package com.niedz.ankiety.bean;

import java.util.ArrayList;
import java.util.List;

public class Pytania {
    public List<Pytanie> odpowiedzi;

    public Pytania(){ this.odpowiedzi = new ArrayList<>(); }

    public void dodaj_odpowiedz(Pytanie odpowiedz){ this.odpowiedzi.add(odpowiedz); }

    public List<Pytanie> pokaz_odpowiedzi(){ return odpowiedzi; }

}
