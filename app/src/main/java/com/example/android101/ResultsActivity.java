package com.example.android101;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
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
            displayResultsRoof_1();
        } else if (roof_type == 2) {
            setContentView(R.layout.activity_result_roof_2);
            displayResultsRoof_2();
        } else if (roof_type == 3) {
            setContentView(R.layout.activity_result_roof_3);
            displayResultsRoof_3();
        } else if (roof_type == 4) {
            setContentView(R.layout.activity_result_roof_4);
            displayResultsRoof_4();
        } else {
            throw new IllegalArgumentException("Incorrect roof type: " + roof_type);
        }
    }

    @SuppressLint("DefaultLocale")
    private void displayResultsRoof_1() {

        TextView tv_head_H1 = findViewById(R.id.text_head1_H1);
        TextView tv_head_H2 = findViewById(R.id.text_head1_H2);
        TextView tv_head_NK = findViewById(R.id.text_head1_NK);
        TextView tv_head_Pk = findViewById(R.id.text_head1_Pk);
        TextView tv_head_Gamma = findViewById(R.id.text_head1_Gamma);
        TextView tv_head_Area = findViewById(R.id.text_head1_Area);
        TextView tv_body_S = findViewById(R.id.text_body1_S);
        TextView tv_body_Lc = findViewById(R.id.text_body1_Lc);
        TextView tv_body_Lp = findViewById(R.id.text_body1_Lp);
        TextView tv_body_K1 = findViewById(R.id.text_body1_K1);
        TextView tv_body_K2 = findViewById(R.id.text_body1_K2);
        TextView tv_body_N1 = findViewById(R.id.text_body1_N1);
        TextView tv_body_N2 = findViewById(R.id.text_body1_N2);
        TextView tv_body_M1 = findViewById(R.id.text_body1_M1);
        TextView tv_body_M2 = findViewById(R.id.text_body1_M2);

        tv_head_H1.setText(String.format((tv_head_H1).getText() + "%s cm", String.format("%.1f", results.get("H1"))));
        tv_head_H2.setText(String.format((tv_head_H2).getText() + "%s cm", String.format("%.1f", results.get("H2"))));
        tv_head_NK.setText(String.format((tv_head_NK).getText() + "%s", String.format("%.1f", results.get("Nr"))));
        tv_head_Pk.setText(String.format((tv_head_Pk).getText() + "%s cm", String.format("%.1f", results.get("Pk"))));
        tv_head_Gamma.setText(String.format((tv_head_Gamma).getText() + "γ = %s°", String.format("%.1f", results.get("Gamma"))));
        tv_head_Area.setText(String.format((tv_head_Area).getText() + "%s m\u00b2", String.format("%.1f", results.get("Area"))));
        tv_body_S.setText(String.format((tv_body_S).getText() + "%s cm", String.format("%.1f", results.get("S"))));
        tv_body_Lc.setText(String.format((tv_body_Lc).getText() + "%s cm", String.format("%.1f", results.get("Lc"))));
        tv_body_Lp.setText(String.format((tv_body_Lp).getText() + "%s cm", String.format("%.1f", results.get("Lp"))));
        tv_body_K1.setText(String.format((tv_body_K1).getText() + "%s cm", String.format("%.1f", results.get("K1"))));
        tv_body_K2.setText(String.format((tv_body_K2).getText() + "%s cm", String.format("%.1f", results.get("K2"))));
        tv_body_N1.setText(String.format((tv_body_N1).getText() + "%s cm", String.format("%.1f", results.get("N1"))));
        tv_body_N2.setText(String.format((tv_body_N2).getText() + "%s cm", String.format("%.1f", results.get("N2"))));
        tv_body_M1.setText(String.format((tv_body_M1).getText() + "%s cm", String.format("%.1f", results.get("M1"))));
        tv_body_M2.setText(String.format((tv_body_M2).getText() + "%s cm", String.format("%.1f", results.get("M2"))));

    }

    @SuppressLint("DefaultLocale")
    private void displayResultsRoof_2() {
        TextView tv_head_H1 = findViewById(R.id.text_head2_H1);
        TextView tv_head_H2 = findViewById(R.id.text_head2_H2);
        TextView tv_head_NK = findViewById(R.id.text_head2_NK);
        TextView tv_head_Pk = findViewById(R.id.text_head2_Pk);
        TextView tv_head_Gamma = findViewById(R.id.text_head2_Gamma);
        TextView tv_head_Area = findViewById(R.id.text_head2_Area);
        TextView tv_body_S = findViewById(R.id.text_body2_S);
        TextView tv_body_S1 = findViewById(R.id.text_body2_S1);
        TextView tv_body_Lc = findViewById(R.id.text_body2_Lc);
        TextView tv_body_Lp = findViewById(R.id.text_body2_Lp);
        TextView tv_body_K2 = findViewById(R.id.text_body2_K2);
        TextView tv_body_N1 = findViewById(R.id.text_body2_N1);
        TextView tv_body_N2 = findViewById(R.id.text_body2_N2);
        TextView tv_body_M1 = findViewById(R.id.text_body2_M1);
        TextView tv_body_M2 = findViewById(R.id.text_body2_M2);

        tv_head_H1.setText(String.format((tv_head_H1).getText() + "%s cm", String.format("%.1f", results.get("H1"))));
        tv_head_H2.setText(String.format((tv_head_H2).getText() + "%s cm", String.format("%.1f", results.get("H2"))));
        tv_head_NK.setText(String.format((tv_head_NK).getText() + "%s", String.format("%.1f", results.get("Nr"))));
        tv_head_Pk.setText(String.format((tv_head_Pk).getText() + "%s cm", String.format("%.1f", results.get("Pk"))));
        tv_head_Gamma.setText(String.format((tv_head_Gamma).getText() + "γ = %s°", String.format("%.1f", results.get("Gamma"))));
        tv_head_Area.setText(String.format((tv_head_Area).getText() + "%s m\u00b2", String.format("%.1f", results.get("Area"))));
        tv_body_S.setText(String.format((tv_body_S).getText() + "%s cm", String.format("%.1f", results.get("S"))));
        tv_body_S1.setText(String.format((tv_body_S1).getText() + "%s cm", String.format("%.1f", results.get("S1"))));
        tv_body_Lc.setText(String.format((tv_body_Lc).getText() + "%s cm", String.format("%.1f", results.get("Lc"))));
        tv_body_Lp.setText(String.format((tv_body_Lp).getText() + "%s cm", String.format("%.1f", results.get("Lp"))));
        tv_body_K2.setText(String.format((tv_body_K2).getText() + "%s cm", String.format("%.1f", results.get("K2"))));
        tv_body_N1.setText(String.format((tv_body_N1).getText() + "%s cm", String.format("%.1f", results.get("N1"))));
        tv_body_N2.setText(String.format((tv_body_N2).getText() + "%s cm", String.format("%.1f", results.get("N2"))));
        tv_body_M1.setText(String.format((tv_body_M1).getText() + "%s cm", String.format("%.1f", results.get("M1"))));
        tv_body_M2.setText(String.format((tv_body_M2).getText() + "%s cm", String.format("%.1f", results.get("M2"))));
    }

    @SuppressLint("DefaultLocale")
    private void displayResultsRoof_3() {
        TextView tv_head_HK = findViewById(R.id.text_head3_HK);
        TextView tv_head_HA1 = findViewById(R.id.text_head3_HA1);
        TextView tv_head_HB1 = findViewById(R.id.text_head3_HB1);
        TextView tv_head_HA2 = findViewById(R.id.text_head3_HA2);
        TextView tv_head_PP = findViewById(R.id.text_head3_PP);
        TextView tv_head_Gamma = findViewById(R.id.text_head3_Gamma);
        TextView tv_head_SA = findViewById(R.id.text_body3_SA);
        TextView tv_head_SB = findViewById(R.id.text_body3_SB);
        TextView tv_head_SA1 = findViewById(R.id.text_body3_SA1);
        TextView tv_head_LAc = findViewById(R.id.text_body3_LAc);
        TextView tv_head_LAp = findViewById(R.id.text_body3_LAp);
        TextView tv_head_KA2 = findViewById(R.id.text_body3_KA2);
        TextView tv_head_NA1 = findViewById(R.id.text_body3_NA1);
        TextView tv_head_NA2 = findViewById(R.id.text_body3_NA2);
        TextView tv_head_MA1 = findViewById(R.id.text_body3_MA1);
        TextView tv_head_MA2 = findViewById(R.id.text_body3_MA2);
        TextView tv_head_SB_2 = findViewById(R.id.text_body3_SB_2);
        TextView tv_head_SB1 = findViewById(R.id.text_body3_SB1);
        TextView tv_head_LBc = findViewById(R.id.text_body3_LBc);
        TextView tv_head_LBp = findViewById(R.id.text_body3_LBp);
        TextView tv_head_KB2 = findViewById(R.id.text_body3_KB2);
        TextView tv_head_NB1 = findViewById(R.id.text_body3_NB1);
        TextView tv_head_NB2 = findViewById(R.id.text_body3_NB2);
        TextView tv_head_MB1 = findViewById(R.id.text_body3_MB1);
        TextView tv_head_MB2 = findViewById(R.id.text_body3_MB2);

        tv_head_HK.setText(String.format((tv_head_HK).getText() + "%s cm", String.format("%.1f", results.get("HK"))));
        tv_head_HA1.setText(String.format((tv_head_HA1).getText() + "%s cm", String.format("%.1f", results.get("HA1"))));
        tv_head_HB1.setText(String.format((tv_head_HB1).getText() + "%s cm", String.format("%.1f", results.get("HB1"))));
        tv_head_HA2.setText(String.format((tv_head_HA2).getText() + "%s cm", String.format("%.1f", results.get("HA2"))));
        tv_head_PP.setText(String.format((tv_head_PP).getText() + "%s cm", String.format("%.1f", results.get("PP"))));
        tv_head_Gamma.setText(String.format((tv_head_Gamma).getText() + "γ = %s°", String.format("%.1f", results.get("Gamma"))));
        tv_head_SA.setText(String.format((tv_head_SA).getText() + "%s cm", String.format("%.1f", results.get("SA"))));
        tv_head_SB.setText(String.format((tv_head_SB).getText() + "%s cm", String.format("%.1f", results.get("SB"))));
        tv_head_SA1.setText(String.format((tv_head_SA1).getText() + "%s cm", String.format("%.1f", results.get("SA1"))));
        tv_head_LAc.setText(String.format((tv_head_LAc).getText() + "%s cm", String.format("%.1f", results.get("LAc"))));
        tv_head_LAp.setText(String.format((tv_head_LAp).getText() + "%s cm", String.format("%.1f", results.get("LAp"))));
        tv_head_KA2.setText(String.format((tv_head_KA2).getText() + "%s cm", String.format("%.1f", results.get("KA2"))));
        tv_head_NA1.setText(String.format((tv_head_NA1).getText() + "%s cm", String.format("%.1f", results.get("NA1"))));
        tv_head_NA2.setText(String.format((tv_head_NA2).getText() + "%s cm", String.format("%.1f", results.get("NA2"))));
        tv_head_MA1.setText(String.format((tv_head_MA1).getText() + "%s cm", String.format("%.1f", results.get("MA1"))));
        tv_head_MA2.setText(String.format((tv_head_MA2).getText() + "%s cm", String.format("%.1f", results.get("MA2"))));
        tv_head_SB_2.setText(String.format((tv_head_SB_2).getText() + "%s cm", String.format("%.1f", results.get("SB"))));
        tv_head_SB1.setText(String.format((tv_head_SB1).getText() + "%s cm", String.format("%.1f", results.get("SB1"))));
        tv_head_LBc.setText(String.format((tv_head_LBc).getText() + "%s cm", String.format("%.1f", results.get("LBc"))));
        tv_head_LBp.setText(String.format((tv_head_LBp).getText() + "%s cm", String.format("%.1f", results.get("LBp"))));
        tv_head_KB2.setText(String.format((tv_head_KB2).getText() + "%s cm", String.format("%.1f", results.get("KB2"))));
        tv_head_NB1.setText(String.format((tv_head_NB1).getText() + "%s cm", String.format("%.1f", results.get("NB1"))));
        tv_head_NB2.setText(String.format((tv_head_NB2).getText() + "%s cm", String.format("%.1f", results.get("NB2"))));
        tv_head_MB1.setText(String.format((tv_head_MB1).getText() + "%s cm", String.format("%.1f", results.get("MB1"))));
        tv_head_MB2.setText(String.format((tv_head_MB2).getText() + "%s cm", String.format("%.1f", results.get("MB2"))));

    }

    @SuppressLint({"DefaultLocale", "ResourceType"})
    private void displayResultsRoof_4() {
        TextView tv_headHk = findViewById(R.id.text_head_Hk);
        tv_headHk.setText(String.format("Wysokość kalenicy = %s cm", String.format("%.2f", results.get("HK"))));
        TextView tv_headHpk = findViewById(R.id.text_head_Hpk);
        tv_headHpk.setText(String.format("Wysokość płatwi kalenicowej = %s cm", String.format("%.2f", results.get("Hpk"))));
        TextView tv_headB = findViewById(R.id.text_head_B);
        tv_headB.setText(String.format("Okap połaci B: D = %s cm", String.format("%.2f", results.get("D"))));

        TextView tv_1_L = findViewById(R.id.text_1_L);
        tv_1_L.setText(String.format("Długość krokwi L = %s cm", String.format("%.2f", results.get("Dkr"))));
        TextView tv_1_alpha = findViewById(R.id.text_1_alpha);
        tv_1_alpha.setText(String.format("Kąt krokwi α = %s°", String.format("%.1f", results.get("alpha_A"))));
        TextView tv_1_N2 = findViewById(R.id.text_1_N2);
        tv_1_N2.setText(String.format("Długość do zaciosu N2 = %s cm", String.format("%.2f", results.get("N2_A"))));
        TextView tv_1_N1 = findViewById(R.id.text_1_N1);
        tv_1_N1.setText(String.format("Długość do zaciosu N1 = %s cm", String.format("%.2f", results.get("N1_A"))));

        TextView tv_2_L = findViewById(R.id.text_2_L);
        StringBuilder Dkr_As = new StringBuilder();
        for (int i = 0; i < results.get("no_kpA"); i++) {
            Dkr_As.append(String.format("%.1f; ", results.get("DKLs_A cm" + (i + 1))));
        }
        tv_2_L.setText("Długości kulawek L = [" + Dkr_As + "]");
        TextView tv_2_beta = findViewById(R.id.text_2_beta);
        tv_2_beta.setText(String.format("Kąt kulawki β = %s°", String.format("%.1f", results.get("beta_A"))));
        TextView tv_2_alpha = findViewById(R.id.text_2_alpha);
        tv_2_alpha.setText(String.format("Kąt kulawki α = %s°", String.format("%.1f", results.get("alpha_A"))));
        TextView tv_2_N2 = findViewById(R.id.text_2_N2);
        tv_2_N2.setText(String.format("Długość do zaciosu N2 = %s cm", String.format("%.2f", results.get("N2_A"))));
        TextView tv_2_N1 = findViewById(R.id.text_2_N1);
        tv_2_N1.setText(String.format("Długość do zaciosu N1 = %s cm", String.format("%.2f", results.get("N1_A"))));

        TextView tv_3_L = findViewById(R.id.text_3_L);
        tv_3_L.setText(String.format("Długość krokwi L = %s cm", String.format("%.2f", results.get("Lk"))));
        TextView tv_3_mi = findViewById(R.id.text_3_mi);
        tv_3_mi.setText(String.format("Kąt krokwi μ = %s°", String.format("%.1f", results.get("gamma"))));
        TextView tv_3_alpha = findViewById(R.id.text_3_alpha);
        tv_3_alpha.setText(String.format("Kąt zaciosu do połaci B: α = %s°", String.format("%.1f", results.get("fi"))));
        TextView tv_3_beta = findViewById(R.id.text_3_beta);
        tv_3_beta.setText(String.format("Kąt zaciosu do połaci A: β = %s°", String.format("%.1f", results.get("ni"))));
        TextView tv_3_delta = findViewById(R.id.text_3_delta);
        tv_3_delta.setText(String.format("Kąt fazowania do połaci B: δ = %s°", String.format("%.1f", results.get("ro"))));
        TextView tv_3_ro = findViewById(R.id.text_3_psi);
        tv_3_ro.setText(String.format("Kąt fazowania do połaci A: ψ = %s°", String.format("%.1f", results.get("psi"))));

        TextView tv_4_L = findViewById(R.id.text_4_L);
        tv_4_L.setText(String.format("Długość krokwi L = %s cm", String.format("%.2f", results.get("L"))));
        TextView tv_4_beta = findViewById(R.id.text_4_beta);
        tv_4_beta.setText(String.format("Kąt krokwi β = %s°", String.format("%.1f", results.get("beta_B"))));
        TextView tv_4_alpha = findViewById(R.id.text_4_alpha);
        tv_4_alpha.setText(String.format("Kąt krokwi α = %s°", String.format("%.1f", results.get("alpha_B"))));
        TextView tv_4_N2 = findViewById(R.id.text_4_N2);
        tv_4_N2.setText(String.format("Długość do zaciosu N2 = %s cm", String.format("%.2f", results.get("N2_B"))));
        TextView tv_4_N1 = findViewById(R.id.text_4_N1);
        tv_4_N1.setText(String.format("Długość do zaciosu N1 = %s cm", String.format("%.2f", results.get("N1_B"))));

        TextView tv_5_L = findViewById(R.id.text_5_L);
        StringBuilder Dkr_Bs = new StringBuilder();
        for (int i = 0; i < results.get("no_kpB"); i++) {
            Dkr_Bs.append(String.format("%.1f; ", results.get("DKLs_B cm" + (i + 1))));
        }
        tv_5_L.setText("Długości kulawek L = [" + Dkr_Bs + "]");
        TextView tv_5_beta = findViewById(R.id.text_5_beta);
        tv_5_beta.setText(String.format("Kąt krokwi β = %s°", String.format("%.1f", results.get("beta_B"))));
        TextView tv_5_alpha = findViewById(R.id.text_5_alpha);
        tv_5_alpha.setText(String.format("Kąt krokwi α = %s°", String.format("%.1f", results.get("alpha_B"))));
        TextView tv_5_N2 = findViewById(R.id.text_5_N2);
        tv_5_N2.setText(String.format("Długość do zaciosu N2 = %s cm", String.format("%.2f", results.get("N2_B"))));
        TextView tv_5_N1 = findViewById(R.id.text_5_N1);
        tv_5_N1.setText(String.format("Długość do zaciosu N1 = %s cm", String.format("%.2f", results.get("N1_B"))));
    }

}











