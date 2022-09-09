package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    Calculator calc;

    @Before
    public void setUp() {
        calc = new Calculator();
    }

    @Test
    public void shouldDividePositives() {
        assertEquals(3, calc.divide(6,2));
        assertEquals(2, calc.divide(80, 39));
        assertEquals(1, calc.divide(105, 100));
    }

    @Test
    public void shouldDivideNegatives() {
        assertEquals(3, calc.divide(-6,-2));
        assertEquals(2, calc.divide(-80, -39));
        assertEquals(1, calc.divide(-105, -100));
    }

    @Test
    public void shouldDivideBothPosAndNeg() {
        assertEquals(-3, calc.divide(6,-2));
        assertEquals(-2, calc.divide(-80, 39));
        assertEquals(-1, calc.divide(105, -100));
    }

    @Test
    public void shouldReturnZero() {
        assertEquals(0, calc.divide(0,0));
        assertEquals(0, calc.divide(0, 1));
        assertEquals(0, calc.divide(105, 0));
    }

    // Addition Tests

    @Test
    public void shouldAddPositives() {
        assertEquals(13, calc.add(8, 5));
        assertEquals(9, calc.add(7, 2));
        assertEquals(8, calc.add(1, 7));
    }

    @Test
    public void shouldAddNegatives() {
        assertEquals(-8, calc.add(-3, -5));
        assertEquals(-14, calc.add(-2, -12));
        assertEquals(-20, calc.add(-14, -6));
    }

    @Test
    public void shouldAddOnePosOneNeg() {
        assertEquals(-2, calc.add(3, -5));
        assertEquals(10, calc.add(-2, 12));
        assertEquals(-8, calc.add(-14, 6));
    }

    @Test
    public void shouldAddZeros() {
        assertEquals(0, calc.add(0, 0));
    }

    @Test
    public void shouldAddOnePosOneZero() {
        assertEquals(3, calc.add(3, 0));
        assertEquals(12, calc.add(0, 12));
    }

    @Test
    public void shouldAddOneNegOneZero() {
        assertEquals(-3, calc.add(-3, 0));
        assertEquals(-12, calc.add(0, -12));
    }

    // Subtraction Tests

    @Test
    public void shouldSubPositives() {
        assertEquals(3, calc.subtract(8, 5));
        assertEquals(5, calc.subtract(7, 2));
        assertEquals(-6, calc.subtract(1, 7));
    }

    @Test
    public void shouldSubNegatives() {
        assertEquals(2, calc.subtract(-3, -5));
        assertEquals(10, calc.subtract(-2, -12));
        assertEquals(-8, calc.subtract(-14, -6));
    }

    @Test
    public void shouldSubOnePosOneNeg() {
        assertEquals(8, calc.subtract(3, -5));
        assertEquals(-14, calc.subtract(-2, 12));
        assertEquals(-20, calc.subtract(-14, 6));
    }

    @Test
    public void shouldSubZeros() {
        assertEquals(0, calc.subtract(0, 0));
    }

    @Test
    public void shouldSubOnePosOneZero() {
        assertEquals(3, calc.subtract(3, 0));
        assertEquals(-12, calc.subtract(0, 12));
    }

    @Test
    public void shouldSubOneNegOneZero() {
        assertEquals(-3, calc.subtract(-3, 0));
        assertEquals(12, calc.subtract(0, -12));
    }

    // Multiplication Tests

    @Test
    public void shouldMultPositives() {
        assertEquals(40, calc.multiply(8, 5));
        assertEquals(14, calc.multiply(7, 2));
        assertEquals(7, calc.multiply(1, 7));
    }

    @Test
    public void shouldMultNegatives() {
        assertEquals(15, calc.multiply(-3, -5));
        assertEquals(24, calc.multiply(-2, -12));
        assertEquals(60, calc.multiply(-10, -6));
    }

    @Test
    public void shouldMultOnePosOneNeg() {
        assertEquals(-15, calc.multiply(3, -5));
        assertEquals(-24, calc.multiply(-2, 12));
        assertEquals(-60, calc.multiply(-10, 6));
    }

    @Test
    public void shouldEqualZero() {
        assertEquals(0, calc.multiply(0, 0));
        assertEquals(0, calc.multiply(3, 0));
        assertEquals(0, calc.multiply(0, 12));
    }
}

