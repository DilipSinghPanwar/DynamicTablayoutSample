package com.dynamictablayoutsample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;

import java.io.Serializable;
import java.util.List;

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    private List<Item> list;
    private SparseArray<MainFragment> mRegisteredFragments = new SparseArray<>();

    public MainViewPagerAdapter(FragmentManager manager, List<Item> list) {
        super(manager);
        this.list = list;
    }

    @Override
    public Fragment getItem(int position) {
        return newInstance(list.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        MainFragment mainFragment = (MainFragment) super.instantiateItem(container, position);
        mRegisteredFragments.put(position, mainFragment);
        return mainFragment;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        mRegisteredFragments.remove(position);
        super.destroyItem(container, position, object);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list.get(position).getContent();
    }

    private MainFragment newInstance(Item items) {
        MainFragment mainFragment = new MainFragment();
        Bundle args = new Bundle();
        args.putSerializable(MainFragment.KEY_ITEM_LIST, (Serializable) items);
        mainFragment.setArguments(args);
        return mainFragment;
    }
}
