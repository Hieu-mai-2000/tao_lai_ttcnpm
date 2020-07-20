package com.example.test_quay;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter_chi_tiet_history extends BaseAdapter {
        private Context context;
        private int Layout;
        private List<class_gio_hang> gio_hang;


        public Adapter_chi_tiet_history(Context context, int layout, List<class_gio_hang> gio_hang) {
            this.context = context;
            Layout = layout;
            this.gio_hang = gio_hang;
        }

        @Override
        public int getCount() {
            return gio_hang.size();
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
            ImageView hinhmon;
            TextView tenmon,tongTienmonan;
            TextView ghichu,somondat;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            final com.example.test_quay.Adapter_chi_tiet_history.ViewHoder hoder;
            if(view == null){
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                view = inflater.inflate(Layout,null);
                hoder = new com.example.test_quay.Adapter_chi_tiet_history.ViewHoder();
                //anh xa view
                hoder.tenmon = (TextView) view.findViewById(R.id.element_chi_tiet_history_name);
                hoder.tongTienmonan = (TextView) view.findViewById(R.id.element_chi_tiet_history_raise);
                hoder.hinhmon = (ImageView) view.findViewById(R.id.element_chi_tiet_history_image);
                hoder.ghichu = (TextView) view.findViewById(R.id.element_chi_tiet_history_note);
                hoder.somondat = (TextView) view.findViewById(R.id.element_chi_tiet_history_number);


                view.setTag(hoder);
            }else{
                hoder = (com.example.test_quay.Adapter_chi_tiet_history.ViewHoder) view.getTag();
            }

            //gan gia tri
            final class_gio_hang food = gio_hang.get(i);

            Picasso.get().load(food.getHinhmon()).into(hoder.hinhmon);
            hoder.tenmon.setText(food.getTenmon());
            hoder.ghichu.setText(food.getGhichu());
            hoder.somondat.setText(food.getSomondat()+"");
            hoder.tongTienmonan.setText(String.valueOf(food.getTongTienmonan()) );

            //gan cái animation---->gán hiệu ứng
            Animation animation = AnimationUtils.loadAnimation(context,R.anim.scale_list_hieu_ung);
            view.startAnimation(animation);


            return view;
        }
    }