package com.niedz.ankiety.bean;

import java.util.ArrayList;
import java.util.List;

public class Pytania {
    public List<Pytanie> odpowiedzi;

    public Pytania(){ this.odpowiedzi = new ArrayList<>(); }

    public void dodajOdpowiedz(Pytanie odpowiedz){ this.odpowiedzi.add(odpowiedz); }

    public void setOdpowiedzi(List<Pytanie> odpowiedzi) { this.odpowiedzi = odpowiedzi; }

    public List<Pytanie> pokazOdpowiedzi(){ return odpowiedzi; }

}
