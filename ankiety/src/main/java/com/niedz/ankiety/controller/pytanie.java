package com.niedz.ankiety.controller;

import com.niedz.ankiety.bean.Pytania;
import com.niedz.ankiety.model.Odpowiedz;
import com.niedz.ankiety.model.Pytanie;
import com.niedz.ankiety.service.SerwisAnkiet;
import com.niedz.ankiety.service.SerwisOdpowiedzi;
import com.niedz.ankiety.service.SerwisPytan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class pytanie {
    @Autowired
    private SerwisPytan serwisPytan;

    @Autowired
    private SerwisAnkiet serwisAnkiet;

    @Autowired
    private SerwisOdpowiedzi serwisOdpowiedzi;

    @GetMapping(path = "/glosowanie/{id}/dodaj_pytanie")
    String addQuestionForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("polling", serwisAnkiet.znajdzPoNumerze(id));
        Pytanie question = new Pytanie();
        question.setId(id);
        model.addAttribute("question", question);
        Pytania answerForm = new Pytania();
        for (int i = 0; i < 4; i++) {
            answerForm.dodajOdpowiedz(new com.niedz.ankiety.bean.Pytanie());
        }
        model.addAttribute("answerForm", answerForm);
        return "/question/add";
    }

    @PostMapping(path = "/polling/add_question")
    String AddQuestionFormPost(@ModelAttribute Pytanie question, @ModelAttribute Pytania answerForm, Model model) {
        serwisPytan.dodajPytanie(question);

        answerForm.odpowiedzi.forEach(answerFormItem -> {
            Odpowiedz answer = new Odpowiedz();
            answer.setIdPytania(question.getId());
            answer.setOdpowiedz(answerFormItem.opis);
            answer.zerujIloscOdpowiedzi();
            answer.setIlosc_odpowiedzi(1);
            serwisOdpowiedzi.odpowiedz(answer);
        });
        return "/dashboard";
    }


}
