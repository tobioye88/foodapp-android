package com.tobioyelami.foodstack;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.tobioyelami.foodstack.models.Meal;

import java.util.List;

public class FoodListViewAdapter extends ArrayAdapter<Meal> {
    private Context mContext;
    private int resourceLayout;

    public FoodListViewAdapter(@NonNull Context context, int resource, List<Meal> mealList) {
        super(context, resource, mealList);
        mContext = context;
        this.resourceLayout = resource;
        this.mContext = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
//        return super.getView(position, convertView, parent);
        View v = convertView;

        if (v == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(mContext);
            v = vi.inflate(resourceLayout, null);
        }

        Meal meal = getItem(position);

        if (meal != null) {
            TextView foodName = (TextView) v.findViewById(R.id.foodName);
            TextView foodDescription = (TextView) v.findViewById(R.id.foodDescription);
            TextView foodCost = (TextView) v.findViewById(R.id.foodCost);

            if (foodName != null) {
                foodName.setText(meal.getName());
            }

            if (foodDescription != null) {
                foodDescription.setText(meal.getMain().getDescription());
            }

            if (foodCost != null) {
                foodCost.setText(String.valueOf(meal.getCost()));
            }
        }

        return v;
    }
}

