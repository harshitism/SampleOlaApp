package com.sample.olaapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
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
