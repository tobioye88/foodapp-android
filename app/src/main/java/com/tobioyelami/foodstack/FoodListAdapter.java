package com.tobioyelami.foodstack;

import android.database.DataSetObserver;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.tobioyelami.foodstack.models.Meal;

import java.util.List;

public class FoodListAdapter implements ListAdapter {
    private List<Meal> mealList;

    public FoodListAdapter(List<Meal> mealList) {
        this.mealList = mealList;
    }

    @Override
    public boolean areAllItemsEnabled() {
        return false;
    }

    @Override
    public boolean isEnabled(int position) {
        return false;
    }

    @Override
    public void registerDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public void unregisterDataSetObserver(DataSetObserver observer) {

    }

    @Override
    public int getCount() {
        return mealList.size();
    }

    @Override
    public Object getItem(int position) {
        return mealList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = parent.findViewById(R.id.foodCard);
        TextView foodName = view.findViewById(R.id.foodName);
        TextView foodDescription = view.findViewById(R.id.foodDescription);
        TextView foodCost = view.findViewById(R.id.foodCost);

        Meal meal = mealList.get(position);

        foodName.setText(meal.getName());
        foodDescription.setText(meal.getName());
        foodCost.setText(String.format("###,###.##", meal.getCost()));

        return view;
    }

    @Override
    public int getItemViewType(int position) {
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }
}
