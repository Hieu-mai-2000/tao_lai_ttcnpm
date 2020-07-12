package com.example.test_quay;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class gio_hang_activity extends AppCompatActivity {

    Button ThanhToan;
    ListView lvGioHang;
    ArrayList<class_gio_hang> array_gio_hang;
    Adapter_gio_hang adapter;
    Database database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang_activity);

        anhxa();
        GetDataGioHang();
        adapter.notifyDataSetChanged();


        ThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(gio_hang_activity.this, "thanh toán bằng gì,và xác nhận", Toast.LENGTH_SHORT).show();
                database.QueryData("DELETE  FROM gio_hang");
                adapter.notifyDataSetChanged();
                GetDataGioHang();
            }
        });
    }

    private  void GetDataGioHang(){
        //select data
        Cursor data_gio_hang = database.GetData("SELECT * FROM gio_hang");
        array_gio_hang.clear();
        while (data_gio_hang.moveToNext()){
            int id = data_gio_hang.getInt(0);
            String ten = data_gio_hang.getString(1);
            int gia = data_gio_hang.getInt(2);
            int soluongdat= data_gio_hang.getInt(3);
            String ghichu = data_gio_hang.getString(4);
            String hinh_anh = data_gio_hang.getString(5);
            array_gio_hang.add(new class_gio_hang(id,ten,gia*soluongdat,soluongdat,ghichu,hinh_anh));

        }

    }

    public void DialogXoaMonAn(final String monan, final int id){
        final AlertDialog.Builder dialogXoa = new AlertDialog.Builder(this);
        dialogXoa.setMessage("Bạn có muốn xóa món ăn\n'"+ monan + "'\nnày khong");
        dialogXoa.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                database.QueryData("DELETE  FROM gio_hang WHERE Id = '"+ id +"'");
                Toast.makeText(gio_hang_activity.this, "Đã Xóa:" + monan, Toast.LENGTH_SHORT).show();
                adapter.notifyDataSetChanged();
                GetDataGioHang();
            }
        });
        dialogXoa.setNegativeButton("không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        dialogXoa.show();
    }

    private void anhxa(){

        //tạo database
        database = new Database(this,"gio_hang.sqlite",null,1);
        database.QueryData("CREATE TABLE IF NOT EXISTS gio_hang(Id INTEGER PRIMARY KEY AUTOINCREMENT,TenFood VARCHAR(200),Gia INT,SoLuong INT,GhiChu TEXT, HinhanhFood TEXT)");
        lvGioHang = (ListView) findViewById(R.id.gio_hang_listview_ordered);
        array_gio_hang = new ArrayList<>();
        adapter = new Adapter_gio_hang(this,R.layout.element_gio_hang,array_gio_hang);
        lvGioHang.setAdapter(adapter);
        ThanhToan = (Button) findViewById(R.id.gio_hang_thanh_toan);
    }

}