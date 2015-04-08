package uk.ac.durham.ecs.gpttwo.killhopemuseum.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import uk.ac.durham.ecs.gpttwo.killhopemuseum.fragments.HistoryPageFragment;

public class HistoryPagerAdapter extends FragmentStatePagerAdapter {
    public static final int NUM_PAGES=5;
    public HistoryPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return  HistoryPageFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}