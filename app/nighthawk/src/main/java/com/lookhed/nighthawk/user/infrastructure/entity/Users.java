package com.lookhed.nighthawk.user.infrastructure.entity;

import java.time.LocalDate;

import jakarta.persistence.*;

import com.lookhed.nighthawk.user.domain.model.UserModel;

@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String name;

    @Column
    private String lastname;

    @Column
    private short age;

    @Column
    private LocalDate birthdate;

    @Column
    private boolean available;

    public Users() {}
    public Users(String name, String lastname, short age, LocalDate birthdate, boolean available) {
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.birthdate = birthdate;
        this.available =  available;
    }

    public static Users fromDomainEntity(UserModel userModel) {
        Users userEntity = new Users(userModel.getName(), userModel.getLastname(), userModel.getAge(), userModel.getBirthdate(), true);
        userEntity.setId(userModel.getId());
        return userEntity;
    }
    public UserModel fromEntityDomain() {
        return new UserModel(id, name, lastname, age, birthdate);
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

    public boolean getAvailable(){ return available;}

    public void setAvailable(boolean available){ this.available = available; }
}
