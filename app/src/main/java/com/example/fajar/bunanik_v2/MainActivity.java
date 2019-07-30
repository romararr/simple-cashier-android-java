package com.example.fajar.bunanik_v2;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.fajar.bunanik_v2.Menu.MenuActivity;

public class MainActivity extends AppCompatActivity {
    private static int splashInterval = 1500;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);


        new Handler().postDelayed(new Runnable() {


            @Override
            public void run() {
                // TODO Auto-generated method stub

                Intent i = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(i);

                finish_();
            }

            private void finish_() {
                // TODO Auto-generated method stub
                finish();
            }
        }, splashInterval);

    };

}

