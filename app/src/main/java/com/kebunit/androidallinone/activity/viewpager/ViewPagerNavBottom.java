package com.kebunit.androidallinone.activity.viewpager;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.kebunit.androidallinone.R;
import com.kebunit.androidallinone.activity.basiclayout.BasicLayoutFragment;
import com.kebunit.androidallinone.activity.gridview.GridViewFragment;
import com.kebunit.androidallinone.activity.listview.ListViewFragment;
import com.kebunit.androidallinone.helper.CustomPagerAdapter;

public class ViewPagerNavBottom extends Fragment {

    private ViewPager viewPager;
    private BottomNavigationView navBottom;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.view_pager_nav_bottom, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setSubtitle("Navigation Bottom");
        viewPager = view.findViewById(R.id.view_pager);
        navBottom = view.findViewById(R.id.navigation);
        setupViewPager(viewPager);
        navBottom.setOnNavigationItemSelectedListener(navBottomListener);
        viewPager.addOnPageChangeListener(pageListener);
    }

    private void setupViewPager(ViewPager viewPager) {
        CustomPagerAdapter adapter = new CustomPagerAdapter(getChildFragmentManager());
        adapter.addFrag(new BasicLayoutFragment(), "Basic");
        adapter.addFrag(new GridViewFragment(), "Grid");
        adapter.addFrag(new ListViewFragment(), "List");
        viewPager.setOffscreenPageLimit(adapter.getCount());
        viewPager.setAdapter(adapter);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navBottomListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.basic_layout :
                    viewPager.setCurrentItem(0);
                    return true;
                case R.id.grid_view :
                    viewPager.setCurrentItem(1);
                    return true;
                case R.id.list_view :
                    viewPager.setCurrentItem(2);
                    return true;
                default: return false;
            }
        }
    };

    private ViewPager.OnPageChangeListener pageListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {
            navBottom.getMenu().getItem(i).setChecked(true);
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };
}
