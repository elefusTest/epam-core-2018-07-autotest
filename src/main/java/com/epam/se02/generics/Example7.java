package com.epam.se02.generics;

import java.io.Serializable;

public class Example7 {

    public static void main(String[] args) {
        method("123");
        method(12);
//        method(new Object());

        Number num = 1;
        Integer val = method2(num);

    }

    public static <T extends Serializable> void method(T ref) {
        T anotherRef = null;
    }

    public static <T, R extends T> R method2(T value) {
        return null;
    }

    public static <T> void method(T obj) {
        System.out.println("<T> void method(T obj)");
    }

    public static void method(Number obj) {
        System.out.println("void method(Number obj)");
    }

    public static void method(Integer obj) {
        System.out.println("void method(Integer obj)");
    }

    public static void method(String obj) {
        System.out.println("void method(String obj)");
    }


}
