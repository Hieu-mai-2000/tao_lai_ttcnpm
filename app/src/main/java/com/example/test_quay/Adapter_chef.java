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

import com.squareup.picasso.Picasso;

import java.util.List;

//public class Adapter_chef extends BaseAdapter {
//    private Context context;
//    private int layout;
//    private List<class_quay_hang> hinhanhList;
//
//    public Adapter_chef(Context context, int layout, List<class_quay_hang> hinhanhList) {
//        this.context = context;
//        this.layout = layout;
//        this.hinhanhList = hinhanhList;
//    }
//
//    @Override
//    public int getCount() {
//        return hinhanhList.size();
//    }
//
//    @Override
//    public Object getItem(int i) {
//        return null;
//    }
//
//    @Override
//    public long getItemId(int i) {
//        return 0;
//    }
//
//    private class ViewHoder{
//
//        TextView txtTenQuay;
//
//        //amin
//        ImageView xoa,them;
//    }
//
//    @Override
//    public View getView(int i, View view, ViewGroup viewGroup) {
//
//        ViewHoder hoder;
//
//        if(view == null){
//            hoder = new ViewHoder();
//            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
//            view = inflater.inflate(layout,null);
//            hoder.txtTenQuay =(TextView) view.findViewById(R.id.element_chef_name);
//            view.setTag(hoder);
//        }else {
//            hoder =(ViewHoder) view.getTag();
//        }
//
//        //class
//        class_quay_hang hinhanh = hinhanhList.get(i);
//
//        hoder.txtTenQuay.setText(hinhanh.getTen());
//
//        //gan cái animation---->gán hiệu ứng
//        Animation animation = AnimationUtils.loadAnimation(context,R.anim.scale_list_hieu_ung);
//        view.startAnimation(animation);
//
//        return view;
//    }
//}
//
//

public class Adapter_chef extends BaseAdapter {
    private Context context;
    private int Layout;
    private List<class_list_food> foodList;


    public Adapter_chef(Context context, int layout, List<class_list_food> foodList) {
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
        ImageView imgHinh;
        TextView number,finish;
        Button Hoan_thanh;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final ViewHoder hoder;

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(Layout,null);
            hoder = new ViewHoder();
            //anh xa view
            hoder.number = (TextView) view.findViewById(R.id.element_chef_number);
            hoder.finish = (TextView) view.findViewById(R.id.element_chef_finish);
            hoder.imgHinh = (ImageView) view.findViewById(R.id.element_chef_check);
            view.setTag(hoder);
        }else{
            hoder = (ViewHoder) view.getTag();
        }


        //gan gia tri
        class_list_food food = foodList.get(i);

        hoder.number.setText(food.getId()+"");
        //chưa làm phần xóa khi nhấn vào mục đã hoàn thành
        hoder.imgHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hoder.finish.setText("Đã Hoàn Thành");
            }
        });


        //gan cái animation---->gán hiệu ứng
        Animation animation = AnimationUtils.loadAnimation(context,R.anim.scale_list_hieu_ung);
        view.startAnimation(animation);
        return view;
    }
}

