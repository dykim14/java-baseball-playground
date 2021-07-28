package com.practice.stringcalc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.*;

class StringCalcTest {
    private StringCalc calc;

    @BeforeEach
    public void before() {
        calc = new StringCalc();
    }

    @Disabled
    @Test
    void testProceed() {
        calc.proceed();
    }

    @ParameterizedTest
    @CsvSource(value = { "1 + 2,3", "10 + 10,20", "100 + 100,200", "-10 + 5,-5"})
    public void testGetResultAdd(String input, int expected) {
        assertThat(calc.getResult(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = { "1 - 2,-1", "10 - 10,0", "100 - 1,99", "-10 - 5,-15"})
    public void testGetResultMinus(String input, int expected) {
        assertThat(calc.getResult(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = { "1 * 2,2", "10 * 10,100", "100 * 1,100", "-10 * 5,-50"})
    public void testGetResultMultiply(String input, int expected) {
        assertThat(calc.getResult(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = { "1 / 2,0", "10 / 10,1", "100 / 1,100", "-10 / 5,-2", "0 / 5,0"})
    public void testGetResultDivide(String input, int expected) {
        assertThat(calc.getResult(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = { "1 % 2,1", "10 % 10,0", "100 % 1,0", "-10 % 5,0", "0 % 5,0"})
    public void testGetResultMod(String input, int expected) {
        assertThat(calc.getResult(input)).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = { "2 + 3 * 4 / 2,10", "1 + 2 * 3 - 2 / 7,1", "100 + 1 / 1 ,101", "-10 + 10 * 100,0"})
    public void testGetResultCombine(String input, int expected) {
        assertThat(calc.getResult(input)).isEqualTo(expected);
    }

    @Test
    public void testGetResultExceptions() {
        // divide 0
        assertThatExceptionOfType(ArithmeticException.class).isThrownBy(() -> calc.getResult("10 / 0"));

        assertThatIllegalArgumentException().isThrownBy(() -> calc.getResult("10 +- 3"))
                .withMessageContaining("For input string:");
        assertThatIllegalArgumentException().isThrownBy(() -> calc.getResult("10 1 3"))
                .withMessageContaining("Unknown operator");
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> calc.getResult("10 + abc"));
    }

    @Test
    void testCalculate() {
        assertThat(calc.calculate(10, "+", "1")).isEqualTo(11);
        assertThat(calc.calculate(10, "-", "1")).isEqualTo(9);
        assertThat(calc.calculate(10, "*", "2")).isEqualTo(20);
        assertThat(calc.calculate(10, "/", "2")).isEqualTo(5);
        assertThat(calc.calculate(10, "%", "3")).isEqualTo(1);
        assertThatIllegalArgumentException().isThrownBy(() -> calc.calculate(10, "+-", "3"))
                .withMessageContaining("Unknown operator");
        assertThatIllegalArgumentException().isThrownBy(() -> calc.calculate(10, "1", "3"))
                .withMessageContaining("Unknown operator");
        assertThatExceptionOfType(NumberFormatException.class).isThrownBy(() -> calc.calculate(10, "+", "abc"));

        // check handling first number of sentence
        assertThat(calc.calculate(0, "", "3")).isEqualTo(3);
        assertThatIllegalArgumentException().isThrownBy(() -> calc.calculate(1, "", "3"))
                .withMessageContaining("Unknown operator");

    }

    @Test
    void testIsOperator() {
        assertThat(calc.isOperator("+")).isTrue();
        assertThat(calc.isOperator("-")).isTrue();
        assertThat(calc.isOperator("*")).isTrue();
        assertThat(calc.isOperator("/")).isTrue();
        assertThat(calc.isOperator("%")).isTrue();
        assertThat(calc.isOperator("+-")).isFalse();
        assertThat(calc.isOperator("123")).isFalse();
        assertThat(calc.isOperator("abc")).isFalse();
    }
}