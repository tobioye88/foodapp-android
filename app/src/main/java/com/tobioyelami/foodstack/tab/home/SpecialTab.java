package com.tobioyelami.foodstack.tab.home;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tobioyelami.foodstack.R;
import com.tobioyelami.foodstack.RecyclerAdapter;
import com.tobioyelami.foodstack.SlideAdapter;
import com.tobioyelami.foodstack.models.Meal;
import com.tobioyelami.foodstack.service.MealService;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link SpecialTab.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link SpecialTab#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SpecialTab extends Fragment {
   private RecyclerView recyclerView;
   private RecyclerView.LayoutManager layoutManager;
   private MealService mealService = new MealService();
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public SpecialTab() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SpecialTab.
     */
    // TODO: Rename and change types and number of parameters
    public static SpecialTab newInstance(String param1, String param2) {
        SpecialTab fragment = new SpecialTab();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_one_tab, container, false);

        ViewPager viewPager = view.findViewById(R.id.viewPager);
        SlideAdapter slideAdapter = new SlideAdapter(getContext(), getFoodList());
        viewPager.setAdapter(slideAdapter);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setNestedScrollingEnabled(false);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(getAvailableMeals());
        recyclerView.setAdapter(recyclerAdapter);

//        ListView listView = view.findViewById(R.id.listView);
//        ListAdapter adapter = new FoodListAdapter();
//        listView.setAdapter(adapter);

        //listview
//        ListView foodListView = view.findViewById(R.id.foodListView);
//        List<Meal.Food> foodList1 = getFoodList();
//        int totalHeight = 0;
//        int desiredWidth = View.MeasureSpec.makeMeasureSpec(foodListView.getWidth(), View.MeasureSpec.AT_MOST);
//        FoodListViewAdapter foodListAdapter =  new FoodListViewAdapter(getContext(), R.layout.food_card, foodList1);
//        for (int i = 0; i < foodList1.size(); i++) {
//            View listItem = foodListAdapter.getView(i, null, foodListView);
//            listItem.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
//            totalHeight += listItem.getMeasuredHeight();
//        }
//        ViewGroup.LayoutParams params = foodListView.getLayoutParams();
//        params.height = totalHeight + (foodListView.getDividerHeight() * (foodListAdapter.getCount() - 1));
//        foodListView.setLayoutParams(params);
//        foodListView.requestLayout();
//        foodListView.setAdapter(foodListAdapter);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public List<Meal> getFoodList() {
        return mealService.getSpecialMeals();
    }

    public List<Meal> getAvailableMeals() {
        return mealService.getAvailableMeals();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
