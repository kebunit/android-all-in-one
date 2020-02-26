package com.kebunit.androidallinone.helper;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class CustomPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment> mFragmentList;
    private ArrayList<String> mFragmentTitleList;

    public CustomPagerAdapter(FragmentManager manager) {
        super(manager);
        this.mFragmentList = new ArrayList<>();
        this.mFragmentTitleList = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    public void addFrag(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
}
