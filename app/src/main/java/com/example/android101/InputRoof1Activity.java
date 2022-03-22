package com.example.android101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InputRoof1Activity extends AppCompatActivity {

    EditText edt_theta, edt_B, edt_A, edt_D, edt_E, edt_C, edt_S,
            edt_m_d, edt_m_w, edt_pp_d, edt_pp_w,
            edt_pk_d, edt_pk_w, edt_k_d, edt_k_w,
            edt_fpk, edt_k_max;

    List<EditText> editTextList;
    Button countButton;
    int roof_type;

    private final TextWatcher watcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            countButton.setEnabled(allFieldsAreFilled());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_roof_1);
        Intent intent = getIntent();
        roof_type = intent.getIntExtra("ROOF_TYPE", 0);

        ImageView roof_image_view = (ImageView) findViewById(R.id.iv_roof_image);
        if (roof_type == 1) {
            roof_image_view.setImageDrawable(getResources().getDrawable(R.drawable.jednospadowy, getApplicationContext().getTheme()));
        } else if (roof_type == 2) {
            roof_image_view.setImageDrawable(getResources().getDrawable(R.drawable.dwuspadowy, getApplicationContext().getTheme()));
        } else {
            throw new IllegalArgumentException("Incorrect roof type: " + roof_type);
        }

        // text fields init
        edt_theta = findViewById(R.id.roof1_input_Theta);
        edt_B = findViewById(R.id.roof1_input_B);
        edt_A = findViewById(R.id.roof1_input_A);
        edt_D = findViewById(R.id.roof1_input_D);
        edt_E = findViewById(R.id.roof1_input_E);
        edt_C = findViewById(R.id.roof1_input_C);
        edt_S = findViewById(R.id.roof1_input_S);
        edt_m_d = findViewById(R.id.roof1_input_m_d);
        edt_m_w = findViewById(R.id.roof1_input_m_w);
        edt_pp_d = findViewById(R.id.roof1_input_pp_d);
        edt_pp_w = findViewById(R.id.roof1_input_pp_w);
        edt_pk_d = findViewById(R.id.roof1_input_pk_d);
        edt_pk_w = findViewById(R.id.roof1_input_pk_w);
        edt_k_d = findViewById(R.id.roof1_input_k_d);
        edt_k_w = findViewById(R.id.roof1_input_k_w);
        edt_fpk = findViewById(R.id.roof1_input_fpk);
        edt_k_max = findViewById(R.id.roof1_input_k_max);

        // set button to disabled initially
        countButton = findViewById(R.id.button_roof1_count);
        countButton.setEnabled(false);

        // initialize edit Texts array
        editTextList = Arrays.asList(edt_theta, edt_B, edt_A, edt_D, edt_E, edt_C, edt_S,
                edt_m_d, edt_m_w, edt_pp_d, edt_pp_w, edt_pk_d, edt_pk_w, edt_k_d, edt_k_w,
                edt_fpk, edt_k_max);

        /* add text watcher to edts */
        for (EditText edt : editTextList) {
            edt.addTextChangedListener(watcher);
        }
    }

    private boolean allFieldsAreFilled() {
        for (EditText edt : editTextList) {
            if (TextUtils.isEmpty(edt.getText()))
                return false;
        }

        return true;
    }

    public void showResultsRoof1(View view) {

        // Create Intent and list objects
        Intent intent = new Intent(this, ResultRoof1Activity.class);
        List<Double> inputDoublesList = new ArrayList<>();

        // add inputs from edts to list
        for (EditText edt : editTextList) {
            inputDoublesList.add(Double.parseDouble(edt.getText().toString()));
        }
        Carpenter carpenter = new Carpenter(inputDoublesList);

        // Calculate the result using Roofer class
        HashMap<String, Double> results = carpenter.prepareResults(roof_type);

        // Pass the results and open next activity
        intent.putExtra("EXTRA_ROOF1_RESULTS_MAP", results);
        startActivity(intent);
    }
}