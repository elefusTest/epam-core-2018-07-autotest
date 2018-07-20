package com.epam.se01.operators;

public class Example6 {

    public static void main(String[] args) {
        int value = 32;
        // 0b1000000000000000_0000000000010000
        // 0b0000000000000000_0000000000100000
        System.out.println(value << 1);

        // 34
        //  000...000_0000000000100010 - прямой код
        // ~111...111_1111111111011101 - обратный код
        //  111...111_1111111111011110 - дополнительный код


        value = -34;
        System.out.println(Integer.toBinaryString(value));
        System.out.println(Integer.toBinaryString(value >> 1));
        System.out.println(Integer.toBinaryString(value >>> 1));

        float a = 4.5f;
        float b = 4.5f;
        if (Math.abs(a - b) < 0.001) {

        }

    }
}
