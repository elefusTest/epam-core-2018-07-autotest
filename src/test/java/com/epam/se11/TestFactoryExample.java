package com.epam.se11;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

public class TestFactoryExample {

    @DisplayName("Test that all values < 100 contains < 3 characters")
    @TestFactory
    Stream<DynamicTest> factory() {
        return IntStream.rangeClosed(0, 100)
                        .mapToObj(i ->
                            dynamicTest(i + " should be less than 3 characters", () -> {
                                String stringValueOfInt = String.valueOf(i);
                                assertTrue(stringValueOfInt.length() < 3);
                            })
                        );
    }
}
