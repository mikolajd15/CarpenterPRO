package com.example.android101;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import es.dmoral.toasty.Toasty;

public class LoginMainActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private String email, password;
    private final String URL = "http://91.223.167.210:99/login/login.php"; //tutaj musi byc adres ip bo emuator nie dziala na localhost

    private void hideKeyboard() {
        LinearLayout mainLayout;
        mainLayout = (LinearLayout) findViewById(R.id.login_main_linear_layout);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = password = "";
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
    }

    public void login(View view) {
        hideKeyboard();
        email = etEmail.getText().toString().trim();
        password = etPassword.getText().toString().trim();
        if (!email.equals("") && !password.equals("")) {
            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    Log.d("res", response);
                    if (response.equals("\nsuccess")) {
                        Toasty.success(getApplicationContext(), "Poprawne logowanie", Toast.LENGTH_LONG, true).show();

                        Intent intent = new Intent(LoginMainActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else if (response.equals("\nfailure")) {
                        Toasty.error(getApplicationContext(), "Niepoprawny Login Id / Hasło", Toast.LENGTH_LONG, true).show();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(LoginMainActivity.this, error.toString().trim(), Toast.LENGTH_SHORT).show();
                }
            }) {
                @Override
                protected Map<String, String> getParams() throws AuthFailureError {
                    Map<String, String> data = new HashMap<>();
                    data.put("email", email);
                    data.put("password", password);
                    return data;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
            requestQueue.add(stringRequest);
        } else {
            Toasty.warning(getApplicationContext(), "Pola nie mogą być puste!", Toast.LENGTH_LONG, true).show();
        }
    }

    public void register(View view) {
        Intent intent = new Intent(this, RegisterActivity.class);
        startActivity(intent);
        finish();
    }
}