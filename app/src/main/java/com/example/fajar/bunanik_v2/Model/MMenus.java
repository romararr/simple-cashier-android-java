package com.example.fajar.bunanik_v2.Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by romararr on 2/15/2018.
 */

public class MMenus implements Serializable {
    List<Menus> result;

    public List<Menus> getResult() {
        return result;
    }

    public void setResult(List<Menus> result) {
        this.result = result;
    }

    public static class Menus implements Serializable{
        String id;
        String gambar;
        String nama;
        String harga;
        String nama_kategori;
        String id_kategori;
        String stok;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getGambar() {
            return gambar;
        }

        public void setGambar(String gambar) {
            this.gambar = gambar;
        }

        public String getNama() {
            return nama;
        }

        public void setNama(String nama) {
            this.nama = nama;
        }

        public String getHarga() {
            return harga;
        }

        public void setHarga(String harga) {
            this.harga = harga;
        }

        public String getNama_kategori() {
            return nama_kategori;
        }

        public void setNama_kategori(String nama_kategori) {
            this.nama_kategori = nama_kategori;
        }

        public String getId_kategori() {
            return id_kategori;
        }

        public void setId_kategori(String id_kategori) {
            this.id_kategori = id_kategori;
        }

        public String getStok() {
            return stok;
        }

        public void setStok(String stok) {
            this.stok = stok;
        }
    }
}
