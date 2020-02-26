package com.kebunit.androidallinone.activity.viewpager;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kebunit.androidallinone.R;
import com.kebunit.androidallinone.activity.basiclayout.BasicLayoutFragment;
import com.kebunit.androidallinone.activity.gridview.GridViewFragment;
import com.kebunit.androidallinone.activity.listview.ListViewFragment;
import com.kebunit.androidallinone.helper.CustomPagerAdapter;

public class ViewPagerTabView extends Fragment {

    private ViewPager viewPager;
    private TabLayout tabLayout;
    private CustomPagerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.vp_tab_view, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setSubtitle("Tab View");
        viewPager = (ViewPager) view.findViewById(R.id.view_pager);
        tabLayout = (TabLayout) view.findViewById(R.id.tablayout_item);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void setupViewPager(ViewPager vp){
        FragmentManager manager = getChildFragmentManager();
        adapter = new CustomPagerAdapter(manager);
        adapter.addFrag(new BasicLayoutFragment(), "Basic Layout");
        adapter.addFrag(new GridViewFragment(), "Grid View");
        adapter.addFrag(new ListViewFragment(), "List View");
        vp.setOffscreenPageLimit(adapter.getCount());
        vp.setAdapter(adapter);
    }
}
