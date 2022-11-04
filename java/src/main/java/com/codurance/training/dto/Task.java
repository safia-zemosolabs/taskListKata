package com.codurance.training.dto;

public final class Task {
    private String id;
    private String projectName;
    private String description;
    private Boolean done;
    private String deadline;

    public Task(String id, String projectName, String description, boolean done){
        this.id = id;
        this.projectName = projectName;
        this.description = description;
        this.done = done;
    }
    public Task(String id, String projectName, String description, boolean done, String deadline) {
        this.id = id;
        this.projectName = projectName;
        this.description = description;
        this.done = done;
        this.deadline = deadline;
    }

    public String getId(){
        return id;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getDescription(){
        return description;
    }

    public Boolean getDone() {
        return done;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public boolean isDone() {
        return done;
    }
}
