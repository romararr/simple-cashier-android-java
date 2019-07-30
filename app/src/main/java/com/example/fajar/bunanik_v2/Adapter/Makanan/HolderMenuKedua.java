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

public class HolderMenuKedua extends RecyclerView.ViewHolder {

    RecyclerView rv_menu;
    public HolderMenuKedua(View itemView) {
        super(itemView);

        rv_menu = (RecyclerView) itemView.findViewById(R.id.rv_menu);

    }

    public RecyclerView getRv_menu() {
        return rv_menu;
    }
}
