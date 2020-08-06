package com.example.test_quay.Adapter;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test_quay.Interface.IItemClickListener;
import com.example.test_quay.R;

public class list_food_ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    IItemClickListener itemClickListener;

    ImageView hinhanhmon;
    TextView giamon,tenmon;

    public void setItemClickListener(IItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public list_food_ViewHolder(@NonNull View itemView) {
        super(itemView);
        tenmon = (TextView) itemView.findViewById(R.id.element_list_food_name);
        hinhanhmon = (ImageView) itemView.findViewById(R.id.element_list_food_image_food);
        giamon =(TextView)  itemView.findViewById(R.id.element_list_food_gia_tien);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        itemClickListener.onClick(view);
    }
}
