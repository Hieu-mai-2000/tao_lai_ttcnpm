package com.example.test_quay;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.cepheuen.elegantnumberbutton.view.ElegantNumberButton;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class chi_tiet_food_activity extends AppCompatActivity {

    CollapsingToolbarLayout toolbarLayout;

    ImageView image_monan;
    TextView tenmon,mota,gia,soluong;
    EditText ghichu; //,orderfoodED
    String link_hinh_anh_food;
    FloatingActionButton datHang;
    Database database;
    ElegantNumberButton soluong_dat;
    ArrayList<class_gio_hang> arrayGioHang = new ArrayList<class_gio_hang>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_food_activity);

        anhxa();
        dong_bo_du_lieu();

        Intent intent_list_food = getIntent();
        final class_list_food listFood = (class_list_food) intent_list_food.getSerializableExtra("class");
        datHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ten_mon = tenmon.getText().toString().trim();
                String ghi_chu= ghichu.getText().toString().trim();
                int  gia_tien = Integer.valueOf((String) gia.getText());
                int so_luong_dat = Integer.valueOf(String.valueOf(soluong_dat.getNumber()));
                database.QueryData("INSERT INTO gio_hang VALUES(null,'"+ten_mon+"','"+gia_tien+"','"+so_luong_dat+"','"+ghi_chu+"','"+link_hinh_anh_food+"')");

            }
        });

        soluong_dat.setOnClickListener(new ElegantNumberButton.OnClickListener() {
            @Override
            public void onClick(View view) {
                soluong.setText(listFood.getSoluong() - Integer.valueOf(String.valueOf(soluong_dat.getNumber())) + "");
            }
        });
    }

    private void anhxa(){

        // tạo database
        database = new Database(this,"gio_hang.sqlite",null,1);
        database.QueryData("CREATE TABLE IF NOT EXISTS gio_hang(Id INTEGER PRIMARY KEY AUTOINCREMENT,TenFood VARCHAR(200),Gia INT,SoLuong INT,GhiChu TEXT, HinhanhFood TEXT)");

        // arrayGioHang = new ArrayList<>();

        image_monan         =(ImageView) findViewById(R.id.activity_CHiTietFood_hinhanh_food);
        tenmon              =(TextView) findViewById(R.id.activity_CHiTietFood_ten_mon);
        mota                =(TextView) findViewById(R.id.activity_CHiTietFood_mo_ta);
        gia                 =(TextView) findViewById(R.id.activity_CHiTietFood_gia_tien);
        soluong             =(TextView) findViewById(R.id.activity_CHiTietFood_food_con_lai);
        ghichu              = (EditText) findViewById(R.id.activity_CHiTietFood_ghi_chu);
        datHang             = (FloatingActionButton) findViewById(R.id.activity_CHiTietFood_dat_hang);
        soluong_dat         = (ElegantNumberButton) findViewById(R.id.activity_CHiTietFood_number_order);

        toolbarLayout       = (CollapsingToolbarLayout) findViewById(R.id.collapsing);
        toolbarLayout.setCollapsedTitleTextAppearance(R.style.CollapsapedToolbar);
        toolbarLayout.setExpandedTitleTextAppearance(R.style.ExpandedAppear);
    }

    private void dong_bo_du_lieu(){
        Intent intent = getIntent();
        class_list_food listFood = (class_list_food) intent.getSerializableExtra("class");
        Picasso.get().load(listFood.getHinhanh()).into(image_monan);
        tenmon.setText(listFood.getTenmon());
        //mota.setText(); chua co them vo
        gia.setText(listFood.getGia()+"");
        soluong.setText(listFood.getSoluong()+"");
        link_hinh_anh_food = listFood.getHinhanh();

    }

    //hiển thị menu ở góc trên bên phải
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_quay_hang,menu);
        return super.onCreateOptionsMenu(menu);

    }
    //dùng để tác động được vào phần menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.gio_hang_list_food){
            Intent intent = new Intent(chi_tiet_food_activity.this,gio_hang_activity.class);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }

}
