package com.lookhed.nighthawk.auth.infrastructure.entity;

import com.lookhed.nighthawk.auth.domain.model.AccountModel;
import jakarta.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private int user_id;
    @Column
    private boolean available=true;

    public Account(){}

    public Account(String username, String password, int user_id, boolean available) {
        this.username = username;
        this.password = password;
        this.user_id = user_id;
        this.available = available;
    }

    public static Account fromDomainEntity(AccountModel accountModel) {
        Account accountEntity = new Account(accountModel.getUsername(), accountModel.getPassword(), accountModel.getUser_id(), true);
        accountEntity.setId(accountModel.getId());
        return accountEntity;
    }
    public AccountModel fromEntityDomain() {
        return new AccountModel(id, username, password, user_id);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
