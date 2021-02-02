package com.niedz.ankiety.controller;

import com.niedz.ankiety.bean.Pytania;
import com.niedz.ankiety.model.Ankietka;
import com.niedz.ankiety.model.Odpowiedz;
import com.niedz.ankiety.model.Pytanie;
import com.niedz.ankiety.model.Uzytkownik;
import com.niedz.ankiety.service.SerwisAnkiet;
import com.niedz.ankiety.service.SerwisOdpowiedzi;
import com.niedz.ankiety.service.SerwisPytan;
import com.niedz.ankiety.service.SerwisUzytkownika;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class ankietyServ {
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
        System.out.println(serwisUzytkownika.wszyscyUzytkownicy());

        m_a_v.addObject("uzytkownicy", serwisUzytkownika.wszyscyUzytkownicy());
        m_a_v.addObject("ankiety_usytkownika", serwisAnkiet.pokazPoUzytkowniku(usr.getId()));
        m_a_v.addObject("ankiety", serwisAnkiet.pokazWszystkie());
        m_a_v.setViewName("wszystkie_ankiety");
        return m_a_v;
    }

    @GetMapping(path="/ankieta/nowa")
    public ModelAndView nowaAnkietaGET()
    {
        ModelAndView m_a_v = new ModelAndView();
        m_a_v.addObject("ankietka", new Ankietka());
        m_a_v.setViewName("nowa");
        return m_a_v;
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
        model.addAttribute("ankiety", serwisAnkiet.pokazPoUzytkowniku(usr.getId()));
        model.addAttribute("ankieta", serwisAnkiet.znajdzPoNumerze(id).get());
        Iterable<Pytanie> questionList = serwisPytan.znajdzWszystkieZAnkiety(id);
        model.addAttribute("pytania", questionList);
        Pytania pytania = new Pytania();
        questionList.forEach(question -> {
            Iterable<Odpowiedz> answerIterable = serwisOdpowiedzi.znajdzWszystkiePoPytaniu(question.getId());
            answerIterable.forEach( answer -> {
                pytania.dodajOdpowiedz(new com.niedz.ankiety.bean.Pytanie(question.getId(), answer.getOdpowiedz(), answer.getId()));
            });
        });
        model.addAttribute("odpowiedzi", pytania);
        return "ankieta";
    }

    @GetMapping(value="/ankieta/statystyki/{id}")
    public String getStats(@PathVariable("id") int id, Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Uzytkownik usr =serwisUzytkownika.znajdzLogin(auth.getName());
        model.addAttribute("ankiety", serwisAnkiet.pokazPoUzytkowniku(usr.getId()));
        model.addAttribute("ankieta", serwisAnkiet.znajdzPoNumerze(id).get());
        Iterable<Pytanie> questionList = serwisPytan.znajdzWszystkieZAnkiety(id);
        model.addAttribute("pytania", questionList);
        Pytania pytania = new Pytania();
        List<Odpowiedz> listaOdpowiedzi = new ArrayList<>();
        questionList.forEach(question -> {
            Iterable<Odpowiedz> answerIterable = serwisOdpowiedzi.znajdzWszystkiePoPytaniu(question.getId());
            answerIterable.forEach( answer -> {
                listaOdpowiedzi.add(answer);
                pytania.dodajOdpowiedz(new com.niedz.ankiety.bean.Pytanie(question.getId(), answer.getOdpowiedz(), answer.getId()));
            });
        });
        model.addAttribute("odpowiedzi", pytania);
        model.addAttribute("listaOdpowiedzi", listaOdpowiedzi);
        return "statystyki";
    }

    @GetMapping(path="/ankieta/zapisz")
    public String zapiszAnkiete(@ModelAttribute Pytania pytania, Model model)
    {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        Uzytkownik usr =serwisUzytkownika.znajdzLogin(auth.getName());
        model.addAttribute("ankiety", serwisAnkiet.pokazPoUzytkowniku(usr.getId()));
        pytania.odpowiedzi.forEach( form -> {
            Optional<Odpowiedz> ans = serwisOdpowiedzi.znajdzPoId(form.getId());
            if(ans.isPresent() && form.getZaznaczone() != null)
            {
                ans.get().addOdpowiedz();
                serwisOdpowiedzi.odpowiedz(ans.get());
            }
        });
        return "zapisane";
    }
}
