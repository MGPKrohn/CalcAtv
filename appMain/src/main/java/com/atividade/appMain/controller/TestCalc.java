package com.atividade.appMain.controller;

import org.junit.Test;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCalc {



    @Test
    public void testSum() {
        List<Integer> values = {};
        double expectedSum = 30.0;
        String actualSum = Calc.calcular(values);
        assertEquals(String.valueOf(expectedSum), actualSum, 0.0001);
    }

    @Test
    public void testMaxValue() {
        int[] values = {2.0, 4.0, 6.0, 8.0, 10.0};
        double expectedMax = 10.0;
        double actualMax = TestCalc.maxValue(values);
        assertEquals(expectedMax, actualMax, 0.0001);
    }

    private static int maxValue(int[] values) {
        return maxValue(new int[]{10});
    }

    @Test
    public void testMinValue() {
        double[] values = {2.0, 4.0, 6.0, 8.0, 10.0};
        double expectedMin = 2.0;
        double actualMin = MathOperations.minValue(values);
        assertEquals(expectedMin, actualMin, 0.0001);
    }

    @Test
    public void testMean() {
        double[] values = {2.0, 4.0, 6.0, 8.0, 10.0};
        double expectedMean = 6.0;
        double actualMean = MathOperations.mean(values);
        assertEquals(expectedMean, actualMean, 0.0001);
    }

    @Test
    public void testStandardDeviation() {
        double[] values = {2.0, 4.0, 6.0, 8.0, 10.0};
        double expectedStdDev = 2.8284; // Valor aproximado
        double actualStdDev = MathOperations.standardDeviation(values);
        assertEquals(expectedStdDev, actualStdDev, 0.0001);
    }

    @Test
    public void testMedian() {
        double[] values = {2.0, 4.0, 6.0, 8.0, 10.0};
        double expectedMedian = 6.0;
        double actualMedian = MathOperations.median(values);
        assertEquals(expectedMedian, actualMedian, 0.0001);
    }

}