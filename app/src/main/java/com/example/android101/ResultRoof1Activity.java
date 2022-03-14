package com.example.android101;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class ResultRoof1Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_roof_1);

        // Show the result
        TextView textView = findViewById(R.id.response);
        textView.setText(String.valueOf(result));
    }

}