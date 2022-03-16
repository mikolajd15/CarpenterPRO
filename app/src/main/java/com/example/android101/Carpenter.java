package com.example.android101;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Carpenter {


    @NonNull
    public static HashMap<String, Double> countRoofValues(@NonNull List<Double> inputValues) {

        HashMap<String, Double> results = new HashMap<>();

        double input_theta = inputValues.get(0);
        double input_B = inputValues.get(1);
        double input_A = inputValues.get(2);
        double input_D = inputValues.get(3);
        double input_E = inputValues.get(4);
        double input_C = inputValues.get(5);
        double input_S = inputValues.get(6);
        double input_m_d = inputValues.get(7);
        double input_m_w = inputValues.get(8);
        double input_pp_d = inputValues.get(9);
        double input_pp_w = inputValues.get(10);
        double input_pk_d = inputValues.get(11);
        double input_pk_w = inputValues.get(12);
        double input_k_d = inputValues.get(13);
        double input_k_w = inputValues.get(14);
        double input_fpk = inputValues.get(15);
        double input_k_max = inputValues.get(16);

        double result_gamma = 90 - input_theta;
        double result_H1 = (input_A - input_pk_d) * Math.tan(input_theta) + input_m_w;
        double result_H2 = (input_A - input_C) * Math.tan(input_theta) + input_m_w;
        double result_Lp = (input_A + input_D + input_E) / Math.cos(input_theta);
        double result_Lc = result_Lp + input_k_w * Math.tan(input_theta);
        double result_M2 = result_Lp - input_D / Math.cos(input_theta);
        double result_M1 = result_M2 - input_S / Math.sin(input_theta);
        double result_N2 = result_Lp - (input_A + input_D - input_C) / Math.cos(input_theta);
        double result_N1 = result_N2 - input_S / Math.sin(input_theta);
        double result_K2 = result_Lp - (input_A + input_D - input_pk_d) / Math.cos(input_theta);
        double result_K1 = result_K2 - input_S / Math.sin(input_theta);

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

        return results;
    }
}
