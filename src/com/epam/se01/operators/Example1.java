package com.epam.se01.operators;

import java.io.Serializable;

public class Example1 {

    static final long field = 10;

    public static void main(String[] args) {
        final Object string = new StringBuilder();
        if (string instanceof String) {

        }
        if (string instanceof Serializable) {

        }

        int val = 10;
        val = 0b00010101010101;

        char sym = '\uFB9A';
        val = sym;

        long longVal = 1_000_000_000_000L;
        val = (int) (val + longVal);
        val += longVal;

        val = val + 20;
        val += 20;

        Example1.printHello();
        Example1 ref = new Example1();
        ref.anotherMethod();
    }

    public static void printHello() throws IllegalArgumentException, NullPointerException {
        System.out.println("Hello world!");
    }

    public void anotherMethod() {
        System.out.println(this);
    }
}
