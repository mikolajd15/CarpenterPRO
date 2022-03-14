package com.example.android101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultRoof1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_roof_1);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        Float theta_result = intent.getExtras().getFloat("EXTRA_ROOF1_THETA");

        // Capture the layout's TextView and set the theta value as its text
        TextView textView = findViewById(R.id.theta_result);
        textView.setText(String.valueOf(theta_result));
    }

}