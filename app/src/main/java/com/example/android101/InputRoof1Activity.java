package com.example.android101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Arrays;
import java.util.List;

public class InputRoof1Activity extends AppCompatActivity {

    EditText edt_theta, edt_B, edt_A, edt_D, edt_E, edt_C, edt_S;
    List<EditText> editTextList;
    Button countButton;

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

        // text fields init
        edt_theta = findViewById(R.id.roof1_input_Theta);
        edt_B = findViewById(R.id.roof1_input_B);
        edt_A = findViewById(R.id.roof1_input_A);
        edt_D = findViewById(R.id.roof1_input_D);
        edt_E = findViewById(R.id.roof1_input_E);
        edt_C = findViewById(R.id.roof1_input_C);
        edt_S = findViewById(R.id.roof1_input_S);

        // set button to disabled initially
        countButton = findViewById(R.id.button_roof1_count);
        countButton.setEnabled(false);

        // initialize edit Texts array
        editTextList = Arrays.asList(edt_theta, edt_B, edt_A, edt_D, edt_E, edt_C, edt_S);

        /* add text watcher to edts */
        for (EditText edt : editTextList)
        {
            edt.addTextChangedListener(watcher);
        }
    }

    private boolean allFieldsAreFilled() {
        for (EditText edt : editTextList)
        {
            if(TextUtils.isEmpty(edt.getText()))
                return false;
        }

        return true;
    }


    public void showResultsRoof1(View view) {

        // Create Intent and Bundle objects
        Intent intent = new Intent(this, ResultRoof1Activity.class);
        Bundle inputsBundle = new Bundle();

        // add inputs from edts to Bundle
        for (EditText edt : editTextList)
        {
            //TODO create list of floats and pass it to Carpenter
        }
        float input_theta = Float.parseFloat(edt_theta.getText().toString());
        float input_B = Float.parseFloat(edt_B.getText().toString());
        float input_A = Float.parseFloat(edt_A.getText().toString());
        float input_D = Float.parseFloat(edt_D.getText().toString());
        float input_E = Float.parseFloat(edt_E.getText().toString());
        float input_C = Float.parseFloat(edt_C.getText().toString());
        float input_S = Float.parseFloat(edt_S.getText().toString());

        // Calculate the result using Roofer class
        float result = Carpenter.countRoofValues(input_theta, input_B);
        inputsBundle.putFloat("EXTRA_ROOF1_THETA", result);

        intent.putExtras(inputsBundle);
        startActivity(intent);
    }
}