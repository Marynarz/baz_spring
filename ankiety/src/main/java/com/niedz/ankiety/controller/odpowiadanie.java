package com.niedz.ankiety.controller;

import com.niedz.ankiety.model.Odpowiedz;
import com.niedz.ankiety.service.SerwisOdpowiedzi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class odpowiadanie {
    @Autowired
    private SerwisOdpowiedzi serwis_odpowiedzi;

    @PostMapping(path="/odpowiedzi/dodaj")
    public @ResponseBody String odpowiedz(@RequestParam String odp, @RequestParam Integer pId){
        Odpowiedz odpowiedz = new Odpowiedz();
        odpowiedz.set_odpowiedz(odp);
        odpowiedz.set_id_pytania(pId);
        odpowiedz.zeruj_ilosc_odpowiedzi();
        serwis_odpowiedzi.odpowiedz(odpowiedz);
        return "Odpowiedziales: " + odpowiedz.get_odpowiedz();
    }
}
