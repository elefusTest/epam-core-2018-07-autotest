package com.epam.se02;

public class Example3 {

    // T1 T3
    public void method(int value) {
        synchronized (this) {
            // T2
            System.out.println("int value");
        }
    } // T2


    // T4
    public synchronized void method(double value) {
        System.out.println("double value");
    }

    // T5 T6 T7
    public  static void method() {
        synchronized (Example3.class) {
            System.out.println("Method of Example4");
        }
    }
}

class Example3Child extends Example3 {

    public void method(String value) {
        System.out.println("float value");
    }
}

class Laucher4 {

    public static void main(String[] args) {
        Example3Child ref = new Example3Child();
         ref.method(5);
         ref.method(5.5);
         ref.method("123");

    }
}