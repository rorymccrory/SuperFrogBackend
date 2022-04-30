package com.example.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
public class Appearance implements Serializable {
    @Id
    private String id;
    private Integer index;
    private String email;
    private String title;
    private String description;
    private String date;
    private boolean completed;
    private boolean isApproved;
    private LocalDate createTime;

    @ManyToOne
    @JsonIgnore
    private SuperFrog assigned;

    public Appearance() {
    }

    public Appearance(String id, Integer index, String email, String title, String description, String date, boolean completed, boolean isApproved, LocalDate createTime, SuperFrog assigned) {
        this.id = id;
        this.index = index;
        this.email = email;
        this.title = title;
        this.description = description;
        this.date = date;
        this.completed = completed;
        this.isApproved = isApproved;
        this.createTime = createTime;
        this.assigned = assigned;
    }



    public SuperFrog getAssigned() {
        return assigned;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
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

    public boolean isApproved() { return isApproved;}

    public void setApproved(boolean approved) { this.isApproved = approved; }

    public LocalDate getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDate createTime) {
        this.createTime = createTime;
    }
}
