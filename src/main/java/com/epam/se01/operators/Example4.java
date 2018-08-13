package com.epam.se01.operators;

public class Example4 {

    public static void main(String[] args) {
        long a = 10_000_000_000L;
        int x = (int) a;
        // 1010010111010101
        // &
        // 1101010101010101
        // =
        // 1000010101010101
        System.out.println(0xFF_FF_FF_FFL & 10_000_000_000L);

        System.out.println("x - " + x);

        byte b5 = 50;
        // byte b4 = b5 * 2; // error
        byte b4 = (byte) (b5 * 2);
        byte b1 = 50;
        byte b2 = 20;
        byte b3 = 127;
        int x2 = b1 * b2 * b3;
        System.out.println("x2 - " + x2);

        double d = 12.84;
        int x3 = (int) d;
        System.out.println("x3 - " + x3);
    }
}
