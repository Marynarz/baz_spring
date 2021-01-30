package com.niedz.ankiety.controller;

import com.niedz.ankiety.model.Ankietka;
import com.niedz.ankiety.model.Uzytkownik;
import com.niedz.ankiety.service.SerwisAnkiet;
import com.niedz.ankiety.service.SerwisOdpowiedzi;
import com.niedz.ankiety.service.SerwisPytan;
import com.niedz.ankiety.service.SerwisUzytkownika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

public class ankiety {
    @Autowired
    private SerwisAnkiet serwisAnkiet;

    @Autowired
    private SerwisOdpowiedzi serwisOdpowiedzi;

    @Autowired
    private SerwisPytan serwisPytan;

    @Autowired
    private SerwisUzytkownika serwisUzytkownika;

    // wysiwetlanie wszystkich ankiet
    @GetMapping(path="/ankiety/wszystkie")
    public ModelAndView wszystkieAnkiety()
    {
        ModelAndView m_a_v = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Uzytkownik usr = serwisUzytkownika.znajdzLogin(auth.getName());

        m_a_v.addObject("uzytkownicy", serwisUzytkownika.wszyscyUzytkownicy());
        m_a_v.addObject("ankiety_usytkownika", serwisAnkiet.pokazPoUzytkowniku(usr.getId()));
        m_a_v.addObject("ankiety", serwisAnkiet.pokazWszystkie());
        m_a_v.setViewName("wszystkie_ankiety");
        return m_a_v;
    }

    @GetMapping(path="/ankieta/nowa")
    public String nowaAnkietaGET(Model model)
    {
        model.addAttribute("ankieta", new Ankietka());
        return "nowa";
    }
    @PostMapping(path="/ankieta/nowa")
    public String nowaAnkietaPOST(@ModelAttribute Ankietka ankieta, Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Uzytkownik usr =serwisUzytkownika.znajdzLogin(auth.getName());
        ankieta.setTworca(usr.getId());
        serwisAnkiet.stworzAnkiete(ankieta);
        return "main";
    }

    @GetMapping(path="/ankieta/{id}")
    public String getAnkieta(@PathVariable("id") int id, Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Uzytkownik usr =serwisUzytkownika.znajdzLogin(auth.getName());
        return "";
    }
}
