package com.kemasrisman.model;


/*
        Nim  : 10116313
        Nama : Kemas Risman Fauzan
        Kelas: IF 7
        Waktu: 13/08/19
*/

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Login extends RealmObject {
    @PrimaryKey
    private int id;
    private String email;
    private String password;
    private Boolean loginStatus;

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public Boolean getLoginStatus() {
        return loginStatus;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLoginStatus(Boolean loginStatus) {
        this.loginStatus = loginStatus;
    }
}
