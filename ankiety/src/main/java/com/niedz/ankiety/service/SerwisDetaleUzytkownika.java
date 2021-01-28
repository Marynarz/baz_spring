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
    private SerwisUzytkownika serwisUzytkownika;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Uzytkownik uzytkownik = serwisUzytkownika.znajdzLogin(s);
        System.out.println(s);
        System.out.println(uzytkownik);

        Set<GrantedAuthority> role = new HashSet<>();
        for(Rola rola: uzytkownik.getRola())
            role.add(new SimpleGrantedAuthority(rola.getRola()));

        return new org.springframework.security.core.userdetails.User(uzytkownik.getLogin(),
                uzytkownik.getPassword(), uzytkownik.getActive(), true, true, true,role);
    }
}
