package com.example.fajar.bunanik_v2.Adapter.Makanan;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fajar.bunanik_v2.R;


/**
 * Created by Fajar on 26/11/2017.
 */

public class HolderMenu extends RecyclerView.ViewHolder {

    TextView mNama,mHarga,mBtnTambah,mQtyMin,mQtyCount,mQtyPlus,mLihatDenah;
    ImageView mImageMakanan;
    LinearLayout mLayoutQty;
    ImageView mMeja1,mMeja2,mMeja3;
    public HolderMenu(View itemView) {
        super(itemView);

        mNama = (TextView) itemView.findViewById(R.id.nama_makanan);
        mHarga = (TextView) itemView.findViewById(R.id.harga_makanan);
        mLihatDenah = (TextView) itemView.findViewById(R.id.linkdenah);
        mImageMakanan = (ImageView) itemView.findViewById(R.id.image_makanan);
        mBtnTambah = (TextView) itemView.findViewById(R.id.btn_tambah);
        mQtyMin = (TextView) itemView.findViewById(R.id.qty_min);
        mQtyCount = (TextView) itemView.findViewById(R.id.qty_count);
        mQtyPlus = (TextView) itemView.findViewById(R.id.qty_plus);
        mLayoutQty = (LinearLayout) itemView.findViewById(R.id.qty_layout);
        mMeja1 = (ImageView) itemView.findViewById(R.id.meja1);
        mMeja2 = (ImageView) itemView.findViewById(R.id.meja2);
        mMeja3 = (ImageView) itemView.findViewById(R.id.meja3);
    }

    public TextView getmLihatDenah() {
        return mLihatDenah;
    }

    public ImageView getmMeja1() {
        return mMeja1;
    }

    public ImageView getmMeja2() {
        return mMeja2;
    }

    public ImageView getmMeja3() {
        return mMeja3;
    }

    public TextView getmNama() {
        return mNama;
    }

    public TextView getmHarga() {
        return mHarga;
    }

    public TextView getmBtnTambah() {
        return mBtnTambah;
    }

    public TextView getmQtyMin() {
        return mQtyMin;
    }

    public TextView getmQtyCount() {
        return mQtyCount;
    }

    public TextView getmQtyPlus() {
        return mQtyPlus;
    }

    public ImageView getmImageMakanan() {
        return mImageMakanan;
    }

    public LinearLayout getmLayoutQty() {
        return mLayoutQty;
    }
}
