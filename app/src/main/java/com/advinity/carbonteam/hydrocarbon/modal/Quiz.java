package com.advinity.carbonteam.hydrocarbon.modal;

/**
 * Created by afdolash on 06/12/16.
 */

public class Quiz {
    private String label;
    private String question;
    private int answer;
    private int[] thumbnail;

    public Quiz(String label, String question, int answer, int[] thumbnail) {
        this.label = label;
        this.question = question;
        this.answer = answer;
        this.thumbnail = thumbnail;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getAnswer() {
        return answer;
    }

    public void setAnswer(int answer) {
        this.answer = answer;
    }

    public int[] getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int[] thumbnail) {
        this.thumbnail = thumbnail;
    }
}
