package com.sample.olaapp;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sample.olaapp.Fragments.CompletedFragment;
import com.sample.olaapp.Fragments.OngoingFragment;
import com.sample.olaapp.Fragments.WaitingFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DriverMainActivity extends AppCompatActivity {

    @BindView(R.id.tablayout)
    TabLayout tabLayout;

    @BindView(R.id.viewpager)
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_main);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle("Ola Cab Bookings");
        ButterKnife.bind(this);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
    }

    public class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    WaitingFragment fragment = new WaitingFragment();
                    return fragment;
                case 1:
                    OngoingFragment fragment1 = new OngoingFragment();
                    return fragment1;
                case 2:
                    CompletedFragment fragment2 = new CompletedFragment();
                    return fragment2;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }
    }
}
