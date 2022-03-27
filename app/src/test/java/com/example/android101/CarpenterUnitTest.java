package com.example.android101;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CarpenterUnitTest {

    double input_theta, input_B, input_A, input_D, input_E, input_C, input_S,
            input_m_d, input_m_w, input_pp_d, input_pp_w, input_pk_d, input_pk_w, input_k_d,
            input_k_w, input_fpk, input_k_max;
    List<Double> testInputValues;
    Carpenter testCarpenter;

    @Before
    public void setUp()
    {
        input_theta = 0;
        input_B = 0;
        input_A = 0;
        input_D = 0;
        input_E = 0;
        input_C = 0;
        input_S = 0;
        input_m_d = 0;
        input_m_w = 0;
        input_pp_d = 0;
        input_pp_w = 0;
        input_pk_d = 0;
        input_pk_w = 0;
        input_k_d = 0;
        input_k_w = 0;
        input_fpk = 0;
        input_k_max = 0;

        testInputValues = Arrays.asList(input_theta, input_B, input_A, input_D, input_E, input_C, input_S,
                input_m_d, input_m_w, input_pp_d, input_pp_w, input_pk_d, input_pk_w, input_k_d,
                input_k_w, input_fpk, input_k_max);

        testCarpenter = new Carpenter(testInputValues);
    }

    @Test
    public void test_countingResultsRoof1() {

        testCarpenter.countRoof1Values();
        // TODO
        assertEquals(0, testCarpenter.result_gamma, 1e5);
        assertEquals(0, testCarpenter.result_H1, 1e5);
        assertEquals(0, testCarpenter.result_H2, 1e5);
        assertEquals(0, testCarpenter.result_Lp, 1e5);
        assertEquals(0, testCarpenter.result_Lc, 1e5);
        assertEquals(0, testCarpenter.result_M2, 1e5);
        assertEquals(0, testCarpenter.result_M1, 1e5);
        assertEquals(0, testCarpenter.result_N2, 1e5);
        assertEquals(0, testCarpenter.result_N1, 1e5);

    }

    @Test
    public void test_countingResultsRoof2() {

        testCarpenter.countRoof2Values();
        // TODO
        assertEquals(0, testCarpenter.result_gamma, 1e5);
        assertEquals(0, testCarpenter.result_H1, 1e5);
        assertEquals(0, testCarpenter.result_H2, 1e5);
        assertEquals(0, testCarpenter.result_Lp, 1e5);
        assertEquals(0, testCarpenter.result_Lc, 1e5);
        assertEquals(0, testCarpenter.result_M2, 1e5);
        assertEquals(0, testCarpenter.result_M1, 1e5);
        assertEquals(0, testCarpenter.result_N2, 1e5);
        assertEquals(0, testCarpenter.result_N1, 1e5);

    }
}