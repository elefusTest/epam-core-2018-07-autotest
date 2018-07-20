package com.epam.se01.memory;

public class Example2 {

    private static int field = 0;

    public static void main(String[] args) {
        int localValue;

        System.out.println(field);

        if (field > 0) {
            int var = 50;
            localValue = 0;
        } else {
            localValue = 42;
        }

        int bigValue = (int)3_000_000_000L;


        System.out.println(localValue);


    }
}
