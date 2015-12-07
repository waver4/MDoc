package com.waver.mdoc;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;


public class MyFragmentPagerAdapter extends FragmentPagerAdapter {

    private String[] title = new String[]{"Tab1", "Tab2", "Tab3", "Tab4", "Tab5"};
    List<Fragment> fragments;
    public MyFragmentPagerAdapter(FragmentManager fm,List<Fragment> mfragments) {
        super(fm);
        this.fragments = mfragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return title[position];
    }
}
