package uk.ac.durham.ecs.gpttwo.killhopemuseum.adapters;

/**
 * Created by Matt on 2/26/2015.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import uk.ac.durham.ecs.gpttwo.killhopemuseum.fragments.HelpPageFragment;

public class HelpPagerAdapter extends FragmentStatePagerAdapter {
    public static final int NUM_PAGES = 5;
    public HelpPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return HelpPageFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return NUM_PAGES;
    }
}