package com.example.android101;

import androidx.annotation.NonNull;

import java.util.ArrayList;
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

    //roof 4 specific inputs
    double input_g_kk, input_alpha_p, input_beta_p, input_no_kpA, input_no_kpB, input_SA;
    double result_alpha_A, result_beta_A, result_alpha_B, result_beta_B,result_ksi, result_Hpk, result_B, result_D, result_C, result_fi, result_ni,
            result_hipa, result_ro, result_w, result_Lk, result_Dkr, result_MNN_A,
            result_MNN_B, result_L, result_N2_A, result_N1_A, result_N2_B, result_N1_B;

    ArrayList<Double> PAs_list = new ArrayList<>();
    ArrayList<Double> PBs_list = new ArrayList<>();
    ArrayList<Double> DKLs_A_list;
    ArrayList<Double> DKLs_B_list;

    Carpenter(@NonNull HashMap<String, Double> inputValuesMap, int roof_type) {
        results = new HashMap<>();
        // common inputs
        input_A = inputValuesMap.get("A");
        input_s_kr = inputValuesMap.get("s_kr");
        input_g_kr = inputValuesMap.get("g_kr");
        input_g_pk = inputValuesMap.get("g_pk");
        input_s_mu = inputValuesMap.get("s_mu");

        if (roof_type == 1 || roof_type == 2) {
            input_B = inputValuesMap.get("B");
            input_D = inputValuesMap.get("D");
            input_theta = inputValuesMap.get("theta");
            input_C = inputValuesMap.get("C");
            input_S = inputValuesMap.get("S");
            input_fpk = inputValuesMap.get("fpk");
            input_k_max = inputValuesMap.get("k_max");

            if (roof_type == 1) {
                input_E = inputValuesMap.get("E");
            }

        } else if (roof_type == 3) {
            input_B = inputValuesMap.get("B");
            input_D = inputValuesMap.get("D");
            input_alpha = inputValuesMap.get("alpha");
            input_beta = inputValuesMap.get("beta");
            input_A1 = inputValuesMap.get("A1");
            input_B1 = inputValuesMap.get("B1");
            input_SB = inputValuesMap.get("SB");
            input_g_mu = inputValuesMap.get("g_mu");
            input_E = inputValuesMap.get("E");

        } else if (roof_type == 4) {
            input_g_kk = inputValuesMap.get("g_kk");
            input_alpha_p = inputValuesMap.get("alpha_p");
            input_beta_p = inputValuesMap.get("beta_p");
            input_no_kpA = inputValuesMap.get("no_kpA");
            input_no_kpB = inputValuesMap.get("no_kpB");
            input_E = inputValuesMap.get("E");
            input_SA = inputValuesMap.get("SA");

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

    void countRoof4Values() {
        if (input_alpha_p <= 0 || input_alpha_p >= 90 || input_beta_p <= 0 || input_beta_p >= 90 || input_alpha_p >= input_beta_p) {
            throw new IllegalArgumentException("Invalid value for alpha or beta!  Alpha = " + input_alpha + " Beta = " + input_beta);
        }
        //wzory_1
        result_Hpk = (input_A - input_g_pk / 2) * Math.tan(Math.toRadians(input_alpha_p)) + input_s_mu - input_SA;
        result_HK = result_Hpk + (input_s_kr / Math.sin(Math.toRadians(90 - input_alpha_p)));
        result_D = (Math.tan(Math.toRadians(input_alpha_p)) * input_E) / Math.tan(Math.toRadians(input_beta_p));
        result_B = (result_Hpk - input_s_mu) / Math.tan(Math.toRadians(input_beta_p));
        result_C = Math.sqrt(input_A * input_A + result_B * result_B);
        result_w = Math.sqrt(input_C * input_C + result_Hpk * result_Hpk);
        result_gamma = Math.toDegrees(Math.atan(result_Hpk / result_C));
        result_Lk = result_w + Math.sqrt(result_D * result_D + input_E * input_E) / Math.cos(result_gamma);
        result_fi = Math.toDegrees(Math.atan(result_B / input_A));
        result_ni = 90 - result_fi;
        result_hipa = Math.toDegrees(Math.atan(Math.cos(Math.toRadians(result_ni)) * Math.tan(Math.toRadians(45))));
        result_ro = Math.toDegrees(Math.atan(Math.sin(Math.toRadians(result_hipa)) / Math.tan(Math.toRadians(result_ni))));
        result_ksi = Math.toDegrees(Math.atan(Math.sin(Math.toRadians(result_hipa)) / Math.tan(Math.toRadians(result_fi))));

        // wzory 2
        result_Dkr = (input_A + input_E) / Math.cos(Math.toRadians(input_alpha_p));
        result_N2_A = input_E / Math.cos(Math.toRadians(input_alpha_p));
        result_N1_A = result_N2_A + input_SA / Math.sin(Math.toRadians(input_alpha_p));
        result_MNN_A = (result_B + result_D) / result_Dkr;

        double local_sum = 0;
        DKLs_A_list = new ArrayList<>();
        for (int i = 0; i < input_no_kpA; i++) {
            local_sum += PAs_list.get(i);
            double DKLi = (result_B + result_D - local_sum - input_g_kr * i) / result_MNN_A;
            DKLs_A_list.add(DKLi);
        }
        result_alpha_A = 90 - input_alpha_p;
        result_beta_A = 90 - input_beta_p;

        // wzory 3
        result_N2_B = result_D / Math.cos(Math.toRadians(input_beta_p));
        result_N1_B = result_N2_B + result_SA / Math.sin(Math.toRadians(input_beta_p));
        result_L = (result_B - input_g_kk / Math.cos(Math.toRadians(result_fi)) + result_D) / Math.cos(Math.toRadians(input_beta_p));
        result_alpha_B = 90 - input_beta_p;
        result_beta_B = 90 - result_fi;
        result_MNN_B = (input_A + input_E) / result_L;

        local_sum = 0;
        DKLs_B_list = new ArrayList<>();
        for (int i = 0; i < input_no_kpB; i++) {
            local_sum += PBs_list.get(i);
            double DKLi = (input_A + input_E - local_sum - input_g_kr * i) / result_MNN_B;
            DKLs_B_list.add(DKLi);
        }
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
        } else if (roof_type == 4) {
            countRoof4Values();
            // wzory 1
            results.put("Hpk", result_Hpk);
            results.put("HK", result_HK);
            results.put("D", result_D);
            results.put("B", result_B);
            results.put("ro", result_ro);//TODO zamien C na ro
            results.put("w", result_w);
            results.put("gamma", result_gamma);
            results.put("Lk", result_Lk);
            results.put("fi", result_fi);
            results.put("ni", result_ni);
            results.put("hipa", result_hipa);
            results.put("ksi", result_ksi);
            // wzory 2
            results.put("Dkr", result_Dkr);
            results.put("N2_A", result_N2_A);
            results.put("N1_A", result_N1_A);
            results.put("MNN_A", result_MNN_A);
            for (int i = 0; i < DKLs_A_list.size(); i++) {
                results.put("DKLs_A" + (i + 1), DKLs_A_list.get(i));
            }
            results.put("alpha_A", result_alpha_A);
            results.put("beta_A", result_beta_A);
            // wzory 2
            results.put("N2_B", result_N2_B);
            results.put("N1_B", result_N1_B);
            results.put("L", result_L);
            results.put("alpha_B", result_alpha_B);
            results.put("beta_B", result_beta_B);
            results.put("MNN_B", result_MNN_B);
            for (int i = 0; i < DKLs_B_list.size(); i++) {
                results.put("DKLs_B" + (i + 1), DKLs_B_list.get(i));
            }

            results.put("no_kpA", input_no_kpA);
            results.put("no_kpB", input_no_kpB);

        } else {
            throw new IllegalArgumentException("Incorrect roof_type passed: " + roof_type);
        }

        return results;
    }
}
