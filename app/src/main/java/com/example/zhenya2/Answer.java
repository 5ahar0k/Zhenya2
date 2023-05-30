package com.example.zhenya2;

public class Answer {
    private int id;
    private String text;
    private int questionId;
    private int nextQuestionId;

    public Answer(int id, String text, int questionId, int nextQuestionId) {
        this.id = id;
        this.text = text;
        this.questionId = questionId;
        this.nextQuestionId = nextQuestionId;
    }
    public Answer( String text, int questionId, int nextQuestionId) {
        this.text = text;
        this.questionId = questionId;
        this.nextQuestionId = nextQuestionId;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getNextQuestionId() {
        return nextQuestionId;
    }

    public void setNextQuestionId(int nextQuestionId) {
        this.nextQuestionId = nextQuestionId;
    }

    @Override
    public String toString() {
        return text;
    }
}
