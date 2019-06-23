package com.tobioyelami.foodstack;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tobioyelami.foodstack.models.Meal;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {
    private List<Meal> mealList;

    public RecyclerAdapter(List<Meal> mealList) {
        this.mealList = mealList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View cardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_card, parent, false);
        return new MyViewHolder(cardView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Meal meal = mealList.get(position);
        holder.foodName.setText(meal.getName());
        holder.foodCost.setText(String.valueOf(meal.getCost()));
        holder.foodDescription.setText(meal.getMain().getDescription());
    }

    @Override
    public int getItemCount() {
        return mealList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView foodName;
        TextView foodDescription;
        TextView foodCost;

        public MyViewHolder(View itemView) {
            super(itemView);
            foodName =  itemView.findViewById(R.id.foodName);
            foodCost =  itemView.findViewById(R.id.foodCost);
            foodDescription =  itemView.findViewById(R.id.foodDescription);
        }
    }
}
