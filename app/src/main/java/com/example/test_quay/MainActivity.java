package com.example.test_quay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.test_quay.Adapter.Adapter_quay_hang;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //ListView lvQuayHang;
    ArrayList<class_quay_hang> arrayQuayHang;
    ArrayList<String> arrayURL;
    Adapter_quay_hang adapter;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    String IP_port = "http://192.168.1.7:8888/";
    String urlGetDataQuayHang= IP_port + "orderfood/quay_hang.php";
    String urlGetDataKFC= IP_port + "orderfood/list_food/KFC.php";
    String urlGetDataBBQ= IP_port + "orderfood/list_food/BBQ.php";
    //String urlGetDataBURGER_KING="http://172.20.6.225:1234/orderfood/list_food/BURGER_KING.php";
    //String urlGetDataJOLLIBEE="http://172.20.6.225:1234/orderfood/list_food/JOLLIBEE.php";
    //String urlGetDataMCDONAL="http://172.20.6.225:1234/orderfood/list_food/MCDONAL.php";
    String urlGetDataGongCha= IP_port + "orderfood/list_food/GongCha.php";
    String urlGetDataPIZZA_HUT= IP_port +"orderfood/list_food/PIZZA_HUT.php";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        arrayQuayHang = new ArrayList<>();
        arrayURL = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.gridview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),DividerItemDecoration.VERTICAL);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(),R.drawable.custom_divider);
        dividerItemDecoration.setDrawable(drawable);
        recyclerView.addItemDecoration(dividerItemDecoration);
        adapter = new Adapter_quay_hang(this,R.layout.element_quay_hang,arrayQuayHang,arrayURL);
        recyclerView.setAdapter(adapter);


        //GetListFood();// nhấn vào sẽ hiện ra danh sách món
        GetDataQuayHang(urlGetDataQuayHang);
    }

    private void GetDataQuayHang(String url){

        arrayURL.add(urlGetDataKFC); arrayURL.add(urlGetDataGongCha); arrayURL.add(urlGetDataPIZZA_HUT); arrayURL.add(urlGetDataBBQ);
        adapter.notifyDataSetChanged();

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
                        Toast.makeText(MainActivity.this, error.toString().trim(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);

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
            Intent intent = new Intent(MainActivity.this,gio_hang_activity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }



}