package com.niedz.ankiety.bean;

public class AnswerFormItem {
    public Integer id;
    public String text;
    public Integer isChecked;
    public Integer questionId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getChecked() {
        return isChecked;
    }

    public Integer getIsChecked() {
        return isChecked;
    }

    public void setChecked(Integer checked) {
        isChecked = checked;
    }

    public void setIsChecked(Integer checked) {
        isChecked = checked;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public AnswerFormItem(Integer questionId, Integer answerId, String text) {
        this.questionId = questionId;
        this.text = text;
        this.isChecked = 0;
        this.id = answerId;
    }

    public AnswerFormItem() {

    }
}
