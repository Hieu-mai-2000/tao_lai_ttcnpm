package com.example.test_quay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class chi_tiet_food_chef_activity extends AppCompatActivity {

    GridView lvFood;
    ArrayList<class_list_food> arrayFood;
    Adapter_chi_tiet_food_chef adapter;
    Database database_chef;
    int Ma_food =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_food_chef_activity);

        anhxa();

        adapter = new Adapter_chi_tiet_food_chef(this,R.layout.element_chi_tiet_food_chef,arrayFood);
        lvFood.setAdapter(adapter);


        lvFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //Toast.makeText(chef_activity.this, "sdfsdfsd", Toast.LENGTH_SHORT).show();
            }
        });
        adapter.notifyDataSetChanged();

    }

    private void anhxa(){
        lvFood = (GridView) findViewById(R.id.chi_tiet_food_chef_grview);
        arrayFood = new ArrayList<>();
        Intent intent_chef = getIntent();
        Ma_food = intent_chef.getIntExtra("Ma_food",0);

        // tạo database
        database_chef = new Database(this,"chef.sqlite",null,1);
        database_chef.QueryData("CREATE TABLE IF NOT EXISTS chef(Id INTEGER PRIMARY KEY AUTOINCREMENT,Ma_Food INTEGER,TenFood VARCHAR(200),Gia INT,SoLuong INT,GhiChu TEXT, HinhanhFood TEXT)");
        //public class_list_food(int id, String tenmon, int gia, int soluong, String hinhanh) {
        GetDataGioHang();
    }

    private  void GetDataGioHang(){
        //select data
        Cursor data_chef = database_chef.GetData("SELECT * FROM chef");
        arrayFood.clear();
        while (data_chef.moveToNext()){
            int Ma_food_ = data_chef.getInt(1);
            String ten = data_chef.getString(2);
            int gia = data_chef.getInt(3);
            int soluongdat= data_chef.getInt(4);
            String ghichu = data_chef.getString(5);
            String hinh_anh = data_chef.getString(6);
            if(Ma_food == Ma_food_){
                arrayFood.add(new class_list_food(Ma_food,ten,gia*soluongdat,soluongdat,ghichu));
            }

        }
    }
}