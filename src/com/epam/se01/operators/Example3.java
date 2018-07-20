package com.epam.se01.operators;

public class Example3 {

    public static void main(String[] args) {
        int x1 = 123456789;
        float f1 = x1;
        System.out.println("f1 - " + f1);

        int x2 = 99999999;
        float f2 = x2;
        System.out.println("f2 - " + f2);


        byte a = 10;
        byte b = 10;
        byte c = (byte) (a + b);
    }
}
