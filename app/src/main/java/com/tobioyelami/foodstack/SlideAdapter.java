package com.tobioyelami.foodstack;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.tobioyelami.foodstack.models.Meal;

import java.util.List;

public class SlideAdapter extends PagerAdapter {
    private Context context;
    private LayoutInflater inflater;
    private List<Meal> mealList;

    public SlideAdapter(Context context, List<Meal> mealList) {
        this.context = context;
        this.mealList = mealList;
    }

    @Override
    public int getCount() {
        return mealList.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view == (ViewGroup) object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if(inflater == null ){
            return new View(context);
        }
        View view = inflater.inflate(R.layout.slide, container, false);
        ViewGroup layoutSlide = view.findViewById(R.id.slideLinearLayout);
        TextView title = view.findViewById(R.id.slideTitle);
        TextView description = view.findViewById(R.id.slideDescription);

        if(!mealList.isEmpty() && mealList.get(position) != null) {
            Meal meal = mealList.get(position);
//            layoutSlide.setBackgroundColor(Color.rgb(0,0,0));
            title.setText(meal.getName());
            description.setText(meal.getMain().getDescription());
        }
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((ViewGroup) object);
    }
}
