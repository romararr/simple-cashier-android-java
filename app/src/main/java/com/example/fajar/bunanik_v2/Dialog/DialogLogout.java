package com.example.fajar.bunanik_v2.Dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.fajar.bunanik_v2.Interface.OnLogout;
import com.example.fajar.bunanik_v2.R;

/**
 * Created by Fajar on 28/12/2017.
 */

public class DialogLogout extends Dialog {
    Context context;
    TextView close, cancel;
    OnLogout onLogout;
    String sts = "YA";

    public void setOnLogout(OnLogout onLogout) {
        this.onLogout = onLogout;
    }

    public DialogLogout(@NonNull final Context context) {
        super(context);
        this.context = context;
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.popup_logout);

        close = (TextView) findViewById(R.id.btn_close);
        cancel = (TextView) findViewById(R.id.btn_batal);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();

                onLogout.OnClose(sts);
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

