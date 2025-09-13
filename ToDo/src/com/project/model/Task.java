package com.project.model;

public class Task {
    private int id;
    private String title;
    private int week;
    private boolean isFinished;

    public Task(int id, String title, int week, boolean isFinished) {
        this.id = id;
        this.title = title;
        this.week = week;
        this.isFinished = isFinished;
    }

    public Task(String title, int week) {
        this.title = title;
        this.week = week;
        this.isFinished = false;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public int getWeek() { return week; }
    public boolean isFinished() { return isFinished; }
}
