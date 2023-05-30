package com.example.zhenya2;

public class Theme {
    private int id;
    private String name;
    private int startId;

    public Theme(int id, String name, int startId) {
        this.id = id;
        this.name = name;
        this.startId = startId;
    }
    public Theme( String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStartId() {
        return startId;
    }

    public void setStartId(int startId) {
        this.startId = startId;
    }

    @Override
    public String toString() {
        return name;
    }
}
