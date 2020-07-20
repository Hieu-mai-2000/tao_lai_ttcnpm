package com.example.test_quay;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.ContextMenu;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class gio_hang_activity extends AppCompatActivity {

    Button ThanhToan;
    ListView lvGioHang;
    ArrayList<class_gio_hang> array_gio_hang;
    Adapter_gio_hang adapter;
    Database database;

    SharedPreferences sharedPreferences;

    String url = "http://172.20.3.26:1234/orderfood/test_history.php";
    String url_History = "http://172.20.3.26:1234/orderfood/History.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gio_hang_activity);

        anhxa();
        GetDataGioHang();
        adapter.notifyDataSetChanged();

        //taọ vùng dữ liệu lưu giá trị
        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);

        ThanhToan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Them_Ma_Food(url);
                //// Chưa giải quyết được vấn đề về đồng bộ thời gian của Ma_Food ///////////////
                    /******************************************/
                    Cursor data_gio_hang = database.GetData("SELECT * FROM gio_hang");
                    array_gio_hang.clear();
                    while (data_gio_hang.moveToNext()){
                        Them_Food_History(url_History,data_gio_hang.getString(5),data_gio_hang.getString(1)
                                ,data_gio_hang.getString(4),data_gio_hang.getInt(3),data_gio_hang.getInt(2));
                    }
                    /******************************************/
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


    private  void Them_Ma_Food(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("success")){
                            //Toast.makeText(gio_hang_activity.this, "Them thanh cong", Toast.LENGTH_SHORT).show();
                        }else{
                            //Toast.makeText(gio_hang_activity.this, "Loi them", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(gio_hang_activity.this, "xay ra loi qua trinh", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                // lấy dữ liệu từ vùng chia sẻ (trong Ram)
                String email = sharedPreferences.getString("email", "");
                params.put("email",email);
                return params;
            }
        };
        requestQueue.add(stringRequest);

    }

    private  void Them_Food_History(String url, final String image , final String nameFood ,
                                   final String note , final int numberOrder, final int Raise){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("success")){
                            Toast.makeText(gio_hang_activity.this, "Them thanh cong", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(gio_hang_activity.this, "Loi them", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(gio_hang_activity.this, "xay ra loi qua trinh", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                //"la ten minh viet chinh xac tren php" "cai chuoi nguoi dung nhap vao"
                params.put("email",sharedPreferences.getString("email", ""));
                params.put("image",image);
                params.put("nameFood",nameFood);
                params.put("note",note);
                params.put("numberOrder", String.valueOf(numberOrder));
                params.put("Raise", String.valueOf(Raise));

                return params;
            }
        };
        requestQueue.add(stringRequest);

    }



}