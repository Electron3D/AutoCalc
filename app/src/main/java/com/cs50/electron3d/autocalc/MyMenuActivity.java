package com.cs50.electron3d.autocalc;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MyMenuActivity extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mymenu);

        Button autoCostCalcButton = findViewById(R.id.AutoCostCalcButton);
        Button tireSizeCalcButton = findViewById(R.id.TireSizeCalcButton);
        Button settingsButton = findViewById(R.id.SettingsButton);
        autoCostCalcButton.setOnClickListener(this);
        tireSizeCalcButton.setEnabled(false);
        //tireSizeCalcButton.setOnClickListener(this);
        settingsButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.AutoCostCalcButton:
                intent = new Intent(MyMenuActivity.this, AutoCostCalcActivity.class);
                startActivity(intent);
                break;
            /*case R.id.TireSizeCalcButton:
                intent = new Intent(MyMenuActivity.this, TireSizeCalcActivity.class);
                startActivity(intent);
                break;*/
            case R.id.SettingsButton:
                intent = new Intent(MyMenuActivity.this, SettingsActivity.class);
                startActivity(intent);
                break;
        }
    }
}
