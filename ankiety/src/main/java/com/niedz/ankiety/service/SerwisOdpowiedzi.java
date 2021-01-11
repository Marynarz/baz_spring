package com.niedz.ankiety.service;

import com.niedz.ankiety.model.Odpowiedz;
import com.niedz.ankiety.repository.Odpowiedzi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SerwisOdpowiedzi {
    private final Odpowiedzi odpowiedzi;

    @Autowired
    public SerwisOdpowiedzi(Odpowiedzi odp){ this.odpowiedzi = odp; }

    public Odpowiedz odpowiedz(Odpowiedz odp){ return odpowiedzi.save(odp); }

    public Iterable<Odpowiedz> znajdz_wszystkie_po_pytaniu(Integer pId){ return odpowiedzi.findAllBy_id_pytania(pId); }

    public Optional<Odpowiedz> znajdz_po_id(Integer Id){ return odpowiedzi.findById(Id); }
}
