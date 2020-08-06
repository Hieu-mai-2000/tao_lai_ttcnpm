package com.example.test_quay.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test_quay.Adapter.quay_hang_ViewHolder;
import com.example.test_quay.Interface.IItemClickListener;
import com.example.test_quay.MainActivity;
import com.example.test_quay.R;
import com.example.test_quay.class_quay_hang;
import com.example.test_quay.list_food;
import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter_quay_hang extends RecyclerView.Adapter<quay_hang_ViewHolder> {
    private Context context;
    private int layout;
    private List<class_quay_hang> hinhanhList;
    private List<String> url;

    public Adapter_quay_hang(Context context, int layout, List<class_quay_hang> hinhanhList, List<String> url) {
        this.context = context;
        this.layout = layout;
        this.hinhanhList = hinhanhList;
        this.url = url;
    }

    @NonNull
    @Override
    public quay_hang_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.element_quay_hang,parent,false);
        return new quay_hang_ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull quay_hang_ViewHolder holder, final int position) {
        class_quay_hang hinhanh = hinhanhList.get(position);
        Picasso.get().load(hinhanh.getHinh()).into(holder.imgHinh);
        holder.txtTenQuay.setText(hinhanh.getTen());
        Animation animation = AnimationUtils.loadAnimation(context,R.anim.scale_list_hieu_ung);
        holder.itemView.startAnimation(animation);

        holder.setItemClickListener(new IItemClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, list_food.class);
                intent.putExtra("urlGetDataListFood", url.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return hinhanhList.size();
    }

}
