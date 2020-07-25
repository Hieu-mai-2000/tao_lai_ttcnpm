package com.example.test_quay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class History_activity extends AppCompatActivity {
    GridView GrListFood;
    ArrayList<class_list_food> arrayHistory;
    Adapter_history adapter;
    String url = "http://172.20.3.171:1234/orderfood/History_customer.php";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_activity);

        GrListFood = (GridView) findViewById(R.id.History_GirdView);
        arrayHistory = new ArrayList<>();

        adapter = new Adapter_history(this,R.layout.element_history,arrayHistory);
        GrListFood.setAdapter(adapter);


        GrListFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(History_activity.this,chi_tiet_history_activity.class);
                startActivity(intent);
            }
        });

        GetDataTimeHistory(url);
    }

    private void GetDataTimeHistory(String url){

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        arrayHistory.clear();
                        for(int i =0 ;i<response.length();i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                arrayHistory.add(new class_list_food(
                                        object.getString("Time")
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
                        Toast.makeText(History_activity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                //"la ten minh viet chinh xac tren php" "cai chuoi nguoi dung nhap vao"
                params.put("email",sharedPreferences.getString("email", ""));
                return params;
            }
        };
        requestQueue.add(jsonArrayRequest);

    }

}