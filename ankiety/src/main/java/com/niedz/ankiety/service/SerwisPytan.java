package com.niedz.ankiety.service;

import com.niedz.ankiety.model.Pytanie;
import com.niedz.ankiety.repository.Pytania;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SerwisPytan {
    private final Pytania pytania;

    @Autowired
    public SerwisPytan(Pytania pytania){ this.pytania = pytania; }

    public void dodaj_pytanie(Pytanie pytanie){ pytania.save(pytanie); }

    public Iterable<Pytanie> znajdz_wszystkie_z_ankiety(Integer pId){ return pytania.findAllByIdAnkiety(pId); }
}
