package com.example.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Appearance implements Serializable {
    @Id
    private String id;
    private String email;
    private String title;
    private String description;
    private String date;
    private boolean completed;

    @ManyToOne
    @JsonIgnore
    private SuperFrog assigned;

    public Appearance() {
    }

    public SuperFrog getAssigned() {
        return assigned;
    }

    public void setAssigned(SuperFrog assigned) {
        this.assigned = assigned;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }
}
