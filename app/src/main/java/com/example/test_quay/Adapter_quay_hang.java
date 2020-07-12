package com.example.test_quay;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
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

import com.squareup.picasso.Picasso;

import java.util.List;

public class Adapter_quay_hang extends BaseAdapter {
    private Context context;
    private int layout;
    private List<class_quay_hang> hinhanhList;

    public Adapter_quay_hang(Context context, int layout, List<class_quay_hang> hinhanhList) {
        this.context = context;
        this.layout = layout;
        this.hinhanhList = hinhanhList;
    }

    @Override
    public int getCount() {
        return hinhanhList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHoder{
        ImageView imgHinh;

        TextView txtTenQuay,id;

        //amin
        ImageView xoa,them;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHoder hoder;

        if(view == null){
            hoder = new ViewHoder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout,null);
            hoder.imgHinh = (ImageView) view.findViewById(R.id.hinhanh);
           // hoder.id = (TextView) view.findViewById(R.id.textView3);
            hoder.txtTenQuay =(TextView) view.findViewById(R.id.ten_quay);
            hoder.xoa = (ImageView) view.findViewById(R.id.imageDelete_amin);
            hoder.them  = (ImageView) view.findViewById(R.id.imageGhi_chu_amin);
            view.setTag(hoder);
        }else {
            hoder =(ViewHoder) view.getTag();
        }

        //class
        class_quay_hang hinhanh = hinhanhList.get(i);

        Picasso.get().load(hinhanh.getHinh()).into(hoder.imgHinh);
        hoder.txtTenQuay.setText(hinhanh.getTen());

        //gan cái animation---->gán hiệu ứng
        Animation animation = AnimationUtils.loadAnimation(context,R.anim.scale_list_hieu_ung);
        view.startAnimation(animation);

        return view;
    }
}

