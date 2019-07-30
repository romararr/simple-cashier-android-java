package com.example.fajar.bunanik_v2.Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by romararr on 2/17/2018.
 */

public class MPesanDetail implements Serializable {

    public int kode;
    public List<Hasil> hasil;
    public List<Result> result;

    public int getKode() {
        return kode;
    }

    public void setKode(int kode) {
        this.kode = kode;
    }

    public List<Hasil> getHasil() {
        return hasil;
    }

    public void setHasil(List<Hasil> hasil) {
        this.hasil = hasil;
    }

    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public class Hasil implements Serializable{
        String subtotal;
        String nama;
        String nomor_meja;
        String jml_org;

        public String getJml_org() {
            return jml_org;
        }

        public void setJml_org(String jml_org) {
            this.jml_org = jml_org;
        }

        public String getSubtotal() {
            return subtotal;
        }

        public void setSubtotal(String subtotal) {
            this.subtotal = subtotal;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getNomor_meja() {
            return nomor_meja;
        }

        public void setNomor_meja(String nomor_meja) {
            this.nomor_meja = nomor_meja;
        }
    }

    public class Result implements Serializable{
        String id_customer;
        String nama_menu;
        String harga_menu;
        String jumlah;
        String catatan;
        String status;

        public String getId_customer() {
            return id_customer;
        }

        public void setId_customer(String id_customer) {
            this.id_customer = id_customer;
        }

        public String getNama_menu() {
            return nama_menu;
        }

        public void setNama_menu(String nama_menu) {
            this.nama_menu = nama_menu;
        }

        public String getHarga_menu() {
            return harga_menu;
        }

        public void setHarga_menu(String harga_menu) {
            this.harga_menu = harga_menu;
        }

        public String getJumlah() {
            return jumlah;
        }

        public void setJumlah(String jumlah) {
            this.jumlah = jumlah;
        }

        public String getCatatan() {
            return catatan;
        }

        public void setCatatan(String catatan) {
            this.catatan = catatan;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }


}
