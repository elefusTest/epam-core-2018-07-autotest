package com.epam.se02.interfaces;

import java.io.BufferedReader;
import java.io.IOException;

abstract class Z {

    public int method() {
        return -42;
    }

}

public class Y extends Z implements X {

    static void saySmth() {
        System.out.println("Hello");
    }

    /**
     *
     * @return
     * @throws RuntimeException
     */
    @Override
    public int method() throws RuntimeException {
        return X.super.method();
    }

    public static void main(String[] args) throws IOException {
        Y.saySmth();
        X.saySmth();

        Z z = new Z(){};
        System.out.println(z.getClass());
//        System.out.println(new Y().method());
        class B {
            int field;
        }

        B b = new B();
        b.field = 5;

        try (BufferedReader reader = new BufferedReader(null)) {
            System.out.println("132");
        }

    }
}
