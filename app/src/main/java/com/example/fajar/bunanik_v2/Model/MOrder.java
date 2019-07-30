package com.example.fajar.bunanik_v2.Model;

import java.io.Serializable;

/**
 * Created by romararr on 2/15/2018.
 */

public class MOrder implements Serializable {
    String nama;
    String telp;
    String jumlah_orang;
    String meja;

    public String getMeja() {
        return meja;
    }

    public void setMeja(String meja) {
        this.meja = meja;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

    public String getJumlah_orang() {
        return jumlah_orang;
    }

    public void setJumlah_orang(String jumlah_orang) {
        this.jumlah_orang = jumlah_orang;
    }
}
