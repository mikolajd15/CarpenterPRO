package com.example.android101;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.HashMap;

public class ResultsActivity extends AppCompatActivity {
    int roof_type;
    HashMap<String, Double> results;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView roof_image_view_result;
        // Get the Intent that started this activity
        Intent intent = getIntent();
        results = (HashMap<String, Double>) intent.getSerializableExtra("EXTRA_ROOF1_RESULTS_MAP");
        roof_type = intent.getIntExtra("ROOF_TYPE", 0);

        if (roof_type == 1) {
            setContentView(R.layout.activity_result_roof_1);
            roof_image_view_result = findViewById(R.id.iv_results_image);
            roof_image_view_result.setImageDrawable(getResources().getDrawable(R.drawable.jednospadowy_krokwia, getApplicationContext().getTheme()));
            displayResultsRoof_1_or_2();
        } else if (roof_type == 2) {
            setContentView(R.layout.activity_result_roof_1);
            roof_image_view_result = findViewById(R.id.iv_results_image);
            roof_image_view_result.setImageDrawable(getResources().getDrawable(R.drawable.dwuspadowy_symetryczny_krokwia, getApplicationContext().getTheme()));
            displayResultsRoof_1_or_2();
        } else if (roof_type == 3) {
            setContentView(R.layout.activity_result_roof_1);
            roof_image_view_result = findViewById(R.id.iv_results_image);
            roof_image_view_result.setImageDrawable(getResources().getDrawable(R.drawable.dwuspadowy_niesymetryczny_krokwia_a, getApplicationContext().getTheme()));
            displayResultsRoof_3();
        } else if (roof_type == 4) {
            setContentView(R.layout.activity_result_roof_4);
            displayResultsRoof_4();
        } else {
            throw new IllegalArgumentException("Incorrect roof type: " + roof_type);
        }
    }


    @SuppressLint({"DefaultLocale", "ResourceType"})
    private void displayResultsRoof_4() {
        TextView tv_headHk = findViewById(R.id.text_head_Hk);
        tv_headHk.setText(String.format("Wysokość kalenicy = %s", String.format("%.2f", results.get("HK"))));
        TextView tv_headHpk = findViewById(R.id.text_head_Hpk);
        tv_headHpk.setText(String.format("Wysokość płatwi kalenicowej = %s", String.format("%.2f", results.get("Hpk"))));
        TextView tv_headB = findViewById(R.id.text_head_B);
        tv_headB.setText(String.format("Okap połaci B: D = %s", String.format("%.2f", results.get("D"))));

        TextView tv_1_L = findViewById(R.id.text_1_L);
        tv_1_L.setText(String.format("Długość krokwi L = %s", String.format("%.2f", results.get("Dkr"))));
        TextView tv_1_alpha = findViewById(R.id.text_1_alpha);
        tv_1_alpha.setText(String.format("Kąt krokwi α = %s", String.format("%.1f", results.get("alpha_A"))));
        TextView tv_1_N2 = findViewById(R.id.text_1_N2);
        tv_1_N2.setText(String.format("Długość do zaciosu N2 = %s", String.format("%.2f", results.get("N2_A"))));
        TextView tv_1_N1 = findViewById(R.id.text_1_N1);
        tv_1_N1.setText(String.format("Długość do zaciosu N1 = %s", String.format("%.2f", results.get("N1_A"))));

        TextView tv_2_L = findViewById(R.id.text_2_L);
        StringBuilder Dkr_As = new StringBuilder();
        for (int i = 0; i < results.get("no_kpA"); i++) {
            Dkr_As.append(String.format("%.1f; ", results.get("DKLs_A" + (i + 1))));
        }
        tv_2_L.setText("Długości kulawek L = [" + Dkr_As + "]");
        TextView tv_2_beta = findViewById(R.id.text_2_beta);
        tv_2_beta.setText(String.format("Kąt kulawki β = %s", String.format("%.1f", results.get("beta_A"))));
        TextView tv_2_alpha = findViewById(R.id.text_2_alpha);
        tv_2_alpha.setText(String.format("Kąt kulawki α = %s", String.format("%.1f", results.get("alpha_A"))));
        TextView tv_2_N2 = findViewById(R.id.text_2_N2);
        tv_2_N2.setText(String.format("Długość do zaciosu N2 = %s", String.format("%.2f", results.get("N2_A"))));
        TextView tv_2_N1 = findViewById(R.id.text_2_N1);
        tv_2_N1.setText(String.format("Długość do zaciosu N1 = %s", String.format("%.2f", results.get("N1_A"))));

        TextView tv_3_L = findViewById(R.id.text_3_L);
        tv_3_L.setText(String.format("Długość krokwi L = %s", String.format("%.2f", results.get("Lk"))));
        TextView tv_3_mi = findViewById(R.id.text_3_mi);
        tv_3_mi.setText(String.format("Kąt krokwi μ = %s", String.format("%.1f", results.get("gamma"))));
        TextView tv_3_alpha = findViewById(R.id.text_3_alpha);
        tv_3_alpha.setText(String.format("Kąt zaciosu do połaci B: α = %s", String.format("%.1f", results.get("fi"))));
        TextView tv_3_beta = findViewById(R.id.text_3_beta);
        tv_3_beta.setText(String.format("Kąt zaciosu do połaci A: β = %s", String.format("%.1f", results.get("ni"))));
        TextView tv_3_delta = findViewById(R.id.text_3_delta);
        tv_3_delta.setText(String.format("Kąt fazowania do połaci B: δ = %s", String.format("%.1f", results.get("ro"))));
        TextView tv_3_ro = findViewById(R.id.text_3_psi);
        tv_3_ro.setText(String.format("Kąt fazowania do połaci A: ψ = %s", String.format("%.1f", results.get("psi"))));

        TextView tv_4_L = findViewById(R.id.text_4_L);
        tv_4_L.setText(String.format("Długość krokwi L = %s", String.format("%.2f", results.get("L"))));
        TextView tv_4_beta = findViewById(R.id.text_4_beta);
        tv_4_beta.setText(String.format("Kąt krokwi β = %s", String.format("%.1f", results.get("beta_B"))));
        TextView tv_4_alpha = findViewById(R.id.text_4_alpha);
        tv_4_alpha.setText(String.format("Kąt krokwi α = %s", String.format("%.1f", results.get("alpha_B"))));
        TextView tv_4_N2 = findViewById(R.id.text_4_N2);
        tv_4_N2.setText(String.format("Długość do zaciosu N2 = %s", String.format("%.2f", results.get("N2_B"))));
        TextView tv_4_N1 = findViewById(R.id.text_4_N1);
        tv_4_N1.setText(String.format("Długość do zaciosu N1 = %s", String.format("%.2f", results.get("N1_B"))));

        TextView tv_5_L = findViewById(R.id.text_5_L);
        StringBuilder Dkr_Bs = new StringBuilder();
        for (int i = 0; i < results.get("no_kpB"); i++) {
            Dkr_Bs.append(String.format("%.1f; ", results.get("DKLs_B" + (i + 1))));
        }
        tv_5_L.setText("Długości kulawek L = [" + Dkr_Bs + "]");
        TextView tv_5_beta = findViewById(R.id.text_5_beta);
        tv_5_beta.setText(String.format("Kąt krokwi β = %s", String.format("%.1f", results.get("beta_B"))));
        TextView tv_5_alpha = findViewById(R.id.text_5_alpha);
        tv_5_alpha.setText(String.format("Kąt krokwi α = %s", String.format("%.1f", results.get("alpha_B"))));
        TextView tv_5_N2 = findViewById(R.id.text_5_N2);
        tv_5_N2.setText(String.format("Długość do zaciosu N2 = %s", String.format("%.2f", results.get("N2_B"))));
        TextView tv_5_N1 = findViewById(R.id.text_5_N1);
        tv_5_N1.setText(String.format("Długość do zaciosu N1 = %s", String.format("%.2f", results.get("N1_B"))));
    }

    @SuppressLint("DefaultLocale")
    private void displayResultsRoof_1_or_2() {
        // Capture the layout's TextView and set the Views to it
        TextView tv_gamma = findViewById(R.id.roof1_result_00);
        TextView tv_H1 = findViewById(R.id.roof1_result_31);
        TextView tv_H2 = findViewById(R.id.roof1_result_30);
        TextView tv_Lp = findViewById(R.id.roof1_result_01);
        TextView tv_Lc = findViewById(R.id.roof1_result_02);
        TextView tv_M2 = findViewById(R.id.roof1_result_22);
        TextView tv_M1 = findViewById(R.id.roof1_result_21);
        TextView tv_N2 = findViewById(R.id.roof1_result_20);
        TextView tv_N1 = findViewById(R.id.roof1_result_12);
        TextView tv_K2 = findViewById(R.id.roof1_result_11);
        TextView tv_K1 = findViewById(R.id.roof1_result_10);
        TextView tv_Pk = findViewById(R.id.roof1_result_41);
        TextView tv_Cd = findViewById(R.id.roof1_result_32);
        TextView tv_Nr = findViewById(R.id.roof1_result_40);

        tv_gamma.setText(String.format("Ɣ = %s", String.format("%.2f", results.get("Gamma"))));
        tv_H1.setText(String.format("H1 = %s", String.format("%.2f", results.get("H1"))));
        tv_H2.setText(String.format("H2 = %s", String.format("%.2f", results.get("H2"))));
        tv_Lp.setText(String.format("Lp = %s", String.format("%.2f", results.get("Lp"))));
        tv_Lc.setText(String.format("Lc = %s", String.format("%.2f", results.get("Lc"))));
        tv_M2.setText(String.format("M2 = %s", String.format("%.2f", results.get("M2"))));
        tv_M1.setText(String.format("M1 = %s", String.format("%.2f", results.get("M1"))));
        tv_N2.setText(String.format("N2 = %s", String.format("%.2f", results.get("N2"))));
        tv_N1.setText(String.format("N1 = %s", String.format("%.2f", results.get("N1"))));
        tv_K2.setText(String.format("K2 = %s", String.format("%.2f", results.get("K2"))));
        tv_K1.setText(String.format("K1 = %s", String.format("%.2f", results.get("K1"))));
        tv_Pk.setText(String.format("Pk = %s", String.format("%.2f", results.get("Pk"))));
        tv_Cd.setText(String.format("Pole = %s", String.format("%.2f", results.get("Area"))));
        tv_Nr.setText(String.format("Nr = %s", String.format("%.2f", results.get("Nr"))));
    }

    @SuppressLint("DefaultLocale")
    private void displayResultsRoof_3() {
        TextView tv_LAc = findViewById(R.id.roof1_result_00);
        TextView tv_LBp = findViewById(R.id.roof1_result_01);
        TextView tv_SA = findViewById(R.id.roof1_result_02);
        TextView tv_HK = findViewById(R.id.roof1_result_10);
        TextView tv_HB1 = findViewById(R.id.roof1_result_11);
        TextView tv_NB2 = findViewById(R.id.roof1_result_12);
        TextView tv_NA1 = findViewById(R.id.roof1_result_20);
        TextView tv_MA1 = findViewById(R.id.roof1_result_21);
        TextView tv_PP = findViewById(R.id.roof1_result_22);

        tv_LAc.setText(String.format("LAc = %s", String.format("%.2f", results.get("LAc"))));
        tv_LBp.setText(String.format("LBp = %s", String.format("%.2f", results.get("LBp"))));
        tv_SA.setText(String.format("SA = %s", String.format("%.2f", results.get("SA"))));
        tv_HK.setText(String.format("HK = %s", String.format("%.2f", results.get("HK"))));
        tv_HB1.setText(String.format("HB1 = %s", String.format("%.2f", results.get("HB1"))));
        tv_NB2.setText(String.format("NB2 = %s", String.format("%.2f", results.get("NB2"))));
        tv_NA1.setText(String.format("NA1 = %s", String.format("%.2f", results.get("NA1"))));
        tv_MA1.setText(String.format("MA1 = %s", String.format("%.2f", results.get("MA1"))));
        tv_PP.setText(String.format("PP = %s", String.format("%.2f", results.get("PP"))));

        (findViewById(R.id.roof1_result_30)).setVisibility(View.INVISIBLE);
        (findViewById(R.id.roof1_result_31)).setVisibility(View.INVISIBLE);
        (findViewById(R.id.roof1_result_32)).setVisibility(View.INVISIBLE);
        (findViewById(R.id.roof1_result_40)).setVisibility(View.INVISIBLE);
        (findViewById(R.id.roof1_result_41)).setVisibility(View.INVISIBLE);
    }

}










