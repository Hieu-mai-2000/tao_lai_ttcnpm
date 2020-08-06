package com.example.test_quay.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test_quay.Interface.IItemClickListener;
import com.example.test_quay.R;

public class quay_hang_ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    ImageView imgHinh;
    TextView txtTenQuay,id;
    ImageView xoa,them;

    IItemClickListener itemClickListener;

    public void setItemClickListener(IItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public quay_hang_ViewHolder(@NonNull View itemView) {
        super(itemView);
        imgHinh = (ImageView) itemView.findViewById(R.id.hinhanh);
        // hoder.id = (TextView) view.findViewById(R.id.textView3);
        txtTenQuay =(TextView) itemView.findViewById(R.id.ten_quay);
        xoa = (ImageView) itemView.findViewById(R.id.imageDelete_amin);
        them  = (ImageView) itemView.findViewById(R.id.imageGhi_chu_amin);
        itemView.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view);
    }
}
