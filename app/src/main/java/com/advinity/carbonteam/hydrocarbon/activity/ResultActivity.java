package com.advinity.carbonteam.hydrocarbon.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.advinity.carbonteam.hydrocarbon.R;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();

        return super.onSupportNavigateUp();
    }
}
