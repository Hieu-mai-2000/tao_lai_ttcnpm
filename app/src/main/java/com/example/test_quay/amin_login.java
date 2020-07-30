package com.example.test_quay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
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

public class amin_login extends AppCompatActivity {

    ListView lvQuayHang;
    ArrayList<class_quay_hang> arrayQuayHang;
    Adapter_amin_quay_hang adapter;
    String IP_port = "http://192.168.1.7:8888/";
    String urlGetDataQuayHang= IP_port + "orderfood/quay_hang.php";
    String urlDelete= IP_port + "orderfood/Person/delete_quay_hang.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvQuayHang = (ListView) findViewById(R.id.gridview);
        arrayQuayHang = new ArrayList<>();
        adapter = new Adapter_amin_quay_hang(this,R.layout.activity_amin_login,arrayQuayHang);
        lvQuayHang.setAdapter(adapter);

        GetDataQuayHang(urlGetDataQuayHang);
    }

    private void GetDataQuayHang(String url){

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        arrayQuayHang.clear();
                        for(int i =0 ;i<response.length();i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                arrayQuayHang.add(new class_quay_hang(
                                        object.getInt("Id"),
                                        object.getString("hoten"),
                                        object.getString("hinhanh")
                                ));
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }

                        adapter.notifyDataSetChanged();

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(amin_login.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);

    }

    public void DeleteStudent(final int idQH){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, urlDelete
                , new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(response.trim().equals("success")){
                    Toast.makeText(amin_login.this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    GetDataQuayHang(urlGetDataQuayHang);
                }else {
                    Toast.makeText(amin_login.this, "Lỗi xóa", Toast.LENGTH_SHORT).show();
                }

            }

        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(amin_login.this, "Xảy ra lỗi", Toast.LENGTH_SHORT).show();

                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("idQH",String.valueOf(idQH));
                return params;
            }
        };
        requestQueue.add(stringRequest);

    }


}