package com.example.fajar.bunanik_v2.Adapter.Pesanan;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


import com.example.fajar.bunanik_v2.Dialog.DialogCatatan;
import com.example.fajar.bunanik_v2.Interface.OnCatatan;
import com.example.fajar.bunanik_v2.Menu.MenuActivity;
import com.example.fajar.bunanik_v2.Model.MPesanan;
import com.example.fajar.bunanik_v2.R;

import java.util.List;
import java.util.Objects;

/**
 * Created by Fajar on 26/11/2017.
 */

public class AdapterPesanan extends RecyclerView.Adapter<HolderPesanan> {

    private final Context context;
    LayoutInflater inflater;
    public List<MPesanan.Pesanan> data;
    public String m1,m2,m3,m4,m5,m6,m7,m8,m9,m10;
    public String h1,h2,h3,h4,h5,h6,h7,h8,h9,h10;
    public String c1,c2,c3,c4,c5,c6,c7,c8,c9,c10;
    public String q1,q2,q3,q4,q5,q6,q7,q8,q9,q10;
    public int total_harga, sub_harga;

    public AdapterPesanan(Context context, List<MPesanan.Pesanan> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public HolderPesanan onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_pesanan, parent, false);

        HolderPesanan viewHolder = new HolderPesanan(v);
        return viewHolder;
    }

    public void addItem(List<MPesanan.Pesanan> item) {
        data.addAll(item);
        notifyDataSetChanged();
    }

    public String COUNT;

    @Override
    public void onBindViewHolder(final HolderPesanan holder, final int position) {

        holder.mNama.setText(data.get(position).getNama_makanan());
        holder.mHarga.setText(String.valueOf(data.get(position).getSub_harga()));
        holder.mTemp.setText(data.get(position).getQty());
        holder.mCatatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogCatatan catatan = new DialogCatatan(context);
                catatan.setOnCatatan(new OnCatatan() {
                    @Override
                    public void OnCatat(String Catatan) {
                        holder.mCatatan.setText(Catatan);

                        if(String.valueOf(position) == "0"){
                            c1 = holder.mCatatan.getText().toString();
                        }else if(String.valueOf(position) == "1"){
                            c2 = holder.mCatatan.getText().toString();
                        }else if(String.valueOf(position) == "2"){
                            c3 = holder.mCatatan.getText().toString();
                        }else if(String.valueOf(position) == "3"){
                            c4 = holder.mCatatan.getText().toString();
                        }else if(String.valueOf(position) == "4"){
                            c5 = holder.mCatatan.getText().toString();
                        }else if(String.valueOf(position) == "5"){
                            c6 = holder.mCatatan.getText().toString();
                        }else if(String.valueOf(position) == "6"){
                            c7 = holder.mCatatan.getText().toString();
                        }else if(String.valueOf(position) == "7"){
                            c8 = holder.mCatatan.getText().toString();
                        }else if(String.valueOf(position) == "8"){
                            c9 = holder.mCatatan.getText().toString();
                        }else if(String.valueOf(position) == "9"){
                            c10 = holder.mCatatan.getText().toString();
                        }

                    }
                });
                catatan.setCanceledOnTouchOutside(true);
                catatan.setCancelable(true);
                catatan.show();

            }
        });
        //setTotal
        if(String.valueOf(position) == "0"){
            m1 = holder.mNama.getText().toString();
            h1 = holder.mHarga.getText().toString();
            q1 = holder.mTemp.getText().toString();
        }else if(String.valueOf(position) == "1"){
            m2 = holder.mNama.getText().toString();
            h2 = holder.mHarga.getText().toString();
            q2 = holder.mTemp.getText().toString();
        }else if(String.valueOf(position) == "2"){
            m3 = holder.mNama.getText().toString();
            h3 = holder.mHarga.getText().toString();
            q3 = holder.mTemp.getText().toString();
        }else if(String.valueOf(position) == "3"){
            m4 = holder.mNama.getText().toString();
            h4 = holder.mHarga.getText().toString();
            q4 = holder.mTemp.getText().toString();
        }else if(String.valueOf(position) == "4"){
            m5 = holder.mNama.getText().toString();
            h5 = holder.mHarga.getText().toString();
            q5 = holder.mTemp.getText().toString();
        }else if(String.valueOf(position) == "5"){
            m6 = holder.mNama.getText().toString();
            h6 = holder.mHarga.getText().toString();
            q6 = holder.mTemp.getText().toString();
        }else if(String.valueOf(position) == "6"){
            m7 = holder.mNama.getText().toString();
            h7 = holder.mHarga.getText().toString();
            q7 = holder.mTemp.getText().toString();
        }else if(String.valueOf(position) == "7"){
            m8 = holder.mNama.getText().toString();
            h8 = holder.mHarga.getText().toString();
            q8 = holder.mTemp.getText().toString();
        }else if(String.valueOf(position) == "8"){
            m9 = holder.mNama.getText().toString();
            h9 = holder.mHarga.getText().toString();
            q9 = holder.mTemp.getText().toString();
        }else if(String.valueOf(position) == "9"){
            m10 = holder.mNama.getText().toString();
            h10 = holder.mHarga.getText().toString();
            q10 = holder.mTemp.getText().toString();
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
