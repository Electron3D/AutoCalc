package com.cs50.electron3d.autocalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsActivity extends Activity implements View.OnClickListener {
    /* TODO
     *   1) добавить выбор валюты */

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button aboutAppButton = findViewById(R.id.AboutAppButton);
        Button aboutDeveloperButton = findViewById(R.id.AboutDeveloperButton);
        aboutAppButton.setOnClickListener(this);
        aboutDeveloperButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.AboutAppButton:
                intent = new Intent(SettingsActivity.this, AboutAppActivity.class);
                startActivity(intent);
                break;
            case R.id.AboutDeveloperButton:
                intent = new Intent(SettingsActivity.this, AboutDeveloperActivity.class);
                startActivity(intent);
                break;
        }
    }
}