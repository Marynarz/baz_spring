package com.niedz.ankiety.controller;

import com.niedz.ankiety.bean.AnswerForm;
import com.niedz.ankiety.bean.AnswerFormItem;
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

    @GetMapping(path = "/ankieta/{id}/dodaj_pytanie")
    String addQuestionForm(@PathVariable("id") int id, Model model) {
        model.addAttribute("polling", serwisAnkiet.znajdzPoNumerze(id));
        Pytanie question = new Pytanie();
        question.setPolling(id);
        model.addAttribute("question", question);
        AnswerForm answerForm = new AnswerForm();
        for (int i = 0; i < 4; i++) {
            answerForm.addAnswer(new AnswerFormItem());
        }
        model.addAttribute("answerForm", answerForm);
        return "dodaj_pytanie";
    }

    @PostMapping(path = "/ankieta/dodaj_pytanie")
    String AddQuestionFormPost(@ModelAttribute Pytanie question, @ModelAttribute AnswerForm answerForm, Model model) {
        serwisPytan.dodajPytanie(question);
        System.out.println(question.getPytanko());

        answerForm.answers.forEach(answerFormItem -> {
            Odpowiedz answer = new Odpowiedz();
            answer.setIdPytania(question.getId());
            answer.setOdpowiedz(answerFormItem.text);
            answer.zerujIloscOdpowiedzi();
            answer.addOdpowiedz();
            serwisOdpowiedzi.odpowiedz(answer);
        });
        return "redirect:/";
    }
}
