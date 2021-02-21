package com.niedz.ankiety.bean;

import java.util.ArrayList;
import java.util.List;

public class AnswerForm {
    public List<AnswerFormItem> answers;

    public void addAnswer(AnswerFormItem answer) {
        this.answers.add(answer);
    }

    public void SetAnswers (List<AnswerFormItem> answers){
        this.answers = answers;
    }

    public List<AnswerFormItem> getAnswers () {
        return this.answers;
    }

    public AnswerForm() {
        this.answers = new ArrayList<>();
    }
}
