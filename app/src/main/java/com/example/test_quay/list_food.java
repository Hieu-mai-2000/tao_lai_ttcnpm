package com.example.test_quay;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class list_food extends AppCompatActivity {

    ListView lvListFood;
    ArrayList<class_list_food> arrayListFood, List_foodsearch;
    Adapter_list_food adapter;
    MaterialSearchView searchView;
    int ArrLsBinding = 0; // chon ArrayList tuy vao 0 hoac 1 luc tiem kiem

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_food);

        //anhxa();
        arrayListFood = new ArrayList<>();
        searchView = (MaterialSearchView)findViewById(R.id.search_view);

        lvListFood = (ListView) findViewById(R.id.activity_list_food);
        adapter = new Adapter_list_food(this,R.layout.element_list_food,arrayListFood);
        lvListFood.setAdapter(adapter);

        searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }
            @Override
            public void onSearchViewClosed() {
                // tro ve man hinh ban dau sau khi tat khung search
                lvListFood = (ListView) findViewById(R.id.activity_list_food);
                adapter = new Adapter_list_food(list_food.this,R.layout.element_list_food,arrayListFood);
                lvListFood.setAdapter(adapter);
                ArrLsBinding = 0;
            }
        });

        searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                if(!newText.isEmpty()){
                    List_foodsearch = new ArrayList<class_list_food>();
                    for(class_list_food item : arrayListFood){
                        if(item.getTenmon().contains(newText)) List_foodsearch.add(item);
                    }
                    adapter = new Adapter_list_food(list_food.this,R.layout.element_list_food,List_foodsearch);
                    lvListFood.setAdapter(adapter);
                    ArrLsBinding = 1;
                }
                else{
                    // tra ve binh thuong neu khong tim thay
                    adapter = new Adapter_list_food(list_food.this,R.layout.element_list_food,arrayListFood);
                    lvListFood.setAdapter(adapter);
                    ArrLsBinding = 0;
                }
                return true;
            }
        });

        lvListFood.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(list_food.this,chi_tiet_food_activity.class);
                if(ArrLsBinding == 1) intent.putExtra("class", List_foodsearch.get(i));
                else intent.putExtra("class",arrayListFood.get(i));
                startActivity(intent);
            }
        });

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
                searchView.setMenuItem(item);
                break;
            case R.id.Love_menu_list_food:
                Toast.makeText(this, "chưa có làm", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}