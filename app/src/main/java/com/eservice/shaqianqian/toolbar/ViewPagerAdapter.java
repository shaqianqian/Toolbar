package com.eservice.shaqianqian.toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;
//ViewPager est un container de page qui contient les fragment, c'est pourquoi on a besoin
//cette classe pour ajouter les fragments dans viewpager selon leur ordre.
public class ViewPagerAdapter extends FragmentPagerAdapter {


    private List<Fragment> fragmentList;
    private List<String> titleList;

    public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragmentList, List<String> titleList) {
        super(fm);
        this.fragmentList = fragmentList;
        this.titleList = titleList;
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

        @Override
        public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleList.get(position);
    }
}