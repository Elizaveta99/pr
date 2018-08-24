package com.example.model;

import javax.persistence.*;

@Entity
@Table(name = "instructions")
public class Instruction {
    @Id
    @GeneratedValue
    private int id;

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String theme;

    @Column
    private String stepTitle;

    @Column
    private String stepText;

    public int getId() { return id; }
    public  void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public  void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public  void setDescription(String description) { this.description = description; }

    public String getTheme() { return theme; }
    public  void setTheme(String theme) { this.theme = theme; }

    public String getStepTitle() { return stepTitle; }
    public  void setStepTitle(String stepTitle) { this.stepTitle = stepTitle; }

    public String getStepText() { return stepText; }
    public  void setStepText(String stepText) { this.stepText = stepText; }
}
