package com.epam.se01.package4;

public class Example7 {

    public static void main(String[] args) {
        Singleton singleton1 = Singleton.getInstance();
        Singleton singleton2 = Singleton.getInstance();

        System.out.println(singleton1 == singleton2);
        Singleton.getInstance().method();


        System.out.println(Runtime.getRuntime().totalMemory());
        System.out.println(Runtime.getRuntime().maxMemory());
        System.out.println(Runtime.getRuntime().freeMemory());
    }
}

class Singleton {

    private static final Singleton SINGLETON = new Singleton();

    private Singleton() {}

    public void method() {
        System.out.println("Hello of singleton");
    }

    public static Singleton getInstance() {
        return SINGLETON;
    }
}
