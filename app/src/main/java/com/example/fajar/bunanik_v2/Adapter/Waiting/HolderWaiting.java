package com.example.fajar.bunanik_v2.Adapter.Waiting;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fajar.bunanik_v2.R;


/**
 * Created by Fajar on 26/11/2017.
 */

public class HolderWaiting extends RecyclerView.ViewHolder {

    TextView mNama,mHargaItem,mQty,mCatatan;
    LinearLayout mShowHide;
    public HolderWaiting(View itemView) {
        super(itemView);

        mNama = (TextView) itemView.findViewById(R.id.nama_makanan);
        mHargaItem = (TextView) itemView.findViewById(R.id.harga_makanan);
        mCatatan = (TextView) itemView.findViewById(R.id.et_catatan);
        mQty = (TextView) itemView.findViewById(R.id.quantity);
        mShowHide = (LinearLayout) itemView.findViewById(R.id.showHide);

    }
}
