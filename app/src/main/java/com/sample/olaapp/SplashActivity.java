package com.sample.olaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.sample.olaapp.Model.Constant;
import com.sample.olaapp.Model.Drivers;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends AppCompatActivity {

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);

        /*mDatabase = FirebaseDatabase.getInstance().getReference().child(Constant.FIREBASE_DB);
        String key = mDatabase.child("drivers").push().getKey();
        Drivers drivers = new Drivers(key,"Driver 5",0,0);
        mDatabase.child("drivers").child(key).setValue(drivers);*/

    }

    @OnClick(R.id.driver)
    public void openDriver() {
        startActivity(new Intent(this, DriverMainActivity.class));
    }

    @OnClick(R.id.customer)
    public void openCustomer() {
        startActivity(new Intent(this, DriverMainActivity.class));
    }

    @OnClick(R.id.dashboard)
    public void openDashboard() {
        startActivity(new Intent(this, DriverMainActivity.class));
    }

}
