package com.example.fajar.bunanik_v2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fajar.bunanik_v2.Adapter.Waiting.AdapterWaiting;
import com.example.fajar.bunanik_v2.Dialog.DialogInformation;
import com.example.fajar.bunanik_v2.Interface.Constants;
import com.example.fajar.bunanik_v2.Menu.MenuActivity;
import com.example.fajar.bunanik_v2.Model.MPesanDetail;
import com.example.fajar.bunanik_v2.Model.MPesanan;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Fajar on 28/12/2017.
 */

public class WaitingActivity extends AppCompatActivity implements Constants {

    ImageView mInformation;
    RecyclerView rv_waiting;
    TextView tv_namaCustomer, tv_jumlahOrang, tv_nomorMeja, tv_totalBayar;
    AdapterWaiting adapterWaiting;

    public List<MPesanDetail.Result> pesanResult = new ArrayList<>();
    public List<MPesanDetail.Hasil> pesanHasil = new ArrayList<>();

    APIService apiService;

    String nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waiting);

        apiService = APIClient.getClient().create(APIService.class);

        DialogInformation addName = new DialogInformation(WaitingActivity.this);
        addName.setCanceledOnTouchOutside(true);
        addName.setCancelable(true);
        addName.show();

        tv_namaCustomer = (TextView) findViewById(R.id.nama_customer);
        tv_jumlahOrang = (TextView) findViewById(R.id.jumlah_orang);
        tv_nomorMeja = (TextView) findViewById(R.id.nomor_meja);
        tv_totalBayar = (TextView) findViewById(R.id.total_bayar);

        mInformation = (ImageView) findViewById(R.id.second_drawer);
        mInformation.setImageResource(R.drawable.ic_error_outline_white_36dp);
        mInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogInformation addName = new DialogInformation(WaitingActivity.this);
                addName.setCanceledOnTouchOutside(true);
                addName.setCancelable(true);
                addName.show();
            }
        });

        getWaitPesan();
    }

    void getWaitPesan(){
        nama = getIntent().getStringExtra(NAMA_USER);
        Call<MPesanDetail> mCall = apiService.getPesanan(nama);
        mCall.enqueue(new Callback<MPesanDetail>() {
            @Override
            public void onResponse(Call<MPesanDetail> call, Response<MPesanDetail> response) {
                try {
                    rv_waiting = (RecyclerView) findViewById(R.id.rv_waiting);
                    pesanResult = response.body().getResult();
                    adapterWaiting = new AdapterWaiting(WaitingActivity.this, pesanResult);
                    rv_waiting.setAdapter(adapterWaiting);
                    rv_waiting.setHasFixedSize(true);
                    rv_waiting.setLayoutManager(new LinearLayoutManager(WaitingActivity.this));

                    pesanHasil = response.body().getHasil();
                    tv_totalBayar.setText(pesanHasil.get(0).getSubtotal());
                    tv_namaCustomer.setText(nama);
                    tv_nomorMeja.setText(getIntent().getStringExtra(NO_MEJA));
                    tv_jumlahOrang.setText(pesanHasil.get(0).getJml_org());
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

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Toast.makeText(WaitingActivity.this, "Tidak dapat kembali ke pesan menu", Toast.LENGTH_SHORT).show();
    }
}
