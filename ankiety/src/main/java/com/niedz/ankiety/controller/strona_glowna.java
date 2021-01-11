package com.niedz.ankiety.controller;

import com.niedz.ankiety.model.Uzytkownik;
import com.niedz.ankiety.service.SerwisAnkiet;
import com.niedz.ankiety.service.SerwisUzytkownika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class strona_glowna {
    @Autowired
    private SerwisUzytkownika serwis_uzytkownika;

    @Autowired
    private SerwisAnkiet serwis_ankiet;

    @GetMapping(value="/")
    public ModelAndView glowny_widok(){
        ModelAndView m_a_v = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Uzytkownik uzytkownik = serwis_uzytkownika.znajdzLogin(auth.getName());
        m_a_v.addObject("powitanie", "Witaj " + uzytkownik.get_login());
        m_a_v.addObject("ankiety", serwis_ankiet.pokaz_po_uzytkowniku(uzytkownik.getId()));
        m_a_v.setViewName("Glowna");
        return m_a_v;
    }
}