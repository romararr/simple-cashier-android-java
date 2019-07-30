package com.example.fajar.bunanik_v2.Adapter.Waiting;

import android.content.Context;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fajar.bunanik_v2.Model.MPesanDetail;
import com.example.fajar.bunanik_v2.Model.MPesanan;
import com.example.fajar.bunanik_v2.Model.MWaiting;
import com.example.fajar.bunanik_v2.R;

import java.util.List;
import java.util.Objects;

/**
 * Created by Fajar on 26/11/2017.
 */

public class AdapterWaiting extends RecyclerView.Adapter<HolderWaiting> {

    private final Context context;
    LayoutInflater inflater;
    List<MPesanDetail.Result> data;

    public AdapterWaiting(Context context, List<MPesanDetail.Result> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public HolderWaiting onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_waiting, parent, false);

        HolderWaiting viewHolder = new HolderWaiting(v);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(final HolderWaiting holder, final int position) {

        holder.mNama.setText(data.get(position).getNama_menu());
        holder.mQty.setText("x "+data.get(position).getJumlah());
        holder.mHargaItem.setText(data.get(position).getHarga_menu());
        holder.mCatatan.setText(data.get(position).getCatatan());
        holder.mShowHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!holder.mCatatan.getText().toString().equals("")) {
                    if (holder.mCatatan.getVisibility() == View.VISIBLE) {
                        holder.mCatatan.setVisibility(View.GONE);
                    } else if (holder.mCatatan.getVisibility() == View.GONE) {
                        holder.mCatatan.setVisibility(View.VISIBLE);
                    }
                }else {
                    holder.mCatatan.setText("Tidak Ada Catatan");
                    if (holder.mCatatan.getVisibility() == View.VISIBLE) {
                        holder.mCatatan.setVisibility(View.GONE);
                    } else if (holder.mCatatan.getVisibility() == View.GONE) {
                        holder.mCatatan.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
        if(!holder.mCatatan.getText().toString().equals("")){
            holder.mCatatan.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public int getItemCount() {
        Log.d("size", String.valueOf(data.size()));
        return data.size();
    }
}
