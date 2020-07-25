package com.example.test_quay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class Adapter_chi_tiet_food_chef extends BaseAdapter {
    private Context context;
    private int Layout;
    private List<class_list_food> foodList;


    public Adapter_chi_tiet_food_chef(Context context, int layout, List<class_list_food> foodList) {
        this.context = context;
        Layout = layout;
        this.foodList = foodList;
    }


    @Override
    public int getCount() {
        return foodList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private  class ViewHoder{
        TextView name , note, so_luong;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHoder hoder;

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(Layout,null);
            hoder = new ViewHoder();
            //anh xa view
            hoder.name = (TextView) view.findViewById(R.id.element_chi_tiet_food_chef_name);
            hoder.note = (TextView) view.findViewById(R.id.element_chi_tiet_food_chef_note);
            hoder.so_luong = ( TextView) view.findViewById(R.id.element_chi_tiet_chef_so_luong);

            view.setTag(hoder);
        }else{
            hoder = (ViewHoder) view.getTag();
        }


        //gan gia tri
        class_list_food food = foodList.get(i);

        hoder.name.setText(food.getTenmon());
        hoder.note.setText(food.getHinhanh());
        hoder.so_luong.setText(food.getSoluong()+"");

        //gan cái animation---->gán hiệu ứng
        Animation animation = AnimationUtils.loadAnimation(context,R.anim.scale_list_hieu_ung);
        view.startAnimation(animation);
        return view;
    }
}

