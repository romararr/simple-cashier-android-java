package com.example.fajar.bunanik_v2;

import com.example.fajar.bunanik_v2.Model.MMenus;
import com.example.fajar.bunanik_v2.Model.MPesanDetail;
import com.example.fajar.bunanik_v2.Model.MPesanan;
import com.example.fajar.bunanik_v2.Model.MWaiting;

import java.util.Map;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.PartMap;

/**
 * Created by Fajar on 07/02/2018.
 */

public interface APIService {
    @POST("menu_tampil.php")
    Call<MMenus> getMenu();

    @FormUrlEncoded
    @POST("customer_tambah.php")
    Call<MPesanan> sendCustomer(@Field("nama") String nama, @Field("telp") String telp,
                                @Field("jml_orang") String jml_orang);

    @FormUrlEncoded
    @POST("customer_hapus.php")
    Call<MPesanan> delCustomer(@Field("nama") String nama, @Field("telp") String telp);

    @FormUrlEncoded
    @POST("add_update.php")
    Call<MPesanan> updatePesan(@Field("id_customer") String id_customer, @Field("id_menu") String id_menu,
                               @Field("jumlah") String jumlah, @Field("catatan") String catatan);
    @FormUrlEncoded
    @POST("customer_tampil_pesanan.php")
    Call<MPesanDetail> getPesanan(@Field("user") String user);

    @FormUrlEncoded
    @POST("pesanan_tambah.php")
    Call<MPesanan> sendPesanan(@Field("meja") String meja, @Field("nama_customer") String nama_customer,
                               @Field("menu") String menu);

    @FormUrlEncoded
    @POST("pesanan_hapus.php")
    Call<MPesanan> delPesanan(@Field("nama") String nama_customer, @Field("menu") String menu);

    @FormUrlEncoded
    @POST("pesanan_update_meja.php")
    Call<MPesanan> updateMeja(@Field("nama") String nama, @Field("meja") String meja);

    @FormUrlEncoded
    @POST("pesanan_update_catatan.php")
    Call<MPesanan> updateCatatan(@Field("id_pesanan") String id_pesanan, @Field("catatan") String catatan);

    @FormUrlEncoded
    @POST("pesanan_update_jumlah.php")
    Call<MPesanan> updateQty(@Field("customer") String customer, @Field("menu") String menu,
                             @Field("option") String option);
}
