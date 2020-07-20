package com.example.test_quay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
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
import java.util.regex.Pattern;

public class register_activity extends AppCompatActivity {

    String urlInsert = "http://172.20.3.26:1234/orderfood/Person/customer.php";

    EditText textInputPassword,textInputEmail,textInputUsername;
    EditText nhap_lai_matkhau,number_phone;
    Button Dangky;


    //độ bảo mật của PassWord
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[0-9])" +         //at least 1 digit
                    "(?=.*[a-z])" +         //at least 1 lower case letter
                    "(?=.*[A-Z])" +         //at least 1 upper case letter
                    // "(?=.*[a-zA-Z])" +      //any letter
                    // "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);

        anhxa();



        Dangky.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*******lúc làm "làm biến nên không bật testPASSWORD nhớ là làm xong thì bật lại"***********************/
                //kiểm tra lại thông tin đăng nhập đã hợp lệ chưa
//            if(!validateEmail() | !validatePassword() | !validateAgainPassWord()
//                    | !validatePhone() | !validateUsername()){
//                Toast.makeText(second.this, "Đăng Ký Lỗi", Toast.LENGTH_SHORT).show();
//                return;
//            }
                /************************************************/

                ThemSinhVien(urlInsert);
                Intent intent = new Intent(register_activity.this,login_activity.class);
                intent.putExtra("Email",textInputEmail.getText().toString().trim());
                intent.putExtra("PassWord",textInputPassword.getText().toString().trim());

                startActivity(intent);

            }
        });




    }

    //test user_name
    private boolean validateUsername() {
        String usernameInput = textInputUsername.getText().toString().trim();
        if (usernameInput.isEmpty()) {
            textInputUsername.setError("Không để trống");
            return false;
        } else if (usernameInput.length() > 15) {
            textInputUsername.setError("Tên Đăng Nhập quá dài");
            return false;
        } else {
            textInputUsername.setError(null);
            return true;
        }
    }

    //test Email
    private boolean validateEmail() {
        String emailInput = textInputEmail.getText().toString().trim();
        if (emailInput.isEmpty()) {
            textInputEmail.setError("Không để trống");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            textInputEmail.setError("Email Lỗi!");
            return false;
        } else {
            textInputEmail.setError(null);
            return true;
        }
    }

    // test password
    private boolean validatePassword() {
        String passwordInput = textInputPassword.getText().toString().trim();
        if (passwordInput.isEmpty()) {
            textInputPassword.setError("Không để trống");
            return false;
        } else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            textInputPassword.setError("Mật Khẩu quá yếu");
            return false;
        } else {
            textInputPassword.setError(null);
            return true;
        }
    }
    //test Nhap_lai_pass_word
    private boolean validateAgainPassWord(){
        String AgainPassWord = nhap_lai_matkhau.getText().toString().trim();
        String passwordInput = textInputPassword.getText().toString().trim();
        if(AgainPassWord.equals(passwordInput)){
            return true;
        }else {
            nhap_lai_matkhau.setError("Nhap sai");
            return false;
        }
    }

    //test phone number
    private boolean validatePhone(){
        String numberPhone = number_phone.getText().toString().trim();
        if(numberPhone.isEmpty()){
            number_phone.setError("Không để trống");
            return false;
        }else if(numberPhone.length() != 10 ){
            number_phone.setError("Nhập 10 số");
            return false;
        }else {
            return  true;
        }
    }


    private  void anhxa(){
        Dangky = (Button) findViewById(R.id.Dang_ky_Dangky);
        textInputEmail =(EditText) findViewById(R.id.Dang_ky_email);
        textInputPassword =(EditText) findViewById(R.id.Dang_ky_matkhau);
        textInputUsername = (EditText) findViewById(R.id.Dang_ky_name);
        nhap_lai_matkhau =(EditText) findViewById(R.id.Dang_ky_nhap_lai_matkhau);
        number_phone = (EditText) findViewById(R.id.Dang_ky_number_phone);


    }


    private  void ThemSinhVien(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("success")){
                            Toast.makeText(register_activity.this, "Them thanh cong", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(register_activity.this,login_activity.class));
                        }else{
                            Toast.makeText(register_activity.this, "Loi them", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(register_activity.this, "xay ra loi qua trinh", Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                //"la ten minh viet chinh xac tren php" "cai chuoi nguoi dung nhap vao"
                params.put("name",textInputUsername.getText().toString().trim());
                params.put("email",textInputEmail.getText().toString().trim());
                params.put("password",textInputPassword.getText().toString().trim());
                params.put("numberphone",number_phone.getText().toString().trim());
                return params;
            }
        };
        requestQueue.add(stringRequest);

    }




}

