package com.niedz.ankiety.service;

import com.niedz.ankiety.model.Ankietka;
import com.niedz.ankiety.repository.Ankiety;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SerwisAnkiet {
    private final Ankiety amkiety;

    @Autowired
    public SerwisAnkiet(Ankiety ankiety){ this.amkiety = ankiety; }

    public void stworz_ankiete(Ankietka ankieta){ amkiety.save(ankieta); }

    public Iterable<Ankietka> pokaz_wszystkie(){ return amkiety.findAll(); }

    public Iterable<Ankietka> pokaz_po_uzytkowniku(Integer uId){ return amkiety.findAllByTworca(uId); }

    public Optional<Ankietka> znajdz_po_numerze(Integer id){ return amkiety.findById(id); }

}
