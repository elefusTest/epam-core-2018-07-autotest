package com.epam.se11;

import lombok.Value;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.array;
import static org.hamcrest.Matchers.both;
import static org.hamcrest.Matchers.either;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.equalToIgnoringWhiteSpace;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.startsWith;

public class JUnitAssertionsExample {

    @Test
    void assertions() {
//        assertThat(5.5, closeTo(5.0, 0.5));
//        assertThat(5.5, greaterThan(5.0));
//
        assertThat(10, is(10));
//        assertThat(10, equalToObject(10));
//
//        assertThat(new A(10), hasToString("A{10}"));
//        assertThat(new A(10), instanceOf(Number.class));
//        assertThat(new A(10), any(Serializable.class));
//        assertThat(new A(10).getClass(), typeCompatibleWith(Serializable.class));
//        String actual = "123";
//        assertThat(actual, notNullValue());

        assertThat("   1  a  3    4   5  ", equalToIgnoringWhiteSpace("1 A 3 4 5"));

        assertThat("qwerty", allOf(startsWith("qwe"), endsWith("ty")));
        assertThat("qwerty", both(startsWith("qwe")).and(endsWith("ty")));
        assertThat("qwerty", anyOf(startsWith("qwr"), endsWith("ty")));
        assertThat("qwerty", either(startsWith("qwr")).or(endsWith("ty")));

        assertThat(new A(10), hasProperty("value"));


        assertThat(new Integer[]{1, 2, 3}, array(is(1), is(2), is(3)));
        assertThat(new Integer[]{1, 2, 3}, hasItemInArray(1));

        assertThat(Arrays.asList("1", "2"), hasItem("2"));
        assertThat(Arrays.asList(1, 22, 333, 4444), hasItem(greaterThan(100)));

        assertThat(Arrays.asList(1, 2, 3), hasItems(1, 3));
        assertThat(Arrays.asList(1, 2, 3, 4, 5, 6), everyItem(both(greaterThan(0)).and(lessThan(10))));

    }
}

@Value
class A implements Serializable  {

    int value;

    @Override
    public String toString() {
        return "A{" + value + "}";
    }
}
