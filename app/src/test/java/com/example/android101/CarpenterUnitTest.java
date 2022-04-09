package com.example.android101;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.HashMap;

public class CarpenterUnitTest {

    //Values for Carpenter for roof 1 and 2
    double input_theta, input_B, input_A, input_D, input_E, input_C, input_S,
            input_s_mu, input_g_pk, input_s_kr, input_g_kr, input_fpk, input_k_max;

    // Additional values for Carpenter for roof 3
    double input_alpha, input_beta, input_A1, input_B1, input_g_mu, input_SB;

    HashMap<String, Double> testInputValuesMap = new HashMap<>();
    Carpenter testCarpenter_1and2, testCarpenter_3;

    @Before
    public void setUp() {
        testInputValuesMap.put("theta", input_theta);
        testInputValuesMap.put("B", input_B);
        testInputValuesMap.put("A", input_A);
        testInputValuesMap.put("D", input_D);
        testInputValuesMap.put("E", input_E);
        testInputValuesMap.put("C", input_C);
        testInputValuesMap.put("S", input_S);
        testInputValuesMap.put("s_mu", input_s_mu);
        testInputValuesMap.put("g_pk", input_g_pk);
        testInputValuesMap.put("s_kr", input_s_kr);
        testInputValuesMap.put("g_kr", input_g_kr);
        testInputValuesMap.put("fpk", input_fpk);
        testInputValuesMap.put("k_max", input_k_max);

        testInputValuesMap.put("alpha", input_alpha);
        testInputValuesMap.put("beta", input_beta);
        testInputValuesMap.put("A1", input_A1);
        testInputValuesMap.put("B1", input_B1);
        testInputValuesMap.put("g_mu", input_g_mu);
        testInputValuesMap.put("SB", input_SB);

        testCarpenter_1and2 = new Carpenter(testInputValuesMap, 1);
        testCarpenter_3 = new Carpenter(testInputValuesMap, 3);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_countingResults_initValues() {

        testCarpenter_1and2.countRoof1Values();
        assertEquals(0, testCarpenter_1and2.result_gamma, 1e5);
        assertEquals(0, testCarpenter_1and2.result_H1, 1e5);
        assertEquals(0, testCarpenter_1and2.result_H2, 1e5);
        assertEquals(0, testCarpenter_1and2.result_Lp, 1e5);
        assertEquals(0, testCarpenter_1and2.result_Lc, 1e5);
        assertEquals(0, testCarpenter_1and2.result_M2, 1e5);
        assertEquals(0, testCarpenter_1and2.result_M1, 1e5);
        assertEquals(0, testCarpenter_1and2.result_N2, 1e5);
        assertEquals(0, testCarpenter_1and2.result_N1, 1e5);

        testCarpenter_1and2.countRoof2Values();
        assertEquals(0, testCarpenter_1and2.result_gamma, 1e5);
        assertEquals(0, testCarpenter_1and2.result_H1, 1e5);
        assertEquals(0, testCarpenter_1and2.result_H2, 1e5);
        assertEquals(0, testCarpenter_1and2.result_Lp, 1e5);
        assertEquals(0, testCarpenter_1and2.result_Lc, 1e5);
        assertEquals(0, testCarpenter_1and2.result_M2, 1e5);
        assertEquals(0, testCarpenter_1and2.result_M1, 1e5);
        assertEquals(0, testCarpenter_1and2.result_N2, 1e5);
        assertEquals(0, testCarpenter_1and2.result_N1, 1e5);
    }

    @Test
    public void test_countingResultsRoof1_ValidationValues() {

        testCarpenter_1and2.input_B = 1000;
        testCarpenter_1and2.input_fpk = 40;
        testCarpenter_1and2.input_g_kr = 8;
        testCarpenter_1and2.input_k_max = 70;

        testCarpenter_1and2.input_theta = 30;
        testCarpenter_1and2.input_S = 5;
        testCarpenter_1and2.input_A = 500;
        testCarpenter_1and2.input_D = 80;
        testCarpenter_1and2.input_E = 20;
        testCarpenter_1and2.input_C = 250;
        testCarpenter_1and2.input_s_kr = 16;
        testCarpenter_1and2.input_s_mu = 20;
        testCarpenter_1and2.input_g_pk = 16;

        testCarpenter_1and2.countRoof1Values();

        assertEquals(testCarpenter_1and2.result_Lc, 702.06, 0.01);
        assertEquals(testCarpenter_1and2.result_Lp, 692.82, 0.01);
        assertEquals(testCarpenter_1and2.result_M2, 600.44, 0.01);
        assertEquals(testCarpenter_1and2.result_N2, 311.77, 0.01);
        assertEquals(testCarpenter_1and2.result_K1, 31.57, 0.01);
        assertEquals(testCarpenter_1and2.result_H1, 299.44, 0.01);

    }

    @Test
    public void test_countingResultsRoof2_ValidationValues() {

        testCarpenter_1and2.input_B = 1000;
        testCarpenter_1and2.input_fpk = 40;
        testCarpenter_1and2.input_g_kr = 8;
        testCarpenter_1and2.input_k_max = 70;

        testCarpenter_1and2.input_theta = 30;
        testCarpenter_1and2.input_S = 5;
        testCarpenter_1and2.input_A = 984;
        testCarpenter_1and2.input_D = 80;
        testCarpenter_1and2.input_C = 250;
        testCarpenter_1and2.input_s_kr = 16;
        testCarpenter_1and2.input_s_mu = 20;
        testCarpenter_1and2.input_g_pk = 16;

        testCarpenter_1and2.countRoof2Values();

        assertEquals(testCarpenter_1and2.result_Lc, 669.73, 0.01);
        assertEquals(testCarpenter_1and2.result_Lp, 660.49, 0.01);
        assertEquals(testCarpenter_1and2.result_M2, 568.11, 0.01);
        assertEquals(testCarpenter_1and2.result_N2, 279.44, 0.01);
        assertEquals(testCarpenter_1and2.result_K2, 9.24, 0.01);
        assertEquals(testCarpenter_1and2.result_H1, 299.44, 0.01);

    }

    @Test
    public void test_countingResultsRoof3_ValidationValues() {

        testCarpenter_3.input_alpha = 30;
        testCarpenter_3.input_beta = 45;
        testCarpenter_3.input_A = 300;
        testCarpenter_3.input_B = 200;
        testCarpenter_3.input_A1 = 150;
        testCarpenter_3.input_B1 = 100;
        testCarpenter_3.input_E = 30;
        testCarpenter_3.input_D = 40;
        testCarpenter_3.input_SB = 3;
        testCarpenter_3.input_s_mu = 12;
        testCarpenter_3.input_g_mu = 8;
        testCarpenter_3.input_g_pk = 8;
        testCarpenter_3.input_s_kr = 8;
        testCarpenter_3.input_g_kr = 4;

        testCarpenter_3.countRoof3Values();
        assertEquals(testCarpenter_3.result_LAc, 397.22, 0.01);
        assertEquals(testCarpenter_3.result_LBp, 325.27, 0.01);
        assertEquals(testCarpenter_3.result_SA, 1.31,    0.01);
        assertEquals(testCarpenter_3.result_HK, 209.32,  0.01);
        assertEquals(testCarpenter_3.result_HB1, 112.00, 0.01);
        assertEquals(testCarpenter_3.result_NB2, 143.28, 0.01);
        assertEquals(testCarpenter_3.result_NA1, 165.69, 0.01);
        assertEquals(testCarpenter_3.result_MA1, 338.89, 0.01);
        assertEquals(testCarpenter_3.result_PP, 1.32,    0.01);
    }

    @Test
    public void test_countingResults_randomValues() {
        for (int i = 0; i < 10000; i++) {

            testCarpenter_1and2.input_theta = 30 + Math.random() * (60 - 30);
            testCarpenter_1and2.input_B = 10 + Math.random() * (90 - 10);
            testCarpenter_1and2.input_g_pk = 10 + Math.random() * (90 - 10);
            testCarpenter_1and2.input_C = 10 + Math.random() * (90 - 10);
            testCarpenter_1and2.input_A = Math.max(testCarpenter_1and2.input_g_pk, testCarpenter_1and2.input_C) + Math.random() * (90 - Math.max(testCarpenter_1and2.input_g_pk, testCarpenter_1and2.input_C));
            testCarpenter_1and2.input_D = 10 + Math.random() * (90 - 10);
            testCarpenter_1and2.input_E = 10 + Math.random() * (90 - 10);
            testCarpenter_1and2.input_S = 10 + Math.random() * (90 - 10);
            testCarpenter_1and2.input_s_mu = 10 + Math.random() * (90 - 10);
            testCarpenter_1and2.input_s_kr = 10 + Math.random() * (90 - 10);
            testCarpenter_1and2.input_g_kr = 10 + Math.random() * (90 - 10);
            testCarpenter_1and2.input_fpk = 10 + Math.random() * (90 - 10);
            testCarpenter_1and2.input_k_max = 10 + Math.random() * (90 - 10);

            testCarpenter_1and2.countRoof1Values();
            assertTrue(testCarpenter_1and2.result_gamma >= 0);
            assertTrue(testCarpenter_1and2.result_H1 >= 0);
            assertTrue(testCarpenter_1and2.result_H2 >= 0);
            assertTrue(testCarpenter_1and2.result_Lp >= 0);
            assertTrue(testCarpenter_1and2.result_Lc >= 0);
            assertTrue(testCarpenter_1and2.result_M2 >= 0);
            //assertTrue(testCarpenter_1and2.result_M1 >= 0);
            assertTrue(testCarpenter_1and2.result_N2 >= 0);
            //assertTrue(testCarpenter_1and2.result_N1 >= 0);
        }
    }
}