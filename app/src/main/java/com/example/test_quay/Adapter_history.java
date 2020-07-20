package com.example.test_quay;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class Adapter_history extends BaseAdapter {
        private Context context;
        private int Layout;
        private List<class_list_food> HistoryList;


        public Adapter_history(Context context, int layout, List<class_list_food> HistoryList) {
            this.context = context;
            Layout = layout;
            this.HistoryList = HistoryList;
        }

    @Override
        public int getCount() {
            return HistoryList.size();
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
            TextView Time;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {

            com.example.test_quay.Adapter_history.ViewHoder hoder;

            if(view == null){
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                view = inflater.inflate(Layout,null);
                hoder = new com.example.test_quay.Adapter_history.ViewHoder();
                //anh xa view
                hoder.Time = (TextView) view.findViewById(R.id.element_history_Time);

                view.setTag(hoder);
            }else{
                hoder = (com.example.test_quay.Adapter_history.ViewHoder) view.getTag();
            }


            //gan gia tri
            class_list_food food = HistoryList.get(i);

            hoder.Time.setText(food.getTime());

//        //gan cái animation---->gán hiệu ứng
            Animation animation = AnimationUtils.loadAnimation(context,R.anim.scale_list_hieu_ung);
            view.startAnimation(animation);
            return view;
        }
}
