package com.lookhed.nighthawk.user.domain.model;

import java.time.LocalDate;

public class UserModel {
    private int id;
    private String name;
    private String lastname;
    private short age;
    private LocalDate birthdate;

    public UserModel(int id, String name, String lastname, short age, LocalDate birthdate) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.birthdate = birthdate;
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

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public short getAge() {
        return age;
    }

    public void setAge(short age) {
        this.age = age;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }
}
