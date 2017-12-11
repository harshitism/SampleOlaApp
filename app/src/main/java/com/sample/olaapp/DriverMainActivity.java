package com.sample.olaapp;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.sample.olaapp.Fragments.CompletedFragment;
import com.sample.olaapp.Fragments.OngoingFragment;
import com.sample.olaapp.Fragments.WaitingFragment;
import com.sample.olaapp.Model.Constant;
import com.sample.olaapp.Model.Drivers;
import com.sample.olaapp.Model.Helper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DriverMainActivity extends AppCompatActivity {

    @BindView(R.id.drivertablayout)
    TabLayout driverTabLayout;

    @BindView(R.id.tablayout)
    TabLayout tabLayout;

    @BindView(R.id.viewpager)
    ViewPager viewPager;
    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver_main);
        getSupportActionBar().setElevation(0);
        getSupportActionBar().setTitle("Ola Cab Bookings");
        ButterKnife.bind(this);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(viewPager));


        final List<Drivers> drivers = new ArrayList<>();
        mDatabase = FirebaseDatabase.getInstance().getReference().child(Constant.FIREBASE_DB);
        mDatabase.child("drivers").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    drivers.add(postSnapshot.getValue(Drivers.class));
                }
                Helper.setStringSharedPreference("ACTIVE_DRIVER", drivers.get(0).getId(), DriverMainActivity.this);
                viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        driverTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                Helper.setStringSharedPreference("ACTIVE_DRIVER", drivers.get(tab.getPosition()).getId(), DriverMainActivity.this);
                viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


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
