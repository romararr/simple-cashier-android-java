package com.example.fajar.bunanik_v2.Model;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by Fajar on 26/11/2017.
 */

public class MPesanan implements Serializable {

    List<Pesanan> data;

    public List<Pesanan> getData() {
        return data;
    }

    public void setData(List<Pesanan> data) {
        this.data = data;
    }

    Pesanan pesanan;

    public Pesanan getPesanan() {
        return pesanan;
    }

    public void setPesanan(Pesanan pesanan) {
        this.pesanan = pesanan;
    }

    public static class Pesanan implements Serializable{

        String nama_makanan;
        String catatan;
        String harga_makanan;
        String qty;
        String sub_harga;

        public String getSub_harga() {
            return sub_harga;
        }

        public void setSub_harga(String sub_harga) {
            this.sub_harga = sub_harga;
        }

        public String getNama_makanan() {
            return nama_makanan;
        }

        public void setNama_makanan(String nama_makanan) {
            this.nama_makanan = nama_makanan;
        }

        public String getCatatan() {
            return catatan;
        }

        public void setCatatan(String catatan) {
            this.catatan = catatan;
        }

        public String getHarga_makanan() {
            return harga_makanan;
        }

        public void setHarga_makanan(String harga_makanan) {
            this.harga_makanan = harga_makanan;
        }

        public String getQty() {
            return qty;
        }

        public void setQty(String qty) {
            this.qty = qty;
        }
    }

}
