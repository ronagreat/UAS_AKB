package com.kemasrisman.model;


import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/*
        Nim  : 10116313
        Nama : Kemas Risman Fauzan
        Kelas: IF 7
        Waktu: 14/08/19
*/

public class Friend extends RealmObject {
    @PrimaryKey
    private int id;
    private String nama;
    private String nim;
    private String kelas;
    private String telepon;
    private String email;
    private String instagram;

    public Friend() {
    }

    public Friend(String nama, String telepon) {
        this.nama = nama;
        this.telepon = telepon;
    }

    public Friend(String nama, String nim, String kelas, String telepon, String email, String instagram) {
        this.nama = nama;
        this.nim = nim;
        this.kelas = kelas;
        this.telepon = telepon;
        this.email = email;
        this.instagram = instagram;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public String getKelas() {
        return kelas;
    }

    public String getTelepon() {
        return telepon;
    }

    public String getEmail() {
        return email;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void setKelas(String kelas) {
        this.kelas = kelas;
    }

    public void setTelepon(String telepon) {
        this.telepon = telepon;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

}
