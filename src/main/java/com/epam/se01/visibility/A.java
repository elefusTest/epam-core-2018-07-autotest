package com.epam.se01.visibility;

import lombok.experimental.PackagePrivate;

public class A {

    private int privateField;
    @PackagePrivate
    int defaultField;
    protected int protectedField;
    public int publicField;

    public static void main(String[] args) {
        System.out.println(new A().privateField);
        System.out.println(new A().defaultField);
        System.out.println(new A().protectedField);
        System.out.println(new A().publicField);
    }
}
