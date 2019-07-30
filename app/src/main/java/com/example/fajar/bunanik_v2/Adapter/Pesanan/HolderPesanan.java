package com.example.fajar.bunanik_v2.Adapter.Pesanan;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fajar.bunanik_v2.R;


/**
 * Created by Fajar on 26/11/2017.
 */

public class HolderPesanan extends RecyclerView.ViewHolder {

    TextView mNama,mHarga,mQtyMin,mQtyCount,mQtyPlus;
    TextView mCatatan, mTemp;
    LinearLayout mLayoutQty;
    public HolderPesanan(View itemView) {
        super(itemView);

        mNama = (TextView) itemView.findViewById(R.id.nama_makanan);
        mHarga = (TextView) itemView.findViewById(R.id.harga_makanan);
        mCatatan = (TextView) itemView.findViewById(R.id.et_catatan);
        mTemp = (TextView) itemView.findViewById(R.id.temp_qty);
    }
}
