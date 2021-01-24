package com.niedz.ankiety.controller;

import com.niedz.ankiety.model.Uzytkownik;
import com.niedz.ankiety.service.SerwisUzytkownika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class logowanie {
    @Autowired
    private SerwisUzytkownika serwisUzytkownika;

    @GetMapping(path="/logowanie")
    public ModelAndView logowanieUzytkownika(){
        ModelAndView m_a_v = new ModelAndView();
        m_a_v.setViewName("logowanie");
        return m_a_v;
    }

    @GetMapping(path="/rejestracja")
    public ModelAndView rejestracja(){
        ModelAndView m_a_v = new ModelAndView();
        Uzytkownik uzytkownik = new Uzytkownik();
        m_a_v.addObject("uzytkownik", uzytkownik);
        m_a_v.setViewName("rejestracja");
        return m_a_v;
    }


    @PostMapping(path="/rejestracja")
    public ModelAndView dodajUzytkownika(@Valid Uzytkownik uzytkownik, BindingResult b_result){
        ModelAndView m_a_v = new ModelAndView();

        if(serwisUzytkownika.znajdzLogin(uzytkownik.getLogin()) != null)
            b_result.rejectValue("login", null, null);
        if(!b_result.hasErrors()){
            serwisUzytkownika.zapiszUzytkownika(uzytkownik);
            m_a_v.addObject("uzytkownik", new Uzytkownik());
        }
        m_a_v.setViewName("rejestracja");
        return m_a_v;
    }

    @GetMapping(path="/uzytkownik/main")
    public ModelAndView mainUsr(){
        ModelAndView m_a_v = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Uzytkownik uzytkownik = serwisUzytkownika.znajdzLogin(auth.getName());
        m_a_v.addObject("witaj", "Czesc " + uzytkownik.getLogin());
        m_a_v.setViewName("main");
        return m_a_v;
    }
}
