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

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
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

    public int getMoney(){
        int total = 0, size = getCount();
        for(int i = 0; i < size; i++) total += gio_hang.get(i).getTongTienmonan();
        return total;
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
        ImageView hinhmon,hinhNutXoa;
        ElegantNumberButton somondat;
        TextView tenmon,tongTienmonan;
        EditText ghichu;

    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {

        final ViewHoder hoder;
        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(Layout,null);
            hoder = new ViewHoder();
            //anh xa view
            hoder.tenmon = (TextView) view.findViewById(R.id.element_gio_hang_ten_mon);
            hoder.tongTienmonan = (TextView) view.findViewById(R.id.element_gio_hang_total_raise_mon);
            hoder.hinhmon = (ImageView) view.findViewById(R.id.element_gio_hang_hinh_mon);
            hoder.ghichu = (EditText) view.findViewById(R.id.element_gio_hang_ghi_chu);
            hoder.somondat = (ElegantNumberButton) view.findViewById(R.id.element_gio_hang_so_luong_dat);
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
        hoder.somondat.setNumber(food.getSomondat()+"");
        hoder.tongTienmonan.setText(String.valueOf(food.getTongTienmonan()) );
        Log.d("so mon",Integer.valueOf(hoder.somondat.getNumber()+"")+"");
        Log.d("gia mon",food.getTongTienmonan()+"");

        //gan cái animation---->gán hiệu ứng
        Animation animation = AnimationUtils.loadAnimation(context,R.anim.scale_list_hieu_ung);
        view.startAnimation(animation);



        hoder.hinhNutXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.DialogXoaMonAn(food.getTenmon(),food.getId());
            }
        });

        final int raise = Integer.parseInt(String.valueOf(hoder.tongTienmonan.getText())) / Integer.parseInt(String.valueOf(hoder.somondat.getNumber()));
        hoder.somondat.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                int newPrice = Integer.parseInt(hoder.somondat.getNumber()) * raise;
                gio_hang.get(i).setTongTienmonan(newPrice);
                gio_hang.get(i).setSomondat(Integer.parseInt(String.valueOf(hoder.somondat.getNumber())));
                hoder.tongTienmonan.setText(String.valueOf(newPrice  + ""));
                context.tongTien.setText(String.valueOf(getMoney()));
            }
        });
        return view;
    }
}

