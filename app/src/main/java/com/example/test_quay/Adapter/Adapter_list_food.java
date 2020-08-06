package com.example.test_quay.Adapter;

import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test_quay.Interface.IItemClickListener;
import com.example.test_quay.R;
import com.example.test_quay.chi_tiet_food_activity;
import com.example.test_quay.class_list_food;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Adapter_list_food extends RecyclerView.Adapter<list_food_ViewHolder> implements Filterable {
    private Context context;
    private int Layout;
    private List<class_list_food> foodList;
    private List<class_list_food> foodListAll;

    public Adapter_list_food(Context context, int Layout, List<class_list_food> foodList){
        this.context = context;
        this.Layout = Layout;
        this.foodList = foodList;
        this.foodListAll = new ArrayList<>();
    }

    public void setFoodListAll(List<class_list_food> foodListAll) {
        this.foodListAll = foodListAll;
    }

    public List<class_list_food> getFoodList() {
        return foodList;
    }

    @NonNull
    @Override
    public list_food_ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemView = layoutInflater.inflate(R.layout.element_list_food,parent,false);
        return new list_food_ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull list_food_ViewHolder holder, final int position) {
        class_list_food food = foodList.get(position);

        Picasso.get().load(food.getHinhanh()).into(holder.hinhanhmon);
        holder.tenmon.setText(food.getTenmon());
        holder.giamon.setText(food.getGia() + "");
        Animation animation = AnimationUtils.loadAnimation(context,R.anim.scale_list_hieu_ung);
        holder.itemView.startAnimation(animation);

        holder.setItemClickListener(new IItemClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, chi_tiet_food_activity.class);
                intent.putExtra("class", foodList.get(position));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    @Override
    public Filter getFilter() {
        return filter;
    }
    Filter filter = new Filter() {
        @Override

        protected FilterResults performFiltering(CharSequence charSequence) {
            List<class_list_food> filteredList = new ArrayList<>();
            if(charSequence.toString().isEmpty()){
                filteredList.addAll(foodListAll);
            } else{
              for(class_list_food food : foodListAll){
                  if(food.getTenmon().toLowerCase().contains(charSequence.toString().toLowerCase())) filteredList.add(food);
              }
            }
            FilterResults filterResults = new FilterResults();
            filterResults.values = filteredList;
            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence charSequence, FilterResults filterResults) {
            foodList.clear();
            foodList.addAll((Collection<? extends class_list_food>) filterResults.values);
            notifyDataSetChanged();
        }
    };
}