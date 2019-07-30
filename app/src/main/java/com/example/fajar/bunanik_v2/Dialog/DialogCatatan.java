package com.example.fajar.bunanik_v2.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.fajar.bunanik_v2.APIService;
import com.example.fajar.bunanik_v2.Adapter.Pesanan.AdapterPesanDetail;
import com.example.fajar.bunanik_v2.Interface.OnCatatan;
import com.example.fajar.bunanik_v2.Model.MPesanan;
import com.example.fajar.bunanik_v2.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Fajar on 28/12/2017.
 */

public class DialogCatatan extends Dialog {
    Context context;
    TextView close,simpan;
    EditText catatan;
    OnCatatan onCatatan;

    public void setOnCatatan(OnCatatan onCatatan) {
        this.onCatatan = onCatatan;
    }
    public DialogCatatan(@NonNull final Context context) {
        super(context);
        this.context = context;
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_catatan);

        close = (TextView) findViewById(R.id.close);
        simpan = (TextView) findViewById(R.id.simpan);
        catatan = (EditText) findViewById(R.id.catatan);
        catatan.setHint("Coming Soon!");
        catatan.setEnabled(false);

        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                onCatatan.OnCatat(catatan.getText().toString());
                dismiss();
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        //Grab the window of the dialog, and change the width
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        Window window = getWindow();
        lp.copyFrom(window.getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        window.setAttributes(lp);
    }
}

