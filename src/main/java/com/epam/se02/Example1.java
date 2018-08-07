package com.epam.se02;

public class Example1 {

    // inner
    // внутренний
    private class B {

    }

    // nested
    // вложенный
    protected static class C {

    }
}

class A {

    public static void main(String[] args) {
        Example1.C var = new Example1.C();
    }
}