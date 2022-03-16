package com.example.android101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.HashMap;

public class ResultRoof1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_roof_1);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        HashMap<String, Double> results = (HashMap<String, Double>) intent.getSerializableExtra("EXTRA_ROOF1_RESULTS_MAP");

        // get string values from results Map
        String result_string_gamma = String.valueOf(results.get("Gamma"));

        // Capture the layout's TextView and set the theta value as its text
        TextView textView = findViewById(R.id.roof1_result_gamma);
        textView.setText(result_string_gamma);
    }

}