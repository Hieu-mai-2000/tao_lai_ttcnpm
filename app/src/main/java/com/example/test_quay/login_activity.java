package com.example.test_quay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class login_activity extends AppCompatActivity {
    Button Dangky,Login;
    EditText email,password;
    CheckBox cbRemember;
    String Email="" , PassWord="";//chuỗi dùng để lấy dữ liệu trả về từ "đăng ký"

    ArrayList<String> check_email = new ArrayList<String>();
    ArrayList<String> check_password = new ArrayList<String>();
    String IP_port = "http://192.168.1.7:8888/";
    String URL_LOGIN = IP_port +"orderfood/Person/loginCustomer.php";
    String urlInsert = IP_port + "orderfood/Person/checkInFor.php";


    SharedPreferences sharedPreferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);


        //dung de luu tru gia tri

        anhxa();

        //taọ vùng dữ liệu lưu giá trị
        sharedPreferences = getSharedPreferences("dataLogin", MODE_PRIVATE);

        //nếu có dữ liệu trả về từ "đăng ký"
        Intent intent_login = getIntent();
        Email = intent_login.getStringExtra("Email");
        PassWord = intent_login.getStringExtra("PassWord");

        //lấy giá trị sharePreferences
        //chuỗi 1 là tên mình đặt chuỗi 2 là rỗng vì có thể lúc đầu người dùng chưa nhập gi
        email.setText(sharedPreferences.getString("taikhoan", Email));
        password.setText(sharedPreferences.getString("matkhau", PassWord));
        cbRemember.setChecked(sharedPreferences.getBoolean("checked", false));


        //bấm vào nút đăng ký tài khoản
        Dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.remove("taikhoan");
                editor.remove("matkhau");
                editor.remove("checked");
                editor.commit();

                //hiện ra giao diện đăng ký tài khoản
                Intent intent = new Intent(login_activity.this, register_activity.class);
                startActivity(intent);

            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //login(URL_LOGIN);
                String username = email.getText().toString();
                String pass = password.getText().toString();
                login(URL_LOGIN,username,pass);

            }
        });



    }

        private void anhxa(){
            Dangky = (Button) findViewById(R.id.Main_register);
            Login = (Button) findViewById(R.id.Main_login);
            email = (EditText) findViewById(R.id.Main_Email);
            password = (EditText) findViewById(R.id.Main_Password);
            cbRemember = (CheckBox) findViewById(R.id.Main_checkBox);
        }


private void login(String url, final String username , final String pass) {
        StringRequest request = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.contains("1")){
                            Toast.makeText(login_activity.this,
                                    "Đăng Nhập Thành Công", Toast.LENGTH_SHORT).show();
                            /*dùng để kiểm tra khi thoát ra vẫn lưu giá trị*/
                            if (cbRemember.isChecked()) {
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("taikhoan", username);//lưu biến String vừa tạo ở trên
                                editor.putString("matkhau", pass);//lưu biến String vừa tạo ở trên
                                editor.putBoolean("checked", true);
                                editor.commit();
                            } else {
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.remove("taikhoan");
                                editor.remove("matkhau");
                                editor.remove("checked");
                                editor.commit();

                            }

                            //test thu amin
                            if(username.contains("amin@") && pass.contains("123")){
                                startActivity(new Intent(login_activity.this,amin_login.class));
                            }else{
                                //hiện ra giao diện quay_hang
                                Intent intent = new Intent(login_activity.this, MainActivity.class);
                                startActivity(intent);
                            }
                            //hiệu ứng chuyển cảnh qua lại
                            overridePendingTransition(R.anim.anim_enter, R.anim.anim_exit);
                            //overridePendingTransition(R.anim.chuyen_tu_phai_qua_trai_enter,R.anim.chuyen_tu_phai_qua_trai_exit);

                            /*kết thúc phần lưu giá trị*/

                        }else{
                            Toast.makeText(login_activity.this,
                                    "Đăng Nhập Thất Bại", Toast.LENGTH_SHORT).show();
                        }
                         }
                }
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(login_activity.this, "Lỗi Kết Nối", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<>();
                params.put("username",email.getText().toString());
                params.put("password",password.getText().toString());
                return params;
            }
        };
        Volley.newRequestQueue(this).add(request);
}


}