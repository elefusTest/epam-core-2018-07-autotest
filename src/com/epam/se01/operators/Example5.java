package com.epam.se01.operators;

public class Example5 {

    public static void main(String[] args) {
//        int value = 42;

//        System.out.println(value++);
//        System.out.println(++value);
//
//        System.out.println(value);
//
        method(0);

    }

    public static void method(int level) {
        double a = 10;
        double b = 20;
        System.out.println(a + b + 50.5);
        System.out.println(level);
        method(++level);
    }

//    public static void method2(int level) {
//        method(level);
//    }
}
