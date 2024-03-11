package com.example.javatechtask.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Setter
@Getter
@Document
public class Pojo {
    private int money;
    private String name;
    private Role role;

    public Pojo(int money, String name, Role role) {
        this.money = money;
        this.name = name;
        this.role = role;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public enum Role{
        LOW,
        MEDIUM,
        STANDART,
        HIGH;
    }

}
