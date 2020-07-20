package com.example.test_quay;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

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

public class chi_tiet_history_activity extends AppCompatActivity {

    GridView GrListFood;
    ArrayList<class_gio_hang> arrayHistory;
    Adapter_chi_tiet_history adapter;

    String url = "http://172.20.3.26:1234/orderfood/detail_history_customer.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_history_activity);

        GrListFood = (GridView) findViewById(R.id.chi_tiet_history_girview);
        arrayHistory = new ArrayList<>();

        adapter = new Adapter_chi_tiet_history(this,R.layout.element_chi_tiet_history,arrayHistory);
        GrListFood.setAdapter(adapter);

        GetDataListFood(url);
    }

    private void GetDataListFood(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        arrayHistory.clear();
                        for(int i =0 ;i<response.length();i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                arrayHistory.add(new class_gio_hang(
                                        object.getString("image"),
                                        object.getString("nameFood"),
                                        object.getString("Note"),
                                        object.getInt("NumberOrder"),
                                        object.getInt("Raise")
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
                        Toast.makeText(chi_tiet_history_activity.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);

    }
}