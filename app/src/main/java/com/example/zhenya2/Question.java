package com.example.zhenya2;

public class Question {
    private int id;
    private String text;
    private int themeId;
    private int points;

    public Question(int questionId, String text, int themeId, int points) {
        this.id = questionId;
        this.text = text;
        this.themeId = themeId;
        this.points = points;
    }
    public Question( String text, int themeId, int points) {
        this.text = text;
        this.themeId = themeId;
        this.points = points;
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

    public int getThemeId() {
        return themeId;
    }

    public void setThemeId(int themeId) {
        this.themeId = themeId;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    @Override
    public String toString() {
        return text;
    }
}
