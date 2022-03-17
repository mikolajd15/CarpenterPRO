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
        String result_string_H1 = String.valueOf(results.get("H1"));
        String result_string_H2 = String.valueOf(results.get("H2"));
        String result_string_Lp = String.valueOf(results.get("Lp"));
        String result_string_Lc = String.valueOf(results.get("Lc"));
        String result_string_M2 = String.valueOf(results.get("M2"));
        String result_string_M1 = String.valueOf(results.get("M1"));
        String result_string_N2 = String.valueOf(results.get("N2"));
        String result_string_N1 = String.valueOf(results.get("N1"));
        String result_string_K2 = String.valueOf(results.get("K2"));
        String result_string_K1 = String.valueOf(results.get("K1"));
        String result_string_Pk = String.valueOf(results.get("Pk"));
        String result_string_Cd = String.valueOf(results.get("Cd"));
        String result_string_Nr = String.valueOf(results.get("Nr"));

        // Capture the layout's TextView and set the theta value as its text
        TextView textView = findViewById(R.id.roof1_result_gamma);
        textView.setText(result_string_gamma);
        textView.findViewById(R.id.roof1_result_Lp);
        textView.setText(result_string_Lp);
    }

}