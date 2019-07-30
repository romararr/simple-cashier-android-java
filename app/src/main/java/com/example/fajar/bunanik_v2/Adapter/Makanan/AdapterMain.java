package com.example.fajar.bunanik_v2.Adapter.Makanan;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fajar.bunanik_v2.APIClient;
import com.example.fajar.bunanik_v2.APIService;
import com.example.fajar.bunanik_v2.DenahActivity;

import com.example.fajar.bunanik_v2.Menu.MenuActivity;
import com.example.fajar.bunanik_v2.Model.MMenu;
import com.example.fajar.bunanik_v2.Model.MMenus;
import com.example.fajar.bunanik_v2.Model.MOrder;
import com.example.fajar.bunanik_v2.Model.ModelMenu;
import com.example.fajar.bunanik_v2.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Fajar on 17/12/2017.
 */

public class AdapterMain extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    LayoutInflater inflater;
    List<ModelMenu> data;
    List<MOrder> orders;
    MMenu.Meja meja;

    public AdapterMenu adapterMenu;
    APIService apiService;

    public String COUNT="";

    public String NamaMakanan,HargaMakanan,QtyMakanan;
    public String M1,M2,M3,M4,M5,M6,M7,M8,M9,M10;
    public String H1,H2,H3,H4,H5,H6,H7,H8,H9,H10;
    public String Q1,Q2,Q3,Q4,Q5,Q6,Q7,Q8,Q9,Q10;

//    public String stats = adapterMenu.status;

    public List<MMenus.Menus> listMenu = new ArrayList<>();

    public AdapterMain(Context context, List<ModelMenu> data){
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    public AdapterMain(Context context, List<ModelMenu> data, List<MOrder> orders) {
        this.context = context;
        this.data = data;
        this.orders = orders;
    }

    private final int ATAS = 1, BAWAH = 2;

    @Override
    public int getItemCount() {
        return this.data.size();
    }

    @Override
    public int getItemViewType(int position) {
        //More to come
        if (data.get(position).getType() != null) {
            if (data.get(position).getType().equals("1")) {
                return ATAS;
            } else if (data.get(position).getType().equals("2")) {
                return BAWAH;
            }
        }
        return -1;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        switch (viewType) {
            case BAWAH:
                View v = inflater.inflate(R.layout.menu_bawah, parent, false);
                viewHolder = new HolderMenuKedua(v);
                break;

            default:
                View v1 = inflater.inflate(R.layout.menu_atas, parent, false);
                viewHolder = new HolderMenu(v1);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()) {
            case BAWAH:
                HolderMenuKedua vh = (HolderMenuKedua) holder;
                configureViewHolder2(vh, position);
                break;
            default:
                HolderMenu vh1 = (HolderMenu) holder;
                configureViewHolder1(vh1, position);
                break;
        }
    }

    private void configureViewHolder1(final HolderMenu vh1, int position) {
        vh1.getmLihatDenah().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,DenahActivity.class);
                context.startActivity(i);
            }
        });
        vh1.getmMeja1().setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (Objects.equals(COUNT, "dua")) {
                    COUNT = "satu";
                    vh1.getmMeja1().setImageResource(R.drawable.meja1_check);
                    vh1.getmMeja2().setImageResource(R.drawable.meja2);
                }else if(Objects.equals(COUNT, "tiga")) {
                    COUNT = "satu";
                    vh1.getmMeja1().setImageResource(R.drawable.meja1_check);
                    vh1.getmMeja3().setImageResource(R.drawable.meja3);
                }else{
                    COUNT = "satu";
                    vh1.getmMeja1().setImageResource(R.drawable.meja1_check);
                }
            }
        });
        vh1.getmMeja2().setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (Objects.equals(COUNT, "satu")) {
                    COUNT = "dua";
                    vh1.getmMeja2().setImageResource(R.drawable.meja2_check);
                    vh1.getmMeja1().setImageResource(R.drawable.meja1);
                }else if(Objects.equals(COUNT, "tiga")) {
                    COUNT = "dua";
                    vh1.getmMeja2().setImageResource(R.drawable.meja2_check);
                    vh1.getmMeja3().setImageResource(R.drawable.meja3);
                }else{
                    COUNT = "dua";
                    vh1.getmMeja2().setImageResource(R.drawable.meja2_check);
                }
            }
        });
        vh1.getmMeja3().setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (Objects.equals(COUNT, "satu")) {
                    COUNT = "tiga";
                    vh1.getmMeja3().setImageResource(R.drawable.meja3_check);
                    vh1.getmMeja1().setImageResource(R.drawable.meja1);
                }else if(Objects.equals(COUNT, "dua")) {
                    COUNT = "tiga";
                    vh1.getmMeja3().setImageResource(R.drawable.meja3_check);
                    vh1.getmMeja2().setImageResource(R.drawable.meja2);
                }else{
                    COUNT = "tiga";
                    vh1.getmMeja3().setImageResource(R.drawable.meja3_check);
                }
            }
        });
    }

    private void configureViewHolder2(final HolderMenuKedua vh, int position) {
        apiService = APIClient.getClient().create(APIService.class);
        Call<MMenus> mCall = apiService.getMenu();
        mCall.enqueue(new Callback<MMenus>() {
            @Override
            public void onResponse(Call<MMenus> call, Response<MMenus> response) {
                try {
                    listMenu = response.body().getResult();
                    vh.getRv_menu().setLayoutManager(new LinearLayoutManager(context));
                    vh.getRv_menu().setHasFixedSize(true);
                    adapterMenu = new AdapterMenu(context, listMenu, orders);
                    vh.getRv_menu().setAdapter(adapterMenu);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<MMenus> call, Throwable t) {
                t.printStackTrace();
            }
        });
//        Log.d("as", no_meja);
    }
}
