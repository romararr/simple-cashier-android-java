package com.example.fajar.bunanik_v2.Menu;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fajar.bunanik_v2.APIClient;
import com.example.fajar.bunanik_v2.APIService;
import com.example.fajar.bunanik_v2.Adapter.Makanan.AdapterMain;
import com.example.fajar.bunanik_v2.Adapter.Makanan.AdapterMenu;
import com.example.fajar.bunanik_v2.Adapter.Pesanan.AdapterPesanDetail;
import com.example.fajar.bunanik_v2.Adapter.Pesanan.AdapterPesanan;
import com.example.fajar.bunanik_v2.Interface.Constants;
import com.example.fajar.bunanik_v2.Dialog.DialogLogout;
import com.example.fajar.bunanik_v2.Model.MMenus;
import com.example.fajar.bunanik_v2.Model.MOrder;
import com.example.fajar.bunanik_v2.Model.MPesanDetail;
import com.example.fajar.bunanik_v2.Model.MPesanan;
import com.example.fajar.bunanik_v2.Model.ModelMenu;
import com.example.fajar.bunanik_v2.Interface.OnLogout;
import com.example.fajar.bunanik_v2.R;
import com.example.fajar.bunanik_v2.WaitingActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Fajar on 16/12/2017.
 */

public class MenuActivity extends AppCompatActivity implements Constants {
    public List<MPesanan.Pesanan> ItemPesanan = new ArrayList<>();
    public List<MMenus.Menus> listMenu = new ArrayList<>();
    public List<MPesanDetail.Result> pesanResult = new ArrayList<>();
    public List<MPesanDetail.Hasil> pesanHasil = new ArrayList<>();
    public List<MOrder> mOrders = new ArrayList<>();

    String[] cat = new String[5];

    ScrollView mLayoutPesanan, mLayoutRegister;
    LinearLayout mlayoutMenu;
    RecyclerView recyclerview, recyclerview_pesanan;
    TextView mNext, mBack, mOrder, mTitle, lp_Nama, lp_jumlah, lp_meja, lp_total, lp_telp;
    ImageView tab1, tab2, tab3;
    EditText et_mNama, et_mTelp, et_mJml;
    String Nama, status_logout = "YA", status = "ada";
    public String ok;
    public AdapterPesanan adapter_pesanan;
    public AdapterMain adapter;
    private AdapterPesanDetail adapterPesanDetail;
    private AdapterMenu adapterMenu;

    int subtotal = 0;

    public String nama, harga, jumlah, meja, nama_customer, catatan, qty, telp;

    boolean isStart = true;
    boolean isNew = true;

    APIService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        apiService = APIClient.getClient().create(APIService.class);

        ImageView mDrawer = (ImageView) findViewById(R.id.btn_drawer);
        mNext = (TextView) findViewById(R.id.btn_next);
        mBack = (TextView) findViewById(R.id.btn_back);
        mOrder = (TextView) findViewById(R.id.btn_finish);
        mTitle = (TextView) findViewById(R.id.title_tab);
        lp_Nama = (TextView) findViewById(R.id.lp_atasNama);
        lp_jumlah = (TextView) findViewById(R.id.lp_jumlahOrang);
        lp_meja = (TextView) findViewById(R.id.lp_nmrMeja);
        lp_total = (TextView) findViewById(R.id.lp_hargaTotal);
        lp_telp = (TextView)findViewById(R.id.telepon);
        mLayoutPesanan = (ScrollView) findViewById(R.id.layout_pesanan);
        mlayoutMenu = (LinearLayout) findViewById(R.id.layout_menu);
        mLayoutRegister = (ScrollView) findViewById(R.id.layout_register);
        tab1 = (ImageView) findViewById(R.id.image1);
        tab2 = (ImageView) findViewById(R.id.image2);
        tab3 = (ImageView) findViewById(R.id.image3);
        et_mNama = (EditText) findViewById(R.id.namalengkap);
        et_mTelp = (EditText) findViewById(R.id.telepon);
        et_mJml = (EditText) findViewById(R.id.jmlOrang);

        mDrawer.setVisibility(View.INVISIBLE);

        menu();
//        pesanan();
        navigation();
    }

    //--- Pesanan ---//
    public void pesanan() {
//        itemPesanan();
        recyclerview_pesanan = (RecyclerView) findViewById(R.id.rv_pesanan);
        adapter_pesanan = new AdapterPesanan(this, ItemPesanan);
        recyclerview_pesanan.setAdapter(adapter_pesanan);
        recyclerview_pesanan.setHasFixedSize(true);
        recyclerview_pesanan.setLayoutManager(new LinearLayoutManager(this));
    }

    //--- Menu ---//
    public void menu() {
        recyclerview = (RecyclerView) findViewById(R.id.rv_menu_main);
        if(isStart){
            adapter = new AdapterMain(this, setData());
        }else {
            adapter = new AdapterMain(this, setData(), setProfilUser());
        }
        recyclerview.setAdapter(adapter);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
//        recyclerview.getLayoutManager().scrollToPosition(2);
    }

    //--- Profil ---//

    List<MOrder> setProfilUser() {
//        lp_Nama.setText(et_mNama.getText().toString());
//        lp_jumlah.setText(et_mJml.getText().toString());
        MOrder user = new MOrder();
        user.setNama(et_mNama.getText().toString());
        user.setTelp(et_mTelp.getText().toString());
        user.setJumlah_orang(et_mJml.getText().toString());
        mOrders.add(user);

        return mOrders;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void add_pesanan() {

//        adapter.setPesan();
//        Nama = adapter.NamaMakanan;
//        status = adapterMenu.status;
        if (status.equals("kosong")) {
            Toast.makeText(MenuActivity.this, "Pilih Makanan atau Miuman dulu", Toast.LENGTH_SHORT).show();
        } else {
            if (Objects.equals(adapter.COUNT, "satu")) {
                lp_meja.setText("1");
                cekMenu();
            } else if (Objects.equals(adapter.COUNT, "dua")) {
                lp_meja.setText("2");
                cekMenu();
            } else if (Objects.equals(adapter.COUNT, "tiga")) {
                lp_meja.setText("3");
                cekMenu();
            } else {
                Toast.makeText(MenuActivity.this, "Pilih Nomor Meja dulu", Toast.LENGTH_SHORT).show();
                recyclerview.scrollToPosition(0);
            }

        }
    }

    public void navigation() {
        mNext.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (mLayoutRegister.getVisibility() == View.VISIBLE) {
                    cekRegister();
                    isStart = false;
                    if(isNew){
                        sendCustomer();
                        isNew=false;
                    }
                    menu();
                    recyclerview.scrollToPosition(0);

                } else if (mlayoutMenu.getVisibility() == View.VISIBLE) {
                    add_pesanan();
//                    cekMenu();
                }
            }
        });
        mBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mLayoutPesanan.getVisibility() == View.VISIBLE) {
                    mlayoutMenu.setVisibility(View.VISIBLE);
                    mLayoutPesanan.setVisibility(View.GONE);
                    mTitle.setText("Menu");
                    mBack.setVisibility(View.VISIBLE);
                    mNext.setVisibility(View.VISIBLE);
                    mOrder.setVisibility(View.GONE);
                    tab1.setImageResource(R.drawable.tab_profil);
                    tab2.setImageResource(R.drawable.tab_market_on);
                    tab3.setImageResource(R.drawable.tab_pesanan_off);
                    subtotal = 0;
                    recyclerview.scrollToPosition(0);
//                    adapter.delPesan();
                    ItemPesanan.clear();

                } else if (mlayoutMenu.getVisibility() == View.VISIBLE) {
                    mlayoutMenu.setVisibility(View.GONE);
                    mLayoutRegister.setVisibility(View.VISIBLE);
                    mTitle.setText("Profil");
                    mBack.setVisibility(View.INVISIBLE);
                    tab1.setImageResource(R.drawable.tab_profil_on);
                    tab2.setImageResource(R.drawable.tab_market_off);
                    tab3.setImageResource(R.drawable.tab_pesanan_off);
                }
            }
        });

        mOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendOrder();
                Intent i = new Intent(MenuActivity.this, WaitingActivity.class)
                        .putExtra(NAMA_USER, lp_Nama.getText())
                        .putExtra(NO_MEJA, lp_meja.getText());
                startActivity(i);
//                sendPesanan();
                ok = "OKE";
            }
        });
    }

    void sendCustomer(){
        nama_customer = et_mNama.getText().toString();
        telp = et_mTelp.getText().toString();
        jumlah = et_mJml.getText().toString();

        Call<MPesanan> mCall = apiService.sendCustomer(nama_customer, telp, jumlah);
        mCall.enqueue(new Callback<MPesanan>() {
            @Override
            public void onResponse(Call<MPesanan> call, Response<MPesanan> response) {

            }

            @Override
            public void onFailure(Call<MPesanan> call, Throwable t) {

            }
        });
    }

    void sendOrder(){
        nama_customer = lp_Nama.getText().toString();
//        nama = ItemPesanan.get(0).getNama_makanan();
        meja = lp_meja.getText().toString();
//        qty = ItemPesanan.get(0).getQty();
//        harga = ItemPesanan.get(0).getHarga_makanan();
//        catatan = ItemPesanan.get(0).getCatatan();
//        for(int i=0; i<ItemPesanan.size(); i++){
//            nama[i] = ItemPesanan.get(i).getNama_makanan();
//            harga[i] = ItemPesanan.get(i).getHarga_makanan();
//            qty[i] = ItemPesanan.get(i).getQty();
//            catatan[i] = ItemPesanan.get(i).getCatatan();
//        }

        Call<MPesanan> mCall = apiService.updateMeja(nama_customer, meja);
        mCall.enqueue(new Callback<MPesanan>() {
            @Override
            public void onResponse(Call<MPesanan> call, Response<MPesanan> response) {

            }

            @Override
            public void onFailure(Call<MPesanan> call, Throwable t) {

            }
        });

        cat[0] = adapterPesanDetail.c1;
        cat[1] = adapterPesanDetail.c2;
        cat[2] = adapterPesanDetail.c3;
        cat[3] = adapterPesanDetail.c4;
        cat[4] = adapterPesanDetail.c5;
        String catt;

//        for (int i=0; i<ItemPesanan.size(); i++){
//            catt = cat[i];
//            Call<MPesanan> sendCatatan = apiService.updateCatatan(nama_customer, catt);
//            sendCatatan.enqueue(new Callback<MPesanan>() {
//                @Override
//                public void onResponse(Call<MPesanan> call, Response<MPesanan> response) {
//
//                }
//
//                @Override
//                public void onFailure(Call<MPesanan> call, Throwable t) {
//
//                }
//            });
//        }
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public void cekMenu() {

        mlayoutMenu.setVisibility(View.GONE);
        mLayoutPesanan.setVisibility(View.VISIBLE);
        mTitle.setText("Pesanan");
        mBack.setVisibility(View.VISIBLE);
        mNext.setVisibility(View.GONE);
        mOrder.setVisibility(View.VISIBLE);
        tab1.setImageResource(R.drawable.tab_profil);
        tab2.setImageResource(R.drawable.tab_market_off);
        tab3.setImageResource(R.drawable.tab_pesanan_on);
        getPesanan();
    }

    public void getPesanan(){
        nama_customer = et_mNama.getText().toString();
        Call<MPesanDetail> mCall = apiService.getPesanan(nama_customer);
        mCall.enqueue(new Callback<MPesanDetail>() {
            @Override
            public void onResponse(Call<MPesanDetail> call, Response<MPesanDetail> response) {
                try {
                    recyclerview_pesanan = (RecyclerView) findViewById(R.id.rv_pesanan);
                    pesanResult = response.body().getResult();
                    adapterPesanDetail = new AdapterPesanDetail(MenuActivity.this, pesanResult);
                    recyclerview_pesanan.setAdapter(adapterPesanDetail);
                    recyclerview_pesanan.setHasFixedSize(true);
                    recyclerview_pesanan.setLayoutManager(new LinearLayoutManager(MenuActivity.this));

                    pesanHasil = response.body().getHasil();
                    lp_Nama.setText(pesanHasil.get(0).getNama());
                    lp_jumlah.setText(pesanHasil.get(0).getJml_org());
                    lp_total.setText(pesanHasil.get(0).getSubtotal());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<MPesanDetail> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void cekRegister() {

        if (et_mNama.getText().toString().equals("")) {
            et_mNama.setError("Nama Lengkap tidak boleh kosong");
            et_mNama.requestFocus();
        } else if (et_mTelp.getText().toString().equals("")) {
            et_mTelp.setError("Nomor Telepon tidak boleh kosong");
            et_mTelp.requestFocus();
        } else if (et_mJml.getText().toString().equals("")) {
            et_mJml.setError("Banyak Kursi dipesan tidak boleh kosong");
            et_mJml.requestFocus();
        } else {
//            setProfilUser();

            mLayoutRegister.setVisibility(View.GONE);
            mlayoutMenu.setVisibility(View.VISIBLE);
            mTitle.setText("Menu");
            mBack.setVisibility(View.VISIBLE);
            tab1.setImageResource(R.drawable.tab_profil);
            tab2.setImageResource(R.drawable.tab_market_on);
            tab3.setImageResource(R.drawable.tab_pesanan_off);
            et_mNama.clearFocus();
            et_mJml.clearFocus();
            et_mTelp.clearFocus();

            recyclerview.scrollToPosition(0);
        }
    }

    //--- Mode ---//
    public List<ModelMenu> setData() {
        List<ModelMenu> data = new ArrayList<>();

        ModelMenu item = new ModelMenu();
        item.setType("1");
        data.add(item);

        ModelMenu item2 = new ModelMenu();
        item2.setType("2");
        data.add(item2);

        return data;
    }

    @Override
    public void onBackPressed() {

        DialogLogout logout = new DialogLogout(MenuActivity.this);
        logout.setOnLogout(new OnLogout() {
            @Override
            public void OnClose(String StatusKeluar) {
                if (status_logout == StatusKeluar) {
                    finish();
                }
            }
        });
        logout.setCanceledOnTouchOutside(true);
        logout.setCancelable(true);
        logout.show();
    }
}
