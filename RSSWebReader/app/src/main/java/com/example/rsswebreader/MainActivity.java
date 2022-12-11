package com.example.rsswebreader;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private EditText rssUrlTextField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rssUrlTextField = findViewById(R.id.rssUrlTextField);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, RSSFeedActivity.class);
        String url = rssUrlTextField.getText().toString();
        intent.putExtra("url", url);
        startActivity(intent);
    }
}
