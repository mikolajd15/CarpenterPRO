package com.example.android101;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.List;

public class Carpenter {

    HashMap<String, Double> results;
    double input_theta, input_B, input_A, input_D, input_E, input_C, input_S,
            input_s_mu, input_g_pk, input_s_kr, input_g_kr, input_fpk, input_k_max;

    double result_gamma, result_Lp, result_Lc,
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
        input_s_mu = inputValues.get(7);
        input_g_pk = inputValues.get(8);
        input_s_kr = inputValues.get(9);
        input_g_kr = inputValues.get(10);
        input_fpk = inputValues.get(11);
        input_k_max = inputValues.get(12);
    }

    void countRoof1Values() {
        if (input_theta <= 0 || input_theta >= 90) {
            throw new IllegalArgumentException("Invalid value for theta! " + input_theta);
        }
        result_gamma = 90 - input_theta;
        result_H1 = (input_A - input_g_pk) * Math.tan(Math.toRadians(input_theta)) + input_s_mu;
        result_H2 = (input_A - input_C) * Math.tan(Math.toRadians(input_theta)) + input_s_mu;
        result_Lp = (input_A + input_D + input_E) / Math.cos(Math.toRadians(input_theta));
        result_Lc = result_Lp + input_s_kr * Math.tan(Math.toRadians(input_theta));
        result_M2 = result_Lp - input_D / Math.cos(Math.toRadians(input_theta));
        result_M1 = result_M2 - input_S / Math.sin(Math.toRadians(input_theta));
        result_N2 = result_Lp - (input_A + input_D - input_C) / Math.cos(Math.toRadians(input_theta));
        result_N1 = result_N2 - input_S / Math.sin(Math.toRadians(input_theta));
        result_K2 = result_Lp - (input_A + input_D - input_g_pk) / Math.cos(Math.toRadians(input_theta));
        result_K1 = result_K2 - input_S / Math.sin(Math.toRadians(input_theta));

        double no_areas;
        if (input_fpk != 0) {
            result_Cd = input_B - input_g_kr;
            no_areas = Math.floor(result_Cd / (input_g_kr + input_k_max)) + 1;
            result_Nr = no_areas + 1;
        } else {
            result_Cd = input_B - 3 * input_g_kr - 2 * input_fpk;
            no_areas = Math.floor(result_Cd / (input_g_kr + input_k_max)) + 1;
            result_Nr = no_areas + 3;
        }
        result_Pk = result_Cd / no_areas - input_g_kr;
    }

    void countRoof2Values() {
        if (input_theta <= 0 || input_theta >= 90) {
            throw new IllegalArgumentException("Invalid value for theta! " + input_theta);
        }
        result_gamma = 90 - input_theta;
        result_H1 = (input_A - input_g_pk) / 2 * Math.tan(Math.toRadians(input_theta)) + input_s_mu;
        result_H2 = (input_A / 2 - input_C) * Math.tan(Math.toRadians(input_theta)) + input_s_mu;
        result_Lp = (input_A / 2 + input_D) / Math.cos(Math.toRadians(input_theta));
        result_Lc = result_Lp + input_s_kr * Math.tan(Math.toRadians(input_theta));
        result_M2 = result_Lp - input_D / Math.cos(Math.toRadians(input_theta));
        result_M1 = result_M2 - input_S / Math.sin(Math.toRadians(input_theta));
        result_N2 = result_Lp - (input_D + input_C) / Math.cos(Math.toRadians(input_theta));
        result_N1 = result_N2 - input_S / Math.sin(Math.toRadians(input_theta));
        result_K2 = (input_g_pk / 2) / Math.cos(Math.toRadians(input_theta));
        double result_S1 = result_K2 - input_S / Math.sin(Math.toRadians(input_theta));
        result_K1 = result_S1;
    }

    @NonNull
    public HashMap<String, Double> prepareResults(int roof_type) {

        if (roof_type == 1) {
            countRoof1Values();
        } else if (roof_type == 2) {
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
