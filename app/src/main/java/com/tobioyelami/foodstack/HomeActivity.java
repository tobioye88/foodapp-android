package com.tobioyelami.foodstack;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import com.tobioyelami.foodstack.R;
import com.tobioyelami.foodstack.tab.home.AvailableTab;
import com.tobioyelami.foodstack.tab.home.HistoryTab;
import com.tobioyelami.foodstack.tab.home.PagerAdapter;
import com.tobioyelami.foodstack.tab.home.SpecialTab;

public class HomeActivity extends AppCompatActivity implements SpecialTab.OnFragmentInteractionListener, AvailableTab.OnFragmentInteractionListener, HistoryTab.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TabLayout tabLayout = findViewById(R.id.tabLayout);

        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_one_name));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_two_name));
        tabLayout.addTab(tabLayout.newTab().setText(R.string.tab_three_name));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());

        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
    }
}
