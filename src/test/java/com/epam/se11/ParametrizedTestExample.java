package com.epam.se11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ParametrizedTestExample {

    @DisplayName("Sum two positive values")
    @CsvSource(value = {"1 1 2", "2 3 5", "4 1 6"}, delimiter = ' ')
    @ParameterizedTest(name = "[{index}] → {0} + {1} = {2}")
    void sumTwoPositiveValues(int a, int b, int expected) {
        Summator summator = new Summator();

        int actual = summator.sum(a, b);

        assertEquals(expected, actual);
    }


    //    @Test
//    void sumTwoPositiveValues1() {
//        sumTwoPositiveValues(1, 1, 2);
//    }
//
//    @Test
//    void sumTwoPositiveValues2() {
//        sumTwoPositiveValues(2, 4, 6);
//    }
//
//    @Test
//    void sumTwoPositiveValues3() {
//        sumTwoPositiveValues(3, 1, 4);
//    }
//
//    private void sumTwoPositiveValues(int a, int b, int expected) {
//        Summator summator = new Summator();
//
//        int actual = summator.sum(a, b);
//
//        assertEquals(expected, actual);
//    }
}
