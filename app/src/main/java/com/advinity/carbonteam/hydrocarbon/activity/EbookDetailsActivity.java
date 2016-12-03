package com.advinity.carbonteam.hydrocarbon.activity;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;

import com.advinity.carbonteam.hydrocarbon.R;

public class EbookDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        String title = (String) getIntent().getExtras().get("title");
        collapsingToolbarLayout.setTitle(title);

        ImageView collapsingImage = (ImageView) findViewById(R.id.collapsing_image);
        Integer thumbnail = (Integer) getIntent().getExtras().get("thumbnail");
        collapsingImage.setImageResource(thumbnail);

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
