package com.exampl.Calculator;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;


import java.util.stream.Stream;

import static org.skyscreamer.jsonassert.JSONAssert.assertEquals;

class CalculatorServiceImplTest {
    private CalculatorService calculatorService = new CalculatorService();

    public static Stream<Arguments> positiveAddition() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(5, 10, 15),
                Arguments.of(10, 20, 30)
        );
    }

    @Test
    void plus() {
        int expected = 10;
        int result = calculatorService.plus(10, 0);
        Assertions.assertEquals(expected, result);
    }
    @Test
    void minus() {
        int expected = 1;
        int result = calculatorService.minus(3, 2);
        Assertions.assertEquals(expected,result);
    }
    @Test
    void multiplication() {
        int expected = 12;
        int resukt = calculatorService.multiply(-3, -4);
        Assertions.assertEquals(expected,resukt);
    }
    @Test
    void divide() {
        int expected = 2;
        int result = calculatorService.divide(-12, -6);
        Assertions.assertEquals(expected,result);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3", "5,10,15", "10,20,30"})
    void additionPositive(Integer num1, Integer num2, Integer expected) {
        int result = calculatorService.plus(num1, num2);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @MethodSource("positiveAddition")
    void additionPositiveMethod(Integer num1, Integer num2, Integer expected) {
        int result = calculatorService.plus(num1, num2);
        Assertions.assertEquals(expected, result);

    }

    @ParameterizedTest
    @CsvSource(value = {"3,2,1", "15,10,5", "30,20,10"})
    void subtract(Integer num1, Integer num2, Integer expected) {
        int result = calculatorService.minus(num1, num2);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource(value = {"3,2,6", "15,10,150", "30,20,600"})
    void multiplication(Integer num1, Integer num2, Integer expected) {
        int result = calculatorService.multiply(num1, num2);
        Assertions.assertEquals(expected, result);
    }

    @ParameterizedTest
    @CsvSource(value = {"4,2,2.0", "10,5,2.0", "40,20,2.0"})
    void dividePositive(Integer num1, Integer num2, Double expected) {
        double result = calculatorService.divide(num1, num2);
        Assertions.assertEquals(expected, result);
    }
}
