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

public class Adapter_gio_hang extends BaseAdapter {
    private gio_hang_activity context;
    private int Layout;
    private List<class_gio_hang> gio_hang; //= new ArrayList<>();


    public Adapter_gio_hang(gio_hang_activity context, int layout, List<class_gio_hang> gio_hang) {
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

    //1 khi kéo giao diện mỗi lần sẽ ánh xạ nên tốn bộ nhớ
    //việc tạo hoder sẽ giúp làm giảm những view đã được ánh xạ không phải ánh xạ lại lần nữa
    private  class ViewHoder{
        ImageView hinhmon,hinhNutTang,hinhNutGiam,hinhNutXoa;
        TextView tenmon,tongTienmonan;
        EditText ghichu,somondat;

    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        final ViewHoder hoder;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(Layout,null);
            hoder = new ViewHoder();
            //anh xa view
            hoder.tenmon = (TextView) view.findViewById(R.id.element_chi_tiet_history_name);
            hoder.tongTienmonan = (TextView) view.findViewById(R.id.element_chi_tiet_history_number);
            hoder.hinhNutTang = (ImageView) view.findViewById(R.id.element_gio_hang_image_tang);
            hoder.hinhNutGiam = (ImageView) view.findViewById(R.id.element_gio_hang_image_tru);
            hoder.hinhmon = (ImageView) view.findViewById(R.id.element_chi_tiet_history_image);
            hoder.ghichu = (EditText) view.findViewById(R.id.element_gio_hang_ghi_chu);
            hoder.somondat = (EditText) view.findViewById(R.id.element_gio_hang_so_luong_dat);
            hoder.hinhNutXoa = (ImageView) view.findViewById(R.id.element_gio_hang_image_xoa);


            view.setTag(hoder);
        }else{
            hoder = (ViewHoder) view.getTag();
        }


        //gan gia tri
        final class_gio_hang food = gio_hang.get(i);


        Picasso.get().load(food.getHinhmon()).into(hoder.hinhmon);
        hoder.tenmon.setText(food.getTenmon());
        hoder.ghichu.setText(food.getGhichu());
        hoder.somondat.setText(food.getSomondat()+"");
        hoder.tongTienmonan.setText(String.valueOf(food.getTongTienmonan()) );
        Log.d("so mon",Integer.valueOf(hoder.somondat.getText()+"")+"");
        Log.d("gia mon",food.getTongTienmonan()+"");
        //food.getTongTienmonan()

        //gan cái animation---->gán hiệu ứng
        Animation animation = AnimationUtils.loadAnimation(context,R.anim.scale_list_hieu_ung);
        view.startAnimation(animation);

        hoder.hinhNutXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.DialogXoaMonAn(food.getTenmon(),food.getId());
            }
        });

        hoder.hinhNutTang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hoder.somondat.setText(String.valueOf(Integer.valueOf(hoder.somondat.getText()+"")+1));
                hoder.tongTienmonan.setText(String.valueOf(food.getTongTienmonan()*Integer.valueOf(hoder.somondat.getText()+"")) );

            }
        });

        hoder.hinhNutGiam.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(Integer.valueOf(String.valueOf(hoder.somondat.getText()))>1)
                    hoder.somondat.setText(String.valueOf(Integer.valueOf(hoder.somondat.getText()+"")-1));
                hoder.tongTienmonan.setText(String.valueOf(food.getTongTienmonan()*Integer.valueOf(hoder.somondat.getText()+"")) );

            }
        });

        return view;
    }
}

