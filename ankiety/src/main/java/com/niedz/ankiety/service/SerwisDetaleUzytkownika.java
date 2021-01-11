package com.niedz.ankiety.service;

import com.niedz.ankiety.model.Rola;
import com.niedz.ankiety.model.Uzytkownik;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.Set;

@Service
public class SerwisDetaleUzytkownika implements UserDetailsService {
    @Autowired
    private SerwisUzytkownika serwis_uzytkownika;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Uzytkownik uzytkownik = serwis_uzytkownika.znajdzLogin(s);

        Set<GrantedAuthority> role = new HashSet<>();
        for(Rola rola: uzytkownik.get_rola())
            role.add(new SimpleGrantedAuthority(rola.get_rola()));

        return new org.springframework.security.core.userdetails.User(uzytkownik.get_login(),
                uzytkownik.get_password(), uzytkownik.get_active(), true, true, true,role);
    }
}