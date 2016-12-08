package com.advinity.carbonteam.hydrocarbon.activity;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.advinity.carbonteam.hydrocarbon.R;

public class EbookDetailsActivity extends AppCompatActivity {

    TextView title, subtitle, writer, edition, year, description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook_details);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        String eTitle = (String) getIntent().getExtras().get("title");
        collapsingToolbarLayout.setTitle(eTitle);

        ImageView collapsingImage = (ImageView) findViewById(R.id.collapsing_image);
        Integer eImage = (Integer) getIntent().getExtras().get("image");
        collapsingImage.setImageResource(eImage);

        String eSubtitle = (String) getIntent().getExtras().get("subtitle");
        String eWriter = (String) getIntent().getExtras().get("writer");
        String eEdition = (String) getIntent().getExtras().get("edition");
        String eYear = (String) getIntent().getExtras().get("year");
        String eDescription = (String) getIntent().getExtras().get("description");

        title = (TextView) findViewById(R.id.item_ebook_title);
        subtitle = (TextView) findViewById(R.id.item_ebook_subtitle);
        writer = (TextView) findViewById(R.id.item_ebook_writer);
        edition = (TextView) findViewById(R.id.item_ebook_edition);
        year = (TextView) findViewById(R.id.item_ebook_year);
        description = (TextView) findViewById(R.id.item_ebook_description);

        title.setText(eTitle);
        subtitle.setText(eSubtitle);
        writer.setText(eWriter);
        edition.setText(eEdition);
        year.setText(eYear);
        description.setText(eDescription);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
