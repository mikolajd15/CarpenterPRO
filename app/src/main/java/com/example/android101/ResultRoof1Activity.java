package com.example.android101;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class ResultRoof1Activity extends AppCompatActivity {
    int roof_type;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_roof_1);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        HashMap<String, Double> results = (HashMap<String, Double>) intent.getSerializableExtra("EXTRA_ROOF1_RESULTS_MAP");
        ImageView roof_image_view_result = (ImageView) findViewById(R.id.iv_roof_image_result);
        roof_type = intent.getIntExtra("ROOF_TYPE", 0);

        if (roof_type == 1) {
            roof_image_view_result.setImageDrawable(getResources().getDrawable(R.drawable.jednospadowy_krokwia, getApplicationContext().getTheme()));
        } else if (roof_type == 2) {
            roof_image_view_result.setImageDrawable(getResources().getDrawable(R.drawable.dwuspadowy_symetryczny_krokwia, getApplicationContext().getTheme()));
        } else if (roof_type == 3) {
            roof_image_view_result.setImageDrawable(getResources().getDrawable(R.drawable.dwuspadowy_niesymetryczny_krokwia_a, getApplicationContext().getTheme()));
        } else {
            throw new IllegalArgumentException("Incorrect roof type: " + roof_type);
        }

        // get string values from results Map
        String result_string_gamma = String.format("%.2f", results.get("Gamma"));
        String result_string_H1 = String.format("%.2f", results.get("H1"));
        String result_string_H2 = String.format("%.2f", results.get("H2"));
        String result_string_Lp = String.format("%.2f", results.get("Lp"));
        String result_string_Lc = String.format("%.2f", results.get("Lc"));
        String result_string_M2 = String.format("%.2f", results.get("M2"));
        String result_string_M1 = String.format("%.2f", results.get("M1"));
        String result_string_N2 = String.format("%.2f", results.get("N2"));
        String result_string_N1 = String.format("%.2f", results.get("N1"));
        String result_string_K2 = String.format("%.2f", results.get("K2"));
        String result_string_K1 = String.format("%.2f", results.get("K1"));
        String result_string_Pk = String.format("%.2f", results.get("Pk"));
        String result_string_Cd = String.format("%.2f", results.get("Cd"));
        String result_string_Nr = String.format("%.2f", results.get("Nr"));

        // Capture the layout's TextView and set the theta value as its text
        TextView tv_gamma = findViewById(R.id.roof1_result_gamma);
        TextView tv_H1 = findViewById(R.id.roof1_result_H1);
        TextView tv_H2 = findViewById(R.id.roof1_result_H2);
        TextView tv_Lp = findViewById(R.id.roof1_result_Lp);
        TextView tv_Lc = findViewById(R.id.roof1_result_Lc);
        TextView tv_M2 = findViewById(R.id.roof1_result_M2);
        TextView tv_M1 = findViewById(R.id.roof1_result_M1);
        TextView tv_N2 = findViewById(R.id.roof1_result_N2);
        TextView tv_N1 = findViewById(R.id.roof1_result_N1);
        TextView tv_K2 = findViewById(R.id.roof1_result_K2);
        TextView tv_K1 = findViewById(R.id.roof1_result_K1);
        TextView tv_Pk = findViewById(R.id.roof1_result_Pk);
        TextView tv_Cd = findViewById(R.id.roof1_result_Cd);
        TextView tv_Nr = findViewById(R.id.roof1_result_Nr);

        tv_gamma.setText("\u0194 = "+result_string_gamma);
        tv_H1.setText("H1 = "+result_string_H1);
        tv_H2.setText("H2 = "+result_string_H2);
        tv_Lp.setText("Lp = "+result_string_Lp);
        tv_Lc.setText("Lc = "+result_string_Lc);
        tv_M2.setText("M2 = "+result_string_M2);
        tv_M1.setText("M1 = "+result_string_M1);
        tv_N2.setText("N2 = "+result_string_N2);
        tv_N1.setText("N1 = "+result_string_N1);
        tv_K2.setText("K2 = "+result_string_K2);
        tv_K1.setText("K1 = "+result_string_K1);
        tv_Pk.setText("Pk = "+result_string_Pk);
        tv_Cd.setText("Cd = "+result_string_Cd); //TODO remove Cd
        tv_Nr.setText("Nr = "+result_string_Nr);
    }

}











