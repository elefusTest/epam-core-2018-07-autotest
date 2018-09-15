package com.epam.se11;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.sameInstance;
import static org.junit.jupiter.api.Assertions.assertThrows;

@DisplayName("Test for stack implemented on linked list")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class StackTest {

    private Stack<String> stack;

    @BeforeEach
    void createStack() {
        stack = new StackOnLinkedList<>();
    }

    @Nested
    class WhenEmpty {

        @DisplayName("Size should be a zero")
        @Test
        void size() {
            assertThat(stack.size(), is(0));
        }

        @DisplayName("IsEmpty should return true")
        @Test
        void isEmpty() {
            assertThat(stack.isEmpty(), is(true));
        }

        @DisplayName("Push should successfully add an element")
        @Test
        void push() {
            stack.push("value");
        }

        @DisplayName("Should throw an exception")
        @Test
        void pop() {
            assertThrows(IllegalStateException.class, stack::pop);
        }
    }

    @Nested
    class WhenNotEmpty {

        @BeforeEach
        void pushElementToStack() {
            stack.push("value");
        }

        @DisplayName("Size should return actual value")
        @Test
        void size() {
            assertThat(stack.size(), is(1));
        }

        @DisplayName("IsEmpty should return false")
        @Test
        void isEmpty() {
            assertThat(stack.isEmpty(), is(false));
        }

        @DisplayName("Push should successfully add an element")
        @Test
        void push() {
            stack.push("value2");
        }

        @DisplayName("Pop should return value form the top of stack")
        @Test
        void pop() {
            String secondValue = "value2";
            stack.push(secondValue);

            assertThat(stack.pop(), sameInstance(secondValue));
        }
    }
}
