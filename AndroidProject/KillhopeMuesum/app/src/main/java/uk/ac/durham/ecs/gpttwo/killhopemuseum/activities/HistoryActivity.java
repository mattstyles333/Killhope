package uk.ac.durham.ecs.gpttwo.killhopemuseum.activities;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import uk.ac.durham.ecs.gpttwo.killhopemuseum.adapters.HistoryPagerAdapter;
import uk.ac.durham.ecs.gpttwo.killhopemuseum.R;

public class HistoryActivity extends ActionBarActivity {

    private ViewPager mPager;
    private PagerAdapter mPageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_history_page);

        mPager = (ViewPager)findViewById(R.id.history_pager);
        mPageAdapter = new HistoryPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPageAdapter);

        getSupportActionBar().setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);
        android.support.v7.app.ActionBar.TabListener tabListener = new android.support.v7.app.ActionBar.TabListener() {

            @Override
            public void onTabSelected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction) {
                mPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction) {

            }

            @Override
            public void onTabReselected(ActionBar.Tab tab, android.support.v4.app.FragmentTransaction fragmentTransaction) {

            }
        };

        mPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                getSupportActionBar().setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        String[] tabnames = new String[]{"History Model", "Early Earth", "Wearside Granite", "Carboniferous Sediments", "North Pennine", "New Geological Model", "Untitled"};

        for(int i=0;i<HistoryPagerAdapter.NUM_PAGES;i++){
            getSupportActionBar().addTab(getSupportActionBar().newTab().setText(tabnames[i]).setTabListener(tabListener));
        }


        if(getResources().getConfiguration().orientation != 1){
            mPager.setBackgroundResource(R.drawable.bg_land);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_history, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_prevpage) {
            if(mPager.getCurrentItem() != 0) {
                mPager.setCurrentItem(mPager.getCurrentItem() - 1);
            }
            return true;
        }else if (id == R.id.action_nextpage) {
            if(mPager.getCurrentItem() != mPageAdapter.getCount() - 1) {
                mPager.setCurrentItem(mPager.getCurrentItem() + 1);
            }
            return true;
        }else if (id == android.R.id.home) {
            onBackPressed();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {
        super.onBackPressed();
    }

}
