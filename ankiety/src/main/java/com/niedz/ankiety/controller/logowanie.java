package com.niedz.ankiety.controller;

import com.niedz.ankiety.model.Uzytkownik;
import com.niedz.ankiety.service.SerwisUzytkownika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class logowanie {
    @Autowired
    private SerwisUzytkownika serwis_uzytkownika;

    @GetMapping(value="/logowanie")
    public ModelAndView logowanie_uzytkownika(){
        ModelAndView m_a_v = new ModelAndView();
        m_a_v.setViewName("login");
        return m_a_v;
    }

    @GetMapping(value="/rejestracja")
    public ModelAndView rejestracja(){
        ModelAndView m_a_v = new ModelAndView();
        Uzytkownik uzytkownik = new Uzytkownik();
        m_a_v.addObject("uzytkownik", uzytkownik);
        m_a_v.setViewName("rejestracja");
        return m_a_v;
    }


    @GetMapping(value="/rejestracja")
    public ModelAndView dodaj_uzytkownika(@Valid Uzytkownik uzytkownik, BindingResult b_result){
        ModelAndView m_a_v = new ModelAndView();

        if(serwis_uzytkownika.znajdzLogin(uzytkownik.get_login()) != null)
            b_result.rejectValue("username", null, null);
        if(!b_result.hasErrors()){
            serwis_uzytkownika.zapiszUzytkownika(uzytkownik);
            m_a_v.addObject("uzytkownik", new Uzytkownik());
        }
        m_a_v.setViewName("rejestracja");
        return m_a_v;
    }

    @GetMapping(value="/uzytkownik/main")
    public ModelAndView main_usr(){
        ModelAndView m_a_v = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Uzytkownik uzytkownik = serwis_uzytkownika.znajdzLogin(auth.getName());
        m_a_v.addObject("witaj", "Czesc " + uzytkownik.get_login());
        m_a_v.setViewName("main_usr");
        return m_a_v;
    }
}
