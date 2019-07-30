package com.example.fajar.bunanik_v2.Model;

import java.io.Serializable;

/**
 * Created by Fajar on 30/12/2017.
 */

public class MWaiting implements Serializable {

    String Nama_Makanan;
    String Qty;
    String Harga_totalItem;
    String Catatan;

    public String getCatatan() {
        return Catatan;
    }

    public void setCatatan(String catatan) {
        Catatan = catatan;
    }

    public String getNama_Makanan() {
        return Nama_Makanan;
    }

    public void setNama_Makanan(String nama_Makanan) {
        Nama_Makanan = nama_Makanan;
    }

    public String getQty() {
        return Qty;
    }

    public void setQty(String qty) {
        Qty = qty;
    }

    public String getHarga_totalItem() {
        return Harga_totalItem;
    }

    public void setHarga_totalItem(String harga_totalItem) {
        Harga_totalItem = harga_totalItem;
    }

}
