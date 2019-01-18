package com.nbsp.domain;

import java.io.Serializable;

public class AccountUser  implements Serializable {

    private Integer id;
    private Float money;
    private User user;


    @Override
    public String toString() {
        return "AccountUser{" +
                "ID=" + id +
                ", money=" + money +
                ", user=" + user +
                '}';
    }

    public Integer getID() {
        return id;
    }

    public void setID(Integer ID) {
        this.id = ID;
    }

    public Float getMoney() {
        return money;
    }

    public void setMoney(Float money) {
        this.money = money;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
