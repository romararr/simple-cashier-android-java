package com.example.fajar.bunanik_v2.Model;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Fajar on 26/11/2017.
 */

public class MMenu implements Serializable {

    List<Meja> dataMeja;

    public List<Meja> getDataMeja() {
        return dataMeja;
    }

    public void setDataMeja(List<Meja> dataMeja) {
        this.dataMeja = dataMeja;
    }

    public static class Meja {
        String meja;

        public String getMeja() {
            return meja;
        }

        public void setMeja(String meja) {
            this.meja = meja;
        }
    }

    List<Menu> data;

    public List<Menu> getData() {
        return data;
    }

    public void setData(List<Menu> data) {
        this.data = data;
    }

    Menu menu;

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public static class Menu implements Serializable {

        String nama_makanan;
        String kategori;
        int image_makanan;
        int harga_makanan;
        int qty;

        public String getNama_makanan() {
            return nama_makanan;
        }

        public void setNama_makanan(String nama_makanan) {
            this.nama_makanan = nama_makanan;
        }

        public String getKategori() {
            return kategori;
        }

        public void setKategori(String kategori) {
            this.kategori = kategori;
        }

        public int getImage_makanan() {
            return image_makanan;
        }

        public void setImage_makanan(int image_makanan) {
            this.image_makanan = image_makanan;
        }

        public int getHarga_makanan() {
            return harga_makanan;
        }

        public void setHarga_makanan(int harga_makanan) {
            this.harga_makanan = harga_makanan;
        }

        public int getQty() {
            return qty;
        }

        public void setQty(int qty) {
            this.qty = qty;
        }
    }
}
