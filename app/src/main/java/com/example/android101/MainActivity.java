package com.example.android101;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Roof1 button */
    public void openRoof1View(View view){
        Intent intent = new Intent(this, UserInputsActivity.class);
        intent.putExtra("ROOF_TYPE", 1);
        startActivity(intent);
    }

    /** Called when the user taps the Roof2 button */
    public void openRoof2View(View view){
        Intent intent = new Intent(this, UserInputsActivity.class);
        intent.putExtra("ROOF_TYPE", 2);
        startActivity(intent);
    }

    /** Called when the user taps the Roof3 button */
    public void openRoof3View(View view){
        Intent intent = new Intent(this, UserInputsActivity.class);
        intent.putExtra("ROOF_TYPE", 3);
        startActivity(intent);
    }

    /** Called when the user taps the Roof4 button */
    public void openRoof4View(View view){
        Intent intent = new Intent(this, UserInputsActivity.class);
        intent.putExtra("ROOF_TYPE", 4);
        startActivity(intent);
    }

    public void openLoginScreen(View view){
        Intent intent = new Intent(this, LoginMainActivity.class);
        startActivity(intent);
    }
}