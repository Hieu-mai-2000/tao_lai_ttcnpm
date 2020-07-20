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

import java.util.List;

public class Adapter_list_food extends BaseAdapter {
    private Context context;
    private int Layout;
    private List<class_list_food> foodList;


    public Adapter_list_food(Context context, int layout, List<class_list_food> foodList) {
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

    //1 khi kéo giao diện mỗi lần sẽ ánh xạ nên tốn bộ nhớ
    //việc tạo hoder sẽ giúp làm giảm những view đã được ánh xạ không phải ánh xạ lại lần nữa
    private  class ViewHoder{
//        private String hinhanh,tenmon;
//        private int gia,soluongmon;

        ImageView hinhanhmon;
        TextView giamon,tenmon,soluongmon;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHoder hoder;

        if(view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(Layout,null);
            hoder = new ViewHoder();
            //anh xa view
            hoder.tenmon = (TextView) view.findViewById(R.id.element_list_food_name);
            //hoder.txtMoTa = (TextView) view.findViewById(R.id.textView2);
            hoder.hinhanhmon = (ImageView) view.findViewById(R.id.element_list_food_image_food);
            hoder.giamon =(TextView) view.findViewById(R.id.element_list_food_gia_tien);
            hoder.soluongmon=(TextView) view.findViewById(R.id.element_list_food_number_food);

            view.setTag(hoder);
        }else{
            hoder = (ViewHoder) view.getTag();
        }


        //gan gia tri
        class_list_food food = foodList.get(i);

        Picasso.get().load(food.getHinhanh()).into(hoder.hinhanhmon);
        hoder.tenmon.setText(food.getTenmon());
        hoder.giamon.setText(food.getGia()+"");
        hoder.soluongmon.setText(food.getSoluong()+"");

//        //gan cái animation---->gán hiệu ứng
        Animation animation = AnimationUtils.loadAnimation(context,R.anim.scale_list_hieu_ung);
        view.startAnimation(animation);
        return view;
    }
}