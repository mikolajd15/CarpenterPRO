package com.example.android101;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Objects;

public class ResultsActivity extends AppCompatActivity {
    int roof_type;
    HashMap<String, Double> results;
    private int numberOfDynamicEdtS_A = 0;
    private int numberOfDynamicEdtS_B = 0;

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ImageView roof_image_view_result = (ImageView) findViewById(R.id.iv_roof4_image_1);
        // Get the Intent that started this activity
        Intent intent = getIntent();
        results = (HashMap<String, Double>) intent.getSerializableExtra("EXTRA_ROOF1_RESULTS_MAP");
        roof_type = intent.getIntExtra("ROOF_TYPE", 0);

        if (roof_type == 1) {
            roof_image_view_result.setImageDrawable(getResources().getDrawable(R.drawable.jednospadowy_krokwia, getApplicationContext().getTheme()));
            setContentView(R.layout.activity_result_roof_1);
            displayResultsRoof_1_or_2();
        } else if (roof_type == 2) {
            roof_image_view_result.setImageDrawable(getResources().getDrawable(R.drawable.dwuspadowy_symetryczny_krokwia, getApplicationContext().getTheme()));
            setContentView(R.layout.activity_result_roof_1);
            displayResultsRoof_1_or_2();
        } else if (roof_type == 3) {
            roof_image_view_result.setImageDrawable(getResources().getDrawable(R.drawable.dwuspadowy_niesymetryczny_krokwia_a, getApplicationContext().getTheme()));
            setContentView(R.layout.activity_result_roof_1);
            displayResultsRoof_3();
        } else if (roof_type == 4) {
            //roof_image_view_result.setImageDrawable(getResources().getDrawable(R.drawable.polac_a_krokwie_zwykle, getApplicationContext().getTheme()));
            setContentView(R.layout.activity_result_roof_4);
            displayResultsRoof_4();
        } else {
            throw new IllegalArgumentException("Incorrect roof type: " + roof_type);
        }
    }

    @SuppressLint("DefaultLocale")
    private void Add_Line(String A_or_B) {
        TableLayout tableLayoutDown = (TableLayout) findViewById(R.id.results_table_layout1);
        // add edittext
        EditText dynamicEditText = new EditText(this);
        TableRow.LayoutParams params = new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        TableRow newTableRow = new TableRow(this);
        newTableRow.setLayoutParams(params);
        tableLayoutDown.addView(newTableRow);
        dynamicEditText.setLayoutParams(params);

        if (Objects.equals(A_or_B, "A")) {
            String field_name = "\t\tDKLs_A" + (numberOfDynamicEdtS_A + 1);
            dynamicEditText.setText(String.format(field_name + " = %s", String.format("%.2f", results.get(field_name))));
            dynamicEditText.setId(300 + numberOfDynamicEdtS_A);
            numberOfDynamicEdtS_A++;
        } else if (Objects.equals(A_or_B, "B")) {
            String field_name = "\t\tDKLs_B" + (numberOfDynamicEdtS_B + 1);
            dynamicEditText.setText(String.format(field_name + " = %s", String.format("%.2f", results.get(field_name))));
            dynamicEditText.setId(400 + numberOfDynamicEdtS_B);
            numberOfDynamicEdtS_B++;
        }
        newTableRow.addView(dynamicEditText);
    }

    private void addImage(int drawable_id) {
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.results_linear_layout);
        ImageView dynamicImage = new ImageView(this);

        dynamicImage.setImageDrawable(getResources().getDrawable(drawable_id, getApplicationContext().getTheme()));
        linearLayout.addView(dynamicImage);
    }

    @SuppressLint({"DefaultLocale", "ResourceType"})
    private void displayResultsRoof_4() {
        TextView tv_headHk = findViewById(R.id.text_head_Hk);
        tv_headHk.setText(String.format("Wysokość kalenicy = %s", String.format("%.2f", results.get("HK"))));
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

        ((TextView) findViewById(R.id.roof1_result_30)).setVisibility(View.INVISIBLE);
        ((TextView) findViewById(R.id.roof1_result_31)).setVisibility(View.INVISIBLE);
        ((TextView) findViewById(R.id.roof1_result_32)).setVisibility(View.INVISIBLE);
        ((TextView) findViewById(R.id.roof1_result_40)).setVisibility(View.INVISIBLE);
        ((TextView) findViewById(R.id.roof1_result_41)).setVisibility(View.INVISIBLE);
    }

}











