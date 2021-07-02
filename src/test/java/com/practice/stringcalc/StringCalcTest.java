package com.practice.stringcalc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class StringCalcTest {
    private StringCalc calc;

    @BeforeEach
    public void before() {
        calc = new StringCalc();
    }

    @Disabled
    @Test
    void proceed() {
        calc.proceed();
    }

    @ParameterizedTest
    @CsvSource(value = { "1 + 2,3", "10 + 10,20", "100 + 100,200", "-10 + 5,-5"})
    public void testAdd(String input, int expected) {
        assertThat(calc.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = { "1 - 2,-1", "10 - 10,0", "100 - 1,99", "-10 - 5,-15"})
    public void testMinus(String input, int expected) {
        assertThat(calc.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = { "1 * 2,2", "10 * 10,100", "100 * 1,100", "-10 * 5,-50"})
    public void testMultiply(String input, int expected) {
        assertThat(calc.calculate(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = { "1 / 2,0", "10 / 10,1", "100 / 1,100", "-10 / 5,-2", "100 / 0,0", "0 / 5,0"})
    public void testDivide(String input, int expected) {
        assertThat(calc.calculate(input)).isEqualTo(expected);
    }

}