package com.example.fajar.bunanik_v2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.fajar.bunanik_v2.Adapter.CustomSwipeAdapter;

/**
 * Created by Fajar on 16/12/2017.
 */

public class DenahActivity extends AppCompatActivity {
    ViewPager vp_slide_image;
    CustomSwipeAdapter adapter;
    ImageView mNavMenu,mSetProfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_denah);

        mNavMenu = (ImageView) findViewById(R.id.btn_drawer);
        mNavMenu.setImageResource(R.drawable.back_arrow_white);
        mNavMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        vp_slide_image = (ViewPager) findViewById(R.id.vp_slide_image);
        adapter = new CustomSwipeAdapter(this);
        vp_slide_image.setAdapter(adapter);
    }

}
