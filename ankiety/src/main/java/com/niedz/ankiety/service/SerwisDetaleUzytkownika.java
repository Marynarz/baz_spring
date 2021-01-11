package com.niedz.ankiety.service;

import com.niedz.ankiety.model.Uzytkownik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.transaction.Transactional;

public class SerwisDetaleUzytkownika implements UserDetailsService {
    @Autowired
    private SerwisUzytkownika serwis_uzytkownika;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Uzytkownik uzytkownik = serwis_uzytkownika.znajdzLogin(s);
        return new org.springframework.security.core.userdetails.User(uzytkownik.get_login(),
                uzytkownik.get_password(), uzytkownik.get_active(), true, true, true,null);
    }
}
