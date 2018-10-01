package com.epam.se02.interfaces;

public interface X {

    public static final int value = 42;

    public static void saySmth() {
        System.out.println("Hello");
    }

    default int method() {
        return 42;
    }

    public static class A {

    }
}
