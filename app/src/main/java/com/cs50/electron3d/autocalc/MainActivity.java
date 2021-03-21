package com.cs50.electron3d.autocalc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView icon = findViewById(R.id.icon);
        icon.setImageResource(R.drawable.icon_transparent);

        Button startButton = findViewById(R.id.StartButton);
        startButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, MyMenuActivity.class);
            startActivity(intent);
        });
    }
}