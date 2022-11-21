package com.example.rsswebfeed;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<String> rssLinks = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnOpen = findViewById(R.id.btnOpenRssLink);
        Button btnRediff = findViewById(R.id.btnRediff);
        Button btnCinemaBlend = findViewById(R.id.btnCinemaBlend);
        EditText etRssLink = findViewById(R.id.etRssLink);

        btnOpen.setOnClickListener(this);
        btnRediff.setOnClickListener(this);
        btnCinemaBlend.setOnClickListener(this);

        rssLinks.add("https://www.rediff.com/rss/moviesrss.xml");
        rssLinks.add("https://www.cinemablend.com/rss_news.php");
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getApplicationContext(), RSSFeedActivity.class);
        switch (view.getId()) {
            case R.id.btnRediff:
                intent.putExtra("rssLink", rssLinks.get(0));
                startActivity(intent);
                break;
            case R.id.btnCinemaBlend:
                intent.putExtra("rssLink", rssLinks.get(1));
                startActivity(intent);
                break;
        }

    }
}