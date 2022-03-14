package com.example.android101;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class InputRoof1Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_roof_1);
    }

    public void showResultsRoof1(View view) {


        // Create Intent and Bundle objects
        Intent intent = new Intent(this, ResultRoof1Activity.class);
        Bundle inputValues = new Bundle();

        // Capture the layout's TextView and get users input theta
        EditText edt_theta = (EditText) findViewById(R.id.roof1_input_theta);

        // Check if text is empty
        if (TextUtils.isEmpty(edt_theta.getText())) {
            // TODO monit o brakującej wartości
        } else {
            float input_theta = Float.parseFloat(edt_theta.getText().toString());
            // Calculate the result using Roofer class
            float result_theta = Carpenter.countRoofValues(input_theta);
            inputValues.putFloat("EXTRA_ROOF1_THETA", result_theta);
        }

        intent.putExtras(inputValues);
        startActivity(intent);
    }
}