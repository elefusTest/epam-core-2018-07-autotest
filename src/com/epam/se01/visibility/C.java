package com.epam.se01.visibility;

public class C {

    public static void main(String[] args) {
        System.out.println(new A().publicField);
        System.out.println(new A().protectedField);
        System.out.println(new A().defaultField);
    }
}
