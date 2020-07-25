package com.example.test_quay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class update_quay_hang extends AppCompatActivity {

    EditText edtTenQuay,edtLinkHinh;
    Button capNHap,huy;

    int id=0;
    String urlUpDate = "http://172.20.3.171:1234/orderfood/Person/update_quay_hang_amin.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_quay_hang);

        Intent intent=getIntent();
        class_quay_hang QuayHang = (class_quay_hang) intent.getSerializableExtra("dataQH");

        anhxa();

        id = QuayHang.getId();
        edtTenQuay.setText(QuayHang.getTen());
        edtLinkHinh.setText(QuayHang.getHinh());

        capNHap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edtTenQuay.getText().toString().trim();
                String image = edtLinkHinh.getText().toString().trim();

                if(name.isEmpty()||image.isEmpty()){
                    Toast.makeText(update_quay_hang.this, "Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
                }else {
                    CapNhapSinhVien(urlUpDate);
                }
            }
        });
        huy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void CapNhapSinhVien(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        if(response.equals("success")){
                            Toast.makeText(update_quay_hang.this, "Cập Nhập Thành Công", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(update_quay_hang.this,amin_login.class));
                        }else{
                            Toast.makeText(update_quay_hang.this, "Lỗi cập nhập", Toast.LENGTH_SHORT).show();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        Toast.makeText(update_quay_hang.this, "Lỗi hệ thống", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("idQH",String.valueOf(id));
                params.put("TenQH",edtTenQuay.getText().toString());
                params.put("LinkImage",edtLinkHinh.getText().toString());

                return params;
            }
        };
        requestQueue.add(stringRequest);
    }

    private  void anhxa(){
        edtTenQuay    = (EditText) findViewById(R.id.updateTen_amin);
        edtLinkHinh  = (EditText) findViewById(R.id.update_image_amin);
        capNHap     =  (Button) findViewById(R.id.updatecapnhap_amin);
        huy         = (Button) findViewById(R.id.updateXoa_amin);
    }
}