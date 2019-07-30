package com.example.fajar.bunanik_v2.Adapter.Pesanan;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.fajar.bunanik_v2.APIService;
import com.example.fajar.bunanik_v2.Dialog.DialogCatatan;
import com.example.fajar.bunanik_v2.Interface.OnCatatan;
import com.example.fajar.bunanik_v2.Menu.MenuActivity;
import com.example.fajar.bunanik_v2.Model.MPesanDetail;
import com.example.fajar.bunanik_v2.Model.MPesanan;
import com.example.fajar.bunanik_v2.R;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by romararr on 2/17/2018.
 */

public class AdapterPesanDetail extends RecyclerView.Adapter<HolderDetailPesan> {
    Context context;
    LayoutInflater inflater;
    List<MPesanDetail.Result> data;
    int subtotal;

    APIService apiService;

    public String c1="", c2="-", c3="-", c4="-", c5="-";

    public AdapterPesanDetail(Context context, List<MPesanDetail.Result> data) {
        this.context = context;
        this.data = data;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public HolderDetailPesan onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.item_pesanan, parent, false);

        HolderDetailPesan viewHolder = new HolderDetailPesan(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final HolderDetailPesan holder, final int position) {
        holder.mNama.setText(data.get(position).getNama_menu());
        subtotal = Integer.parseInt(data.get(position).getHarga_menu())*Integer.parseInt(data.get(position).getJumlah());
        holder.mHarga.setText("Rp. " + String.valueOf(subtotal));
//        holder.mQty.setText("x " + data.get(position).getJumlah());
        holder.mCatatan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                DialogCatatan catatan = new DialogCatatan(context);
//                catatan.setOnCatatan(new OnCatatan() {
//                    @Override
//                    public void OnCatat(String Catatan) {
////                        holder.mCatatan.setText(Catatan);
////
////                        if(c1.equals("")){
////                            c1 = Catatan;
////                            c2 = "";
////                        }else if (c2.equals("")){
////                            c2 = Catatan;
////                            c3 = "";
////                        }else if (c3.equals("")){
////                            c3 = Catatan;
////                            c4 = "";
////                        }else if (c4.equals("")){
////                            c4 = Catatan;
////                            c5 = "";
////                        }else {
////                            c5 = Catatan;
////                        }
//                    }
//                });
//                catatan.setCanceledOnTouchOutside(true);
//                catatan.setCancelable(true);
//                catatan.show();
                Toast.makeText(context, "COMING SOON!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
