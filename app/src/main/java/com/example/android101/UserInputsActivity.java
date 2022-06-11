package com.example.android101;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Objects;

import es.dmoral.toasty.Toasty;

//TODO wyświetlanie informacji o polach
public class UserInputsActivity extends AppCompatActivity {

    EditText edt_theta, edt_B, edt_A, edt_D, edt_E, edt_C, edt_S,
            edt_s_mu, edt_g_pk, edt_g_kr, edt_s_kr, edt_fpk, edt_k_max;
    EditText edt_alpha, edt_beta, edt_A1, edt_B1, edt_g_mu, edt_SB;
    EditText edt_unused_in_roof_1_and_2, edt_unused_in_roof_2, edt_unused_in_roof_4;
    EditText edt_SA, edt_g_kk, edt_no_kpA, edt_no_kpB;
    ArrayList<EditText> editTextList;
    Button countButton;
    int roof_type;
    private int numberOfDynamicEdtS_A = 0;
    private int numberOfDynamicEdtS_B = 0;
    private final int NO_KPS_LIMIT = 10;
    private boolean roof4_results_allowed = false;


    private void onClick_btnroof4() {
        double value_A = Double.parseDouble(edt_no_kpA.getText().toString());
        double value_B = Double.parseDouble(edt_no_kpB.getText().toString());
        if (value_A <= 0 || value_A >= NO_KPS_LIMIT) {
            Toasty.warning(getApplicationContext(), "Niepoprawna wartość dla kpA: " + value_A, Toast.LENGTH_LONG, true).show();
        } else if (value_B <= 0 || value_B >= NO_KPS_LIMIT) {
            Toasty.warning(getApplicationContext(), "Niepoprawna wartość dla kpB: " + value_B, Toast.LENGTH_LONG, true).show();
        } else {
            countButton.setEnabled(false);
            countButton.setText("Wylicz kąty");
            roof4_results_allowed = true;

            for (int i = 0; i < value_A; i++) {
                Add_Line("A");
            }
            for (int i = 0; i < value_B; i++) {
                Add_Line("B");
            }

            ((ScrollView) findViewById(R.id.scroll_view_inputs)).fullScroll(View.FOCUS_DOWN);

        }

    }

    private void Add_Line(String A_or_B) {
        TableLayout tableLayoutDown = (TableLayout) findViewById(R.id.table_layout_down);
        // add edittext
        EditText dynamicEditText = new EditText(this);
        TableRow.LayoutParams params = new TableRow.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        TableRow newTableRow = new TableRow(this);
        newTableRow.setLayoutParams(params);
        tableLayoutDown.addView(newTableRow);
        dynamicEditText.setLayoutParams(params);

        if (Objects.equals(A_or_B, "A")) {
            dynamicEditText.setHint("Podaj wartość dla A" + (numberOfDynamicEdtS_A + 1));
            dynamicEditText.setId(100 + numberOfDynamicEdtS_A);
            numberOfDynamicEdtS_A++;
        } else if (Objects.equals(A_or_B, "B")) {
            dynamicEditText.setHint("Podaj wartość dla B" + (numberOfDynamicEdtS_B + 1));
            dynamicEditText.setId(200 + numberOfDynamicEdtS_B);
            numberOfDynamicEdtS_B++;
        }
        editTextList.add(dynamicEditText);
        dynamicEditText.addTextChangedListener(allFieldsAreFilledWatcher);
        newTableRow.addView(dynamicEditText);
    }

    private void hideKeyboard() {
        LinearLayout mainLayout;
        mainLayout = (LinearLayout) findViewById(R.id.inputs_lin_layout);
        InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mainLayout.getWindowToken(), 0);
    }

    private final TextWatcher allFieldsAreFilledWatcher = new TextWatcher() {
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

        @Override
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
    private final TextWatcher watcherForNoKps = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            EditText editText;
            if (editable == edt_no_kpA.getEditableText()) {
                editText = edt_no_kpA;
            } else if (editable == edt_no_kpB.getEditableText()) {
                editText = edt_no_kpB;
            } else {
                throw new IllegalArgumentException("Incorrect EditText attached" + editable.toString());
            }

            if (!TextUtils.isEmpty(editText.getText()) && !TextUtils.isEmpty(editText.getText())) {
                double value = Double.parseDouble(editText.getText().toString());
                if (value <= 0 || value >= NO_KPS_LIMIT) {
                    editText.setTextColor(getResources().getColor(R.color.red));
                } else {
                    editText.setTextColor(getResources().getColor(R.color.black));
                }
            }
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
        if (roof_type == 4) {
            countButton.setText("Zatwierdz wartosci");
        }
    }

    @SuppressLint("ResourceType")
    private void initializeEdts(int roof_type) {
        // common text fields init
        edt_A = findViewById(R.id.roof1_input_00);
        edt_A.setHint("Podaj A");
        edt_s_mu = findViewById(R.id.roof1_input_30);
        edt_s_mu.setHint("Podaj s_mu");
        edt_g_pk = findViewById(R.id.roof1_input_31);
        edt_g_pk.setHint("Podaj g_pk");
        edt_g_kr = findViewById(R.id.roof1_input_50);
        edt_g_kr.setHint("Podaj g_kr");
        edt_s_kr = findViewById(R.id.roof1_input_51);
        edt_s_kr.setHint("Podaj s_kr");

        if (roof_type == 1 || roof_type == 2 || roof_type == 3) {
            edt_B = findViewById(R.id.roof1_input_01);
            edt_B.setHint("Podaj B");
            edt_D = findViewById(R.id.roof1_input_10);
            edt_D.setHint("Podaj D");
        }

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
        } else if (roof_type == 4) {
            edt_SA = findViewById(R.id.roof1_input_01);
            edt_SA.setHint("Podaj SA");
            edt_alpha = findViewById(R.id.roof1_input_10);
            edt_alpha.addTextChangedListener(watcherForAlpha);
            edt_alpha.setHint("Podaj alpha_p");
            edt_beta = findViewById(R.id.roof1_input_11);
            edt_beta.addTextChangedListener(watcherForBeta);
            edt_beta.setHint("Podaj beta_p");
            edt_E = findViewById(R.id.roof1_input_20);
            edt_E.setHint("Podaj E");
            edt_C = findViewById(R.id.roof1_input_21);
            edt_C.setHint("Podaj C");
            edt_no_kpA = findViewById(R.id.roof1_input_60);
            edt_no_kpA.addTextChangedListener(watcherForNoKps);
            edt_no_kpA.setHint("Podaj no_kpA");
            edt_no_kpB = findViewById(R.id.roof1_input_61);
            edt_no_kpB.addTextChangedListener(watcherForNoKps);
            edt_no_kpB.setHint("Podaj no_kpB");
            edt_g_kk = findViewById(R.id.roof1_input_40);
            edt_g_kk.setHint("Podaj g_kk");
            edt_unused_in_roof_4 = findViewById(R.id.roof1_input_41);
            edt_unused_in_roof_4.setVisibility(View.GONE);
            // initialize edit Texts array
            editTextList = new ArrayList<>(Arrays.asList(edt_A, edt_g_pk, edt_alpha, edt_beta, edt_s_mu,
                    edt_SA, edt_s_kr, edt_E, edt_C, edt_no_kpA, edt_no_kpB, edt_g_kr, edt_g_kk
            ));

        } else {
            throw new IllegalArgumentException("Incorrect roof_type in initialization of Edts!" + roof_type);
        }

        /* add text allFieldsAreFilledWatcher to edts */
        for (
                EditText edt : editTextList) {
            edt.addTextChangedListener(allFieldsAreFilledWatcher);
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
            roof_image_view_bot.setImageDrawable(getResources().getDrawable(R.drawable.dwuspadowy_symetryczny_rzut_krokwi, getApplicationContext().getTheme()));
        } else if (roof_type == 4) {
            roof_image_view_top.setImageDrawable(getResources().getDrawable(R.drawable.koperta_podglad_gora, getApplicationContext().getTheme()));
            roof_image_view_bot.setImageDrawable(getResources().getDrawable(R.drawable.rzut_koperta_1_nad_4, getApplicationContext().getTheme()));
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

        inputDoublesListMap.put("A", Double.parseDouble(edt_A.getText().toString()));
        inputDoublesListMap.put("s_mu", Double.parseDouble(edt_s_mu.getText().toString()));
        inputDoublesListMap.put("g_pk", Double.parseDouble(edt_g_pk.getText().toString()));
        inputDoublesListMap.put("s_kr", Double.parseDouble(edt_s_kr.getText().toString()));
        inputDoublesListMap.put("g_kr", Double.parseDouble(edt_g_kr.getText().toString()));

        if (roof_type == 1 || roof_type == 2) {

            inputDoublesListMap.put("D", Double.parseDouble(edt_D.getText().toString()));
            inputDoublesListMap.put("B", Double.parseDouble(edt_B.getText().toString()));
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
            inputDoublesListMap.put("D", Double.parseDouble(edt_D.getText().toString()));
            inputDoublesListMap.put("B", Double.parseDouble(edt_B.getText().toString()));
            inputDoublesListMap.put("alpha", Double.parseDouble(edt_alpha.getText().toString()));
            inputDoublesListMap.put("beta", Double.parseDouble(edt_beta.getText().toString()));
            inputDoublesListMap.put("A1", Double.parseDouble(edt_A1.getText().toString()));
            inputDoublesListMap.put("B1", Double.parseDouble(edt_B1.getText().toString()));
            inputDoublesListMap.put("SB", Double.parseDouble(edt_SB.getText().toString()));
            inputDoublesListMap.put("g_mu", Double.parseDouble(edt_g_mu.getText().toString()));
            inputDoublesListMap.put("E", Double.parseDouble(edt_E.getText().toString()));
        }

        if (roof_type == 4) {
            inputDoublesListMap.put("alpha_p", Double.parseDouble(edt_alpha.getText().toString()));
            inputDoublesListMap.put("beta_p", Double.parseDouble(edt_beta.getText().toString()));
            inputDoublesListMap.put("E", Double.parseDouble(edt_E.getText().toString()));
            inputDoublesListMap.put("C", Double.parseDouble(edt_C.getText().toString()));
            inputDoublesListMap.put("SA", Double.parseDouble(edt_SA.getText().toString()));
            inputDoublesListMap.put("no_kpA", Double.parseDouble(edt_no_kpA.getText().toString()));
            inputDoublesListMap.put("no_kpB", Double.parseDouble(edt_no_kpB.getText().toString()));
            inputDoublesListMap.put("g_kk", Double.parseDouble(edt_g_kk.getText().toString()));
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
        } else if (roof_type == 3 || roof_type == 4) {
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
            if (alpha_value >= beta_value && roof_type == 3) {
                Toasty.warning(getApplicationContext(), "Alpha musi być mniejsze od beta", Toast.LENGTH_LONG, true).show();
                ((ScrollView) findViewById(R.id.scroll_view_inputs)).smoothScrollTo(edt_alpha.getScrollX(), edt_alpha.getScrollY());
                return false;
            }
        } else {
            throw new IllegalArgumentException("Niepoprawna wartość roof_type:" + roof_type);
        }
        return true;
    }

    @SuppressLint("ResourceType")
    public void showResultsRoof1(View view) {

        if (roof_type == 4 && !roof4_results_allowed) {
            if (!TextUtils.isEmpty(edt_no_kpB.getText()) && !TextUtils.isEmpty(edt_no_kpA.getText())) {
                hideKeyboard();
                onClick_btnroof4();
            }
        } else {
            if (fieldsAreFilledCorrectly(roof_type)) {
                // Create Intent and list objects
                Intent intent = new Intent(this, ResultsActivity.class);
                intent.putExtra("ROOF_TYPE", roof_type);

                // Prepare Inputs map for Carpenter
                HashMap<String, Double> inputDoublesListMap = prepareInputsMap(roof_type);
                Carpenter carpenter = new Carpenter(inputDoublesListMap, roof_type);
                if (roof_type == 4) {
                    for (int i = 0; i < numberOfDynamicEdtS_A; i++) {
                        EditText dynamicField = findViewById(100 + i);
                        carpenter.PAs_list.add(Double.parseDouble(dynamicField.getText().toString()));
                    }
                    for (int i = 0; i < numberOfDynamicEdtS_B; i++) {
                        EditText dynamicField = findViewById(200 + i);
                        carpenter.PBs_list.add(Double.parseDouble(dynamicField.getText().toString()));
                    }
                }
                // Calculate the result using Roofer class
                HashMap<String, Double> results = carpenter.prepareResults(roof_type);

                //Check if all results are non negative //TODO
//            for (Double result : results.values()) {
//                if (result < 0) {
//                    hideKeyboard();
//                    Toasty.warning(getApplicationContext(), "Wprowadzono niepoprawne dane", Toast.LENGTH_LONG, true).show();
//                    return;
//                }
//            }
                // Pass the results and open next activity
                intent.putExtra("EXTRA_ROOF1_RESULTS_MAP", results);
                startActivity(intent);
            } else {
                hideKeyboard();
            }
        }

    }
}