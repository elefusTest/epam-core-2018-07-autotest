package com.epam.se11;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertArrayEquals;

public class ParametrizedTestExample {

    @ParameterizedTest
    @ValueSource(strings = {"a", "b", "c", "de"})
    void example(String value) {
        assertEquals(1, value.length());
    }

    private static char[] revertString(char[] chars) {
        char[] result = new char[chars.length];
        for (int i = 0; i < chars.length; ++i) {
            result[i] = chars[chars.length - 1 - i];
        }
        return result;
    }

    @Test
    void name() {
        char[] result = revertString(new char[]{'a', 'b', 'c'});
        assertArrayEquals(new char[]{'c', 'b', 'a'}, result);

    }

    @Test
    void name1() {
        char[] result = revertString(new char[]{'a', 'b'});
        assertArrayEquals(new char[]{'b', 'a'}, result);

    }

    @Test
    void name2() {
        char[] result = revertString(new char[]{'a'});
        assertArrayEquals(new char[]{'a'}, result);

    }

    @Test
    void name3() {
        char[] result = revertString(new char[]{});
        assertArrayEquals(new char[]{}, result);

    }

}
