package com.example.backend.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class SuperFrog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private Integer index;
    private String name;
    private String phone;
    private String mobile;
    private String email;
    private String company;
    private boolean isActive;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "assigned")
    @JsonIgnore
    private List<Appearance> appearances = new ArrayList<>();

    public SuperFrog() {
    }

    public List<Appearance> getAppearances() {
        return appearances;
    }

    public void setAppearances(List<Appearance> appearances) {
        this.appearances = appearances;
    }

    public Integer getId(){
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Integer getIndex() { return index; }

    public void setIndex(Integer index) { this.index = index;}

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void addAppearance(Appearance appearance){
        //set superFrog assigned to appearance
        appearance.setAssigned(this);
        //add appearance to wizard
        this.appearances.add(appearance);
    }
    public void removeAppearance(Appearance appearance) {
        //remove superFrog assignment to appearance
        appearance.setAssigned(null);
        //remove appearance from appearances
        this.appearances.remove(appearance);
    }

    public boolean isActive() { return isActive; }

    public void setActive(boolean active) { isActive = active; }

    public String getCompany() { return company; }

    public void setCompany(String company) { this.company = company; }
}
