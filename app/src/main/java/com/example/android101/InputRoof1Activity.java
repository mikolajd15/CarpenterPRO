package com.example.android101;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import es.dmoral.toasty.Toasty;

public class InputRoof1Activity extends AppCompatActivity {

    EditText edt_theta, edt_B, edt_A, edt_D, edt_E, edt_C, edt_S,
            edt_s_mu, edt_g_pk, edt_g_kr, edt_s_kr, edt_fpk, edt_k_max;
    EditText edt_alpha, edt_beta, edt_A1, edt_B1, edt_g_mu, edt_SB;
    EditText edt_unused_in_roof_1_and_2, edt_unused_in_roof_2;

    ArrayList<EditText> editTextList;
    Button countButton;
    int roof_type;

    private void hideKeyboard() {
        LinearLayout mainLayout;
        mainLayout = (LinearLayout) findViewById(R.id.inputs_lin_layout);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
    }

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

    private void dynamicTextColorChanger() {
        boolean alpha_and_beta_are_filled = !TextUtils.isEmpty(edt_alpha.getText()) && !TextUtils.isEmpty(edt_beta.getText());
        if (alpha_and_beta_are_filled) {
            double alpha_value = Double.parseDouble(edt_alpha.getText().toString());
            double beta_value = Double.parseDouble(edt_beta.getText().toString());
            if (alpha_value >= beta_value) {
                edt_alpha.setTextColor(getResources().getColor(R.color.red));
                edt_beta.setTextColor(getResources().getColor(R.color.red));
            } else {
                if (alpha_value <= 0 || alpha_value >= 90) {
                    edt_alpha.setTextColor(getResources().getColor(R.color.red));
                } else {
                    edt_alpha.setTextColor(getResources().getColor(R.color.black));
                }
                if (beta_value <= 0 || beta_value >= 90) {
                    edt_beta.setTextColor(getResources().getColor(R.color.red));
                } else {
                    edt_beta.setTextColor(getResources().getColor(R.color.black));
                }
            }
        }
    }

    private final TextWatcher watcherForTheta = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override//TODO dodaj sprawdzenie czy nie jest kropką ani przecinkiem
        public void afterTextChanged(Editable editable) {
            if (!TextUtils.isEmpty(edt_theta.getText())) {
                if (TextUtils.equals(edt_theta.getText(), ".")) {
                    edt_theta.setText("0.");
                    edt_theta.setSelection(2);
                }
                double value = Double.parseDouble(edt_theta.getText().toString());
                if (value <= 0 || value >= 90) {
                    edt_theta.setTextColor(getResources().getColor(R.color.red));
                } else {
                    edt_theta.setTextColor(getResources().getColor(R.color.black));
                }
            }
        }
    };
    private final TextWatcher watcherForAlpha = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (TextUtils.equals(edt_alpha.getText(), ".")) {
                edt_alpha.setText("0.");
                edt_alpha.setSelection(2);
            }
            dynamicTextColorChanger();
        }
    };
    private final TextWatcher watcherForBeta = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            if (TextUtils.equals(edt_beta.getText(), ".")) {
                edt_beta.setText("0.");
                edt_beta.setSelection(2);
            }
            dynamicTextColorChanger();
        }
    };

    @SuppressLint("UseCompatLoadingForDrawables")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_roof_1);

        Intent intent = getIntent();
        roof_type = intent.getIntExtra("ROOF_TYPE", 0);

        setImages(roof_type);
        initializeEdts(roof_type);

        // set button to disabled initially
        countButton = findViewById(R.id.button_roof1_count);
        countButton.setEnabled(false);
    }

    private void initializeEdts(int roof_type) {
        // common text fields init
        edt_A = findViewById(R.id.roof1_input_00);
        edt_A.setHint("Podaj A");
        edt_B = findViewById(R.id.roof1_input_01);
        edt_B.setHint("Podaj B");
        edt_D = findViewById(R.id.roof1_input_10);
        edt_D.setHint("Podaj D");
        edt_s_mu = findViewById(R.id.roof1_input_30);
        edt_s_mu.setHint("Podaj s_mu");
        edt_g_pk = findViewById(R.id.roof1_input_31);
        edt_g_pk.setHint("Podaj g_pk");
        edt_g_kr = findViewById(R.id.roof1_input_50);
        edt_g_kr.setHint("Podaj g_kr");
        edt_s_kr = findViewById(R.id.roof1_input_51);
        edt_s_kr.setHint("Podaj s_kr");


        if (roof_type == 1 || roof_type == 2) {

            edt_unused_in_roof_1_and_2 = findViewById(R.id.roof1_input_41);
            edt_unused_in_roof_1_and_2.setVisibility(View.GONE);

            edt_S = findViewById(R.id.roof1_input_11);
            edt_S.setHint("Podaj S");
            edt_theta = findViewById(R.id.roof1_input_20);
            edt_theta.addTextChangedListener(watcherForTheta);
            edt_theta.setHint("Podaj theta");
            edt_C = findViewById(R.id.roof1_input_21);
            edt_C.setHint("Podaj C");
            edt_fpk = findViewById(R.id.roof1_input_60);
            edt_fpk.setHint("Podaj fpk");
            edt_k_max = findViewById(R.id.roof1_input_61);
            edt_k_max.setHint("Podaj k_max");

            // initialize edit Texts array
            editTextList = new ArrayList<>(Arrays.asList(edt_theta, edt_B, edt_A, edt_D, edt_C, edt_S,
                    edt_s_mu, edt_g_pk, edt_s_kr, edt_g_kr, edt_fpk, edt_k_max));


            if (roof_type == 1) {
                edt_E = findViewById(R.id.roof1_input_40);
                edt_E.setHint("Podaj E");
                editTextList.add(edt_E);

            } else /* roof 2*/ {
                edt_unused_in_roof_2 = findViewById(R.id.roof1_input_40);
                edt_unused_in_roof_2.setVisibility(View.GONE);
            }

        } else if (roof_type == 3) {
            edt_alpha = findViewById(R.id.roof1_input_20);
            edt_alpha.addTextChangedListener(watcherForAlpha);
            edt_alpha.setHint("Podaj alpha");
            edt_beta = findViewById(R.id.roof1_input_21);
            edt_beta.addTextChangedListener(watcherForBeta);
            edt_beta.setHint("Podaj beta");
            edt_A1 = findViewById(R.id.roof1_input_60);
            edt_A1.setHint("Podaj A1");
            edt_B1 = findViewById(R.id.roof1_input_61);
            edt_B1.setHint("Podaj B1");
            edt_g_mu = findViewById(R.id.roof1_input_41);
            edt_g_mu.setHint("Podaj g_mu");
            edt_SB = findViewById(R.id.roof1_input_11);
            edt_SB.setHint("Podaj SB");
            edt_E = findViewById(R.id.roof1_input_40);
            edt_E.setHint("Podaj E");
            // initialize edit Texts array
            editTextList = new ArrayList<>(Arrays.asList(edt_alpha, edt_beta, edt_A1, edt_B1, edt_g_mu, edt_SB, edt_B, edt_A, edt_D,
                    edt_s_mu, edt_g_pk, edt_s_kr, edt_g_kr, edt_E));
        } else {
            throw new IllegalArgumentException("Incorrect roof_type in initialization of Edts!" + roof_type);
        }

        /* add text watcher to edts */
        for (EditText edt : editTextList) {
            edt.addTextChangedListener(watcher);
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void setImages(int roof_type) {

        ImageView roof_image_view_top = findViewById(R.id.iv_roof_image_top);
        ImageView roof_image_view_bot = findViewById(R.id.iv_roof_image_bot);
        if (roof_type == 1) {
            roof_image_view_top.setImageDrawable(getResources().getDrawable(R.drawable.jednospadowy_budynek, getApplicationContext().getTheme()));
            roof_image_view_bot.setImageDrawable(getResources().getDrawable(R.drawable.jednospadowy_rzut_dachu, getApplicationContext().getTheme()));
        } else if (roof_type == 2) {
            roof_image_view_top.setImageDrawable(getResources().getDrawable(R.drawable.dwuspadowy_symetryczny_budynek, getApplicationContext().getTheme()));
            roof_image_view_bot.setImageDrawable(getResources().getDrawable(R.drawable.dwuspadowy_symetryczny_rzut_krokwi, getApplicationContext().getTheme()));
        } else if (roof_type == 3) {
            roof_image_view_top.setImageDrawable(getResources().getDrawable(R.drawable.dwuspadowy_niesymetryczny_budynek, getApplicationContext().getTheme()));
            //TODO zmien obrazek na niesymetryczny_rzut_krokwi
            roof_image_view_bot.setImageDrawable(getResources().getDrawable(R.drawable.dwuspadowy_symetryczny_rzut_krokwi, getApplicationContext().getTheme()));
        } else {
            throw new IllegalArgumentException("Incorrect roof type: " + roof_type);
        }
    }

    private boolean allFieldsAreFilled() {
        for (EditText edt : editTextList) {
            if (TextUtils.isEmpty(edt.getText()))
                return false;
        }
        return true;
    }

    @NonNull
    private HashMap<String, Double> prepareInputsMap(int roof_type) {
        HashMap<String, Double> inputDoublesListMap = new HashMap<>();

        inputDoublesListMap.put("B", Double.parseDouble(edt_B.getText().toString()));
        inputDoublesListMap.put("A", Double.parseDouble(edt_A.getText().toString()));
        inputDoublesListMap.put("D", Double.parseDouble(edt_D.getText().toString()));
        inputDoublesListMap.put("s_mu", Double.parseDouble(edt_s_mu.getText().toString()));
        inputDoublesListMap.put("g_pk", Double.parseDouble(edt_g_pk.getText().toString()));
        inputDoublesListMap.put("s_kr", Double.parseDouble(edt_s_kr.getText().toString()));
        inputDoublesListMap.put("g_kr", Double.parseDouble(edt_g_kr.getText().toString()));

        if (roof_type == 1 || roof_type == 2) {

            inputDoublesListMap.put("theta", Double.parseDouble(edt_theta.getText().toString()));
            inputDoublesListMap.put("C", Double.parseDouble(edt_C.getText().toString()));
            inputDoublesListMap.put("S", Double.parseDouble(edt_S.getText().toString()));
            inputDoublesListMap.put("fpk", Double.parseDouble(edt_fpk.getText().toString()));
            inputDoublesListMap.put("k_max", Double.parseDouble(edt_k_max.getText().toString()));

            if (roof_type == 1) {
                inputDoublesListMap.put("E", Double.parseDouble(edt_E.getText().toString()));
            }
        }

        if (roof_type == 3) {
            inputDoublesListMap.put("alpha", Double.parseDouble(edt_alpha.getText().toString()));
            inputDoublesListMap.put("beta", Double.parseDouble(edt_beta.getText().toString()));
            inputDoublesListMap.put("A1", Double.parseDouble(edt_A1.getText().toString()));
            inputDoublesListMap.put("B1", Double.parseDouble(edt_B1.getText().toString()));
            inputDoublesListMap.put("SB", Double.parseDouble(edt_SB.getText().toString()));
            inputDoublesListMap.put("g_mu", Double.parseDouble(edt_g_mu.getText().toString()));
            inputDoublesListMap.put("E", Double.parseDouble(edt_E.getText().toString()));
        }

        return inputDoublesListMap;
    }

    private boolean fieldsAreFilledCorrectly(int roof_type) {
        if (roof_type == 1 || roof_type == 2) {
            double theta_value = Double.parseDouble(edt_theta.getText().toString());
            if (theta_value <= 0 || theta_value >= 90) {
                Toasty.warning(getApplicationContext(), "Niepoprawna wartość dla theta: " + theta_value, Toast.LENGTH_LONG, true).show();
                ((ScrollView) findViewById(R.id.scroll_view_inputs)).smoothScrollTo(edt_theta.getScrollX(), edt_theta.getScrollY());
                return false;
            }
        } else if (roof_type == 3) {
            double alpha_value = Double.parseDouble(edt_alpha.getText().toString());
            double beta_value = Double.parseDouble(edt_beta.getText().toString());
            if (alpha_value <= 0 || alpha_value >= 90) {
                Toasty.warning(getApplicationContext(), "Niepoprawna wartość dla alpha: " + alpha_value, Toast.LENGTH_SHORT, true).show();
                ((ScrollView) findViewById(R.id.scroll_view_inputs)).smoothScrollTo(edt_alpha.getScrollX(), edt_alpha.getScrollY());
                return false;
            }
            if (beta_value <= 0 || beta_value >= 90) {
                Toasty.warning(getApplicationContext(), "Niepoprawna wartość dla beta: " + beta_value, Toast.LENGTH_SHORT, true).show();
                ((ScrollView) findViewById(R.id.scroll_view_inputs)).smoothScrollTo(edt_beta.getScrollX(), edt_beta.getScrollY());
                return false;
            }
            if (alpha_value >= beta_value) {
                Toasty.warning(getApplicationContext(), "Alpha musi być mniejsze od beta", Toast.LENGTH_LONG, true).show();
                ((ScrollView) findViewById(R.id.scroll_view_inputs)).smoothScrollTo(edt_alpha.getScrollX(), edt_alpha.getScrollY());
                return false;
            }

        } else {
            throw new IllegalArgumentException("Niepoprawna wartość roof_type:" + roof_type);
        }
        return true;
    }

    public void showResultsRoof1(View view) {

        if (fieldsAreFilledCorrectly(roof_type)) {
            // Create Intent and list objects
            Intent intent = new Intent(this, ResultRoof1Activity.class);
            intent.putExtra("ROOF_TYPE", roof_type);

            // Prepare Inputs map for Carpenter
            HashMap<String, Double> inputDoublesListMap = prepareInputsMap(roof_type);
            Carpenter carpenter = new Carpenter(inputDoublesListMap, roof_type);

            // Calculate the result using Roofer class
            HashMap<String, Double> results = carpenter.prepareResults(roof_type);

            // Pass the results and open next activity
            intent.putExtra("EXTRA_ROOF1_RESULTS_MAP", results);
            startActivity(intent);
        } else {
            hideKeyboard();
        }
    }
}