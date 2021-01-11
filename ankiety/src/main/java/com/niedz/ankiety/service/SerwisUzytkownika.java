package com.niedz.ankiety.service;

import com.niedz.ankiety.model.Rola;
import com.niedz.ankiety.model.Uzytkownik;
import com.niedz.ankiety.repository.Role;
import com.niedz.ankiety.repository.Uzytkownicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.*;

public class SerwisUzytkownika {
    private Uzytkownicy uzytkownicy;
    private Role role;
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public SerwisUzytkownika(Uzytkownicy uzytkownicy, Role role, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.uzytkownicy = uzytkownicy;
        this.role = role;
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
        Rola rola = role.findByRola("main");
        uzytkownik.set_rola(new HashSet<Rola>(Collections.singletonList(rola)));
        return uzytkownicy.save(uzytkownik);
    }

    public Uzytkownik aktualizujUzytkownika(Uzytkownik uzytkownik, boolean zmiana_hasla){
        if(zmiana_hasla)
            uzytkownik.set_password(bCryptPasswordEncoder.encode(uzytkownik.get_password()));
        Rola rola = role.findByRola("main");
        uzytkownik.set_rola(new HashSet<Rola>(Collections.singletonList(rola)));
        return uzytkownicy.save(uzytkownik);
    }
}
