package com.example.android101;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.List;

public class Carpenter {

    HashMap<String, Double> results;
    private final double input_theta, input_B, input_A, input_D, input_E, input_C, input_S,
            input_m_d, input_m_w, input_pp_d, input_pp_w, input_pk_d, input_pk_w, input_k_d,
            input_k_w, input_fpk, input_k_max;

    private double result_gamma, result_Lp, result_Lc,
            result_H1, result_H2, result_M2, result_M1,
            result_N2, result_N1, result_K2, result_K1,
            result_Cd, result_Nr, result_Pk;

    Carpenter(@NonNull List<Double> inputValues) {
        results = new HashMap<>();
        input_theta = inputValues.get(0);
        input_B = inputValues.get(1);
        input_A = inputValues.get(2);
        input_D = inputValues.get(3);
        input_E = inputValues.get(4);
        input_C = inputValues.get(5);
        input_S = inputValues.get(6);
        input_m_d = inputValues.get(7);
        input_m_w = inputValues.get(8);
        input_pp_d = inputValues.get(9);
        input_pp_w = inputValues.get(10);
        input_pk_d = inputValues.get(11);
        input_pk_w = inputValues.get(12);
        input_k_d = inputValues.get(13);
        input_k_w = inputValues.get(14);
        input_fpk = inputValues.get(15);
        input_k_max = inputValues.get(16);
    }

    private void countRoof1Values(){
        result_gamma = 90 - input_theta;
        result_H1 = (input_A - input_pk_d) * Math.tan(input_theta) + input_m_w;
        result_H2 = (input_A - input_C) * Math.tan(input_theta) + input_m_w;
        result_Lp = (input_A + input_D + input_E) / Math.cos(input_theta);
        result_Lc = result_Lp + input_k_w * Math.tan(input_theta);
        result_M2 = result_Lp - input_D / Math.cos(input_theta);
        result_M1 = result_M2 - input_S / Math.sin(input_theta);
        result_N2 = result_Lp - (input_A + input_D - input_C) / Math.cos(input_theta);
        result_N1 = result_N2 - input_S / Math.sin(input_theta);
        result_K2 = result_Lp - (input_A + input_D - input_pk_d) / Math.cos(input_theta);
        result_K1 = result_K2 - input_S / Math.sin(input_theta);

        double no_areas;
        if (input_fpk != 0) {
            result_Cd = input_B - input_k_d;
            no_areas = Math.floor(result_Cd / (input_k_d + input_k_max)) + 1;
            result_Nr = no_areas + 1;
        } else {
            result_Cd = input_B - 3 * input_k_d - 2 * input_fpk;
            no_areas = Math.floor(result_Cd / (input_k_d + input_k_max)) + 1;
            result_Nr = no_areas + 3;
        }
        result_Pk = result_Cd / no_areas - input_k_d;
    }

    private void countRoof2Values(){
        //TODO
    }

    @NonNull
    public HashMap<String, Double> prepareResults(int roof_type) {

        if (roof_type == 1) {
            countRoof1Values();
        } else if (roof_type == 2){
            countRoof2Values();
        } else {
            throw new IllegalArgumentException("Incorrect roof_type passed: " + roof_type);
        }

        results.put("Gamma", result_gamma);
        results.put("H1", result_H1);
        results.put("H2", result_H2);
        results.put("Lp", result_Lp);
        results.put("Lc", result_Lc);
        results.put("M2", result_M2);
        results.put("M1", result_M1);
        results.put("N2", result_N2);
        results.put("N1", result_N1);
        results.put("K2", result_K2);
        results.put("K1", result_K1);
        results.put("Pk", result_Pk);
        results.put("Cd", result_Cd);
        results.put("Nr", result_Nr);

        return results;
    }
}
