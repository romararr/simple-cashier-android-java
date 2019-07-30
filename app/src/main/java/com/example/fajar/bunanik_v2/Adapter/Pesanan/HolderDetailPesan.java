package com.example.fajar.bunanik_v2.Adapter.Pesanan;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fajar.bunanik_v2.R;

/**
 * Created by romararr on 2/17/2018.
 */

public class HolderDetailPesan extends RecyclerView.ViewHolder{

    TextView mNama,mHarga,mQty;
    LinearLayout mCatatan;
    public HolderDetailPesan(View itemView) {
        super(itemView);

        mNama = (TextView) itemView.findViewById(R.id.nama_makanan);
        mQty = (TextView) itemView.findViewById(R.id.temp_qty);
        mHarga = (TextView) itemView.findViewById(R.id.harga_makanan);
//        mCatatan = (TextView) itemView.findViewById(R.id.et_catatan);
        mCatatan = (LinearLayout) itemView.findViewById(R.id.et_catatan);
    }

    public TextView getmNama() {
        return mNama;
    }

    public TextView getmHarga() {
        return mHarga;
    }

    public TextView getmQty() {
        return mQty;
    }

    public LinearLayout getmCatatan() {
        return mCatatan;
    }
}
