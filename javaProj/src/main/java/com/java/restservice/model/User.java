package com.java.restservice.model;

import javax.persistence.*;

@Entity
public class User {

    @Id
    private String username;
    private String password;
    private String name;
    private String email;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "savings_id", referencedColumnName = "id")
    private Savings savings;

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", savings=" + savings +
                '}';
    }

    public Savings getSavings() {
        return savings;
    }

    public void setSavings(Savings savings) {
        this.savings = savings;
    }
}
