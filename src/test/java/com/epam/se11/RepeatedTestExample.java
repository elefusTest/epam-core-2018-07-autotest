package com.epam.se11;

import org.junit.jupiter.api.RepeatedTest;

import static junit.framework.TestCase.fail;

public class RepeatedTestExample {

    @RepeatedTest(value = 5, name = "Attempt {currentRepetition}/{totalRepetitions}")
    void example() {
        fail();
    }
}
