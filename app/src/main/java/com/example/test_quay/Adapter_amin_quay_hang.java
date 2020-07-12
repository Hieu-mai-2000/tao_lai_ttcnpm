package com.example.test_quay;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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

public class Adapter_amin_quay_hang extends BaseAdapter {
    private amin_login context;
    private int layout;
    private List<class_quay_hang> hinhanhList;

    public Adapter_amin_quay_hang(amin_login context, int layout, List<class_quay_hang> hinhanhList) {
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
        final class_quay_hang class_QH = hinhanhList.get(i);

        Picasso.get().load(class_QH.getHinh()).into(hoder.imgHinh);
        hoder.txtTenQuay.setText(class_QH.getTen());

        //gan cái animation---->gán hiệu ứng
        Animation animation = AnimationUtils.loadAnimation(context,R.anim.scale_list_hieu_ung);
        view.startAnimation(animation);

        hoder.xoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                xacnhanxoa(class_QH.getTen(),class_QH.getId());
            }
        });

        hoder.them.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent_edit = new Intent(context,update_quay_hang.class);
                intent_edit.putExtra("dataQH",class_QH);
                context.startActivity(intent_edit);
            }
        });

        return view;
    }

    private  void xacnhanxoa(String ten, final int idQH){
        AlertDialog.Builder dialogXoa = new AlertDialog.Builder(context);
        dialogXoa.setMessage("Bạn có muốn xóa sinh viên "+ ten +"không?");
        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                context.DeleteStudent(idQH);
                //Toast.makeText(context, "da xoa", Toast.LENGTH_SHORT).show();
            }
        });
        dialogXoa.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        dialogXoa.show();
    }

}
