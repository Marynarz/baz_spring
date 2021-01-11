package com.niedz.ankiety.service;

import com.niedz.ankiety.model.Uzytkownik;
import com.niedz.ankiety.repository.Uzytkownicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Optional;

public class SerwisUzytkownika {
    private Uzytkownicy uzytkownicy;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public SerwisUzytkownika(Uzytkownicy uzytkownicy, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.uzytkownicy = uzytkownicy;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public Uzytkownik znajdzLogin(String login){
        return uzytkownicy.findByLogin(login);
    }

    public Optional<Uzytkownik> znajdzId(Integer id){
        return uzytkownicy.findById(id);
    }

    public Iterable<Uzytkownik> wszyscyUzytkownicy(){
        return uzytkownicy.findAll();
    }

    public Uzytkownik zapiszUzytkownika(Uzytkownik uzytkownik){
        uzytkownik.set_password(bCryptPasswordEncoder.encode(uzytkownik.get_password()));
        uzytkownik.set_actibe(true);
        return uzytkownicy.save(uzytkownik);
    }

    public Uzytkownik aktualizujUzytkownika(Uzytkownik uzytkownik, boolean zmiana_hasla){
        if(zmiana_hasla)
            uzytkownik.set_password(bCryptPasswordEncoder.encode(uzytkownik.get_password()));
        return uzytkownicy.save(uzytkownik);
    }
}
