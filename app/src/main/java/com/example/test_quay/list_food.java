package com.example.test_quay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SearchEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.test_quay.Adapter.Adapter_list_food;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class list_food extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<class_list_food> arrayListFood;
    Adapter_list_food adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_food);


        //anhxa();
        arrayListFood = new ArrayList<>();


        recyclerView = (RecyclerView) findViewById(R.id.activity_list_food);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);

        adapter = new Adapter_list_food(this,R.layout.element_list_food,arrayListFood);
        recyclerView.setAdapter(adapter);

        Intent intent = getIntent();
        String urlGetDataListFood = intent.getStringExtra("urlGetDataListFood");
        GetDataListFood(urlGetDataListFood);
    }

    private void GetDataListFood(String url){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        arrayListFood.clear();
                        for(int i =0 ;i<response.length();i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                arrayListFood.add(new class_list_food(
                                        object.getInt("Id"),
                                        object.getString("NameFood"),
                                        object.getInt("Raise"),
                                        object.getInt("Number"),
                                        object.getString("Image")
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
                        Toast.makeText(list_food.this, error.toString(), Toast.LENGTH_SHORT).show();
                    }
                }
        );
        requestQueue.add(jsonArrayRequest);
        adapter.setFoodListAll(adapter.getFoodList());
        adapter.notifyDataSetChanged();
    }

    //Dùng để tạo ra 1 cái menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list_food,menu);
        return super.onCreateOptionsMenu(menu);
    }


   // Dùng để tác động vào menu bên góc bên phải phía trên
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.gio_hang_list_food_menu_list_food:
                Intent intent = new Intent(list_food.this,gio_hang_activity.class);
                startActivity(intent);
                break;
            case R.id.Home_menu_list_food:
                intent = new Intent(list_food.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.menuShare_menu_list_food:
                Toast.makeText(this, "chưa có làm", Toast.LENGTH_SHORT).show();
                break;
            case R.id.personal_menu_list_food:
                Toast.makeText(this, "chưa có làm", Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuSearch_menu_list_food:
                SearchView searchView = (SearchView)item.getActionView();
                searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                    @Override
                    public boolean onQueryTextSubmit(String s) {
                        return false;
                    }

                    @Override
                    public boolean onQueryTextChange(String s) {
                        adapter.getFilter().filter(s);
                        return false;
                    }
                });
                break;
            case R.id.Love_menu_list_food:
                Toast.makeText(this, "chưa có làm", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}