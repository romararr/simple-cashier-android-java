package com.example.fajar.bunanik_v2.Adapter.Makanan;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.fajar.bunanik_v2.APIClient;
import com.example.fajar.bunanik_v2.APIService;
import com.example.fajar.bunanik_v2.Interface.Constants;
import com.example.fajar.bunanik_v2.Model.MMenu;
import com.example.fajar.bunanik_v2.Model.MMenus;
import com.example.fajar.bunanik_v2.Model.MOrder;
import com.example.fajar.bunanik_v2.Model.MPesanan;
import com.example.fajar.bunanik_v2.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by romararr on 2/15/2018.
 */

public class AdapterMenu extends RecyclerView.Adapter<HolderMenu> implements Constants{

    Context context;
    public List<MMenus.Menus> data;
    public List<MOrder> order;
    public List<MMenu.Meja> mejas;
    LayoutInflater inflater;

    APIService apiService;

    public String status = "kosong";
    String option;

    public String kategori,nama_makanan,harga_makanan,qty_makanan, nama_customer, meja="";

    public AdapterMenu(Context context, List<MMenus.Menus> data, List<MOrder> orders) {
        this.context = context;
        this.data = data;
        this.order = orders;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public HolderMenu onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_menu, parent, false);

        HolderMenu viewHolder = new HolderMenu(v);
        return viewHolder;
    }

    public String COUNT;

    @Override
    public void onBindViewHolder(final HolderMenu holder, final int position) {
        holder.mNama.setText(data.get(position).getNama());
        holder.mHarga.setText(String.valueOf(data.get(position).getHarga()));
        Glide.with(context)
                .load(BASE_URL+data.get(position).getGambar())
                .into(holder.mImageMakanan);

        holder.getmBtnTambah().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.mLayoutQty.setVisibility(View.VISIBLE);
                holder.mBtnTambah.setVisibility(View.GONE);
                apiService = APIClient.getClient().create(APIService.class);

                COUNT = "1";
                holder.mQtyCount.setText(String.valueOf(Integer.valueOf(COUNT)));

                status = "ada";

                nama_makanan = data.get(position).getNama();
                nama_customer = order.get(0).getNama();
                meja = "1";

                Call<MPesanan> mCall = apiService.sendPesanan(meja, nama_customer, nama_makanan);
                mCall.enqueue(new Callback<MPesanan>() {
                    @Override
                    public void onResponse(Call<MPesanan> call, Response<MPesanan> response) {
                        try {

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<MPesanan> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });

        holder.mQtyPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                COUNT = holder.mQtyCount.getText().toString();
                holder.mQtyCount.setText(String.valueOf(Integer.valueOf(COUNT) + 1));

                nama_makanan = data.get(position).getNama();
                nama_customer = order.get(0).getNama();
                option = "tambah";

                Call<MPesanan> mCall = apiService.updateQty(nama_customer, nama_makanan, option);
                mCall.enqueue(new Callback<MPesanan>() {
                    @Override
                    public void onResponse(Call<MPesanan> call, Response<MPesanan> response) {
                        try {

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onFailure(Call<MPesanan> call, Throwable t) {
                        t.printStackTrace();
                    }
                });
            }
        });

        holder.mQtyMin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                COUNT = holder.mQtyCount.getText().toString();
                holder.mQtyCount.setText(String.valueOf(Integer.valueOf(COUNT) - 1));

                nama_makanan = data.get(position).getNama();
                nama_customer = order.get(0).getNama();

                if(COUNT.equals("1")){
                    Call<MPesanan> mCall = apiService.delPesanan(nama_customer, nama_makanan);
                    mCall.enqueue(new Callback<MPesanan>() {
                        @Override
                        public void onResponse(Call<MPesanan> call, Response<MPesanan> response) {
                            try {

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<MPesanan> call, Throwable t) {
                            t.printStackTrace();
                        }
                    });

                    holder.mLayoutQty.setVisibility(View.GONE);
                    holder.mBtnTambah.setVisibility(View.VISIBLE);

                }else {
                    Call<MPesanan> mCall = apiService.updateQty(nama_customer, nama_makanan, "kurang");
                    mCall.enqueue(new Callback<MPesanan>() {
                        @Override
                        public void onResponse(Call<MPesanan> call, Response<MPesanan> response) {
                            try {

                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<MPesanan> call, Throwable t) {
                            t.printStackTrace();
                        }
                    });
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
