package com.example.android101;

import androidx.annotation.NonNull;

import java.util.HashMap;

public class Carpenter {

    HashMap<String, Double> results;
    double input_theta, input_B, input_A, input_D, input_E, input_C, input_S,
            input_s_mu, input_g_pk, input_s_kr, input_g_kr, input_fpk, input_k_max;

    double input_alpha, input_beta, input_A1, input_B1, input_g_mu, input_SB;

    double result_gamma, result_Lp, result_Lc,
            result_H1, result_H2, result_M2, result_M1,
            result_N2, result_N1, result_K2, result_K1,
            result_Area, result_Nr, result_Pk;

    double result_LAc, result_LBp, result_SA,
            result_HK, result_HB1, result_NB2,
            result_NA1, result_MA1, result_PP;

    Carpenter(@NonNull HashMap<String, Double> inputValuesMap, int roof_type) {
        results = new HashMap<>();
        // common inputs
        input_B = inputValuesMap.get("B");
        input_A = inputValuesMap.get("A");
        input_D = inputValuesMap.get("D");
        input_s_kr = inputValuesMap.get("s_kr");
        input_g_kr = inputValuesMap.get("g_kr");
        input_g_pk = inputValuesMap.get("g_pk");
        input_s_mu = inputValuesMap.get("s_mu");

        if (roof_type == 1 || roof_type == 2) {
            input_theta = inputValuesMap.get("theta");
            input_C = inputValuesMap.get("C");
            input_S = inputValuesMap.get("S");
            input_fpk = inputValuesMap.get("fpk");
            input_k_max = inputValuesMap.get("k_max");

            if (roof_type == 1) {
                input_E = inputValuesMap.get("E");
            }

        } else if (roof_type == 3) {
            input_alpha = inputValuesMap.get("alpha");
            input_beta = inputValuesMap.get("beta");
            input_A1 = inputValuesMap.get("A1");
            input_B1 = inputValuesMap.get("B1");
            input_SB = inputValuesMap.get("SB");
            input_g_mu = inputValuesMap.get("g_mu");
            input_E = inputValuesMap.get("E");
        }
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
        double result_Cd;
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
        result_Pk = 0;//result_Cd / no_areas - input_g_kr; //TODO
        result_Area = result_Lp * input_B;
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
        result_K1 = 0;//result_S1; //TODO

        // copy paste z dachu 1
        double result_Cd;
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
        result_Pk = 0;//result_Cd / no_areas - input_g_kr; //TODO
        result_Area = result_Lp * input_B;
    }

    void countRoof3Values() {
        if (input_alpha <= 0 || input_alpha >= 90 || input_beta <= 0 || input_beta >= 90 || input_alpha >= input_beta) {
            throw new IllegalArgumentException("Invalid value for alpha or beta!  Alpha = " + input_alpha + " Beta = " + input_beta);
        }
        result_gamma = 90 - (input_alpha + input_beta) / 2;
        result_LBp = (input_B + input_E) / Math.cos(Math.toRadians(input_beta));
        double result_LBc = result_LBp + input_s_kr * Math.tan(Math.toRadians(input_beta));
        double result_ttc = input_s_kr / Math.sin(Math.toRadians(result_gamma));
        double result_theta = 90 - result_gamma - input_alpha;
        result_PP = result_ttc * Math.sin(Math.toRadians(result_theta));
        double result_WB = result_PP / Math.cos(Math.toRadians(input_beta));
        double result_WA = result_PP / Math.cos(Math.toRadians(input_alpha));
        double result_MB2 = result_LBp - input_E / Math.cos(Math.toRadians(input_beta)) + result_WB;
        double result_MB1 = result_MB2 - input_SB / Math.sin(Math.toRadians(input_beta));
        result_NB2 = result_LBp - (input_B + input_E - input_B1) / Math.cos(Math.toRadians(input_beta)) + result_WB;
        double result_NB1 = result_NB2 - input_SB / Math.sin(Math.toRadians(input_beta));
        double result_KB2 = input_g_pk / 2 / Math.cos(Math.toRadians(input_beta));
        double result_SB1 = input_SB / Math.sin(Math.toRadians(input_beta));

        double result_LAp = (input_A + input_D) / Math.cos(Math.toRadians(input_alpha));
        result_LAc = result_LAp + input_s_kr * Math.tan(Math.toRadians(input_alpha));
        double result_MA2 = result_LAp - input_D / Math.cos(Math.toRadians(input_alpha)) - result_WA;
        result_MA1 = result_MA2 - input_SB / Math.sin(Math.toRadians(input_alpha));
        double result_NA2 = result_LAp - (input_A + input_D - input_A1) / Math.cos(Math.toRadians(input_alpha)) - result_WA;
        result_NA1 = result_NA2 - input_SB / Math.sin(Math.toRadians(input_alpha));
        double result_KA2 = input_g_pk / 2 / Math.cos(Math.toRadians(input_alpha));
        double result_xk = input_g_pk / 2 * Math.tan(Math.toRadians(input_beta));
        double result_yk = result_xk * 1 / Math.tan(Math.toRadians(input_alpha));
        double result_zk = result_xk * (result_yk - input_g_pk / 2) / result_yk;
        result_SA = input_SB - result_zk;
        double result_SA1 = result_SA / Math.sin(Math.toRadians(input_alpha));
        result_HB1 = (input_B - input_B1) * Math.tan(Math.toRadians(input_beta)) + input_s_mu;
        result_HK = (input_B + result_PP - input_g_pk / 2) * Math.tan(Math.toRadians(input_beta)) + input_s_mu;
        double result_HA1 = result_HK - result_SA + input_SB - (input_A1 - result_PP - input_g_pk / 2) * Math.tan(Math.toRadians(input_alpha));
        double result_HA2 = result_HA1 - (input_A - input_A1) * Math.tan(Math.toRadians(input_alpha));

    }

    @NonNull
    public HashMap<String, Double> prepareResults(int roof_type) {

        if (roof_type == 1) {
            countRoof1Values();
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
            results.put("Area", result_Area);
            results.put("Nr", result_Nr);
        } else if (roof_type == 2) {
            countRoof2Values();
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
            results.put("Area", result_Area);
            results.put("Nr", result_Nr);
        } else if (roof_type == 3) {
            countRoof3Values();
            results.put("Gamma", result_gamma);
            results.put("LBp", result_LBp);
            results.put("PP", result_PP);
            results.put("NB2", result_NB2);
            results.put("LAc", result_LAc);
            results.put("MA1", result_MA1);
            results.put("NA1", result_NA1);
            results.put("SA", result_SA);
            results.put("HB1", result_HB1);
            results.put("HK", result_HK);

        } else {
            throw new IllegalArgumentException("Incorrect roof_type passed: " + roof_type);
        }

        return results;
    }
}
