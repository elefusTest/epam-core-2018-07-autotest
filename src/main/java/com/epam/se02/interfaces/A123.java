package com.epam.se02.interfaces;

public interface A123 {

    int x = 55;

    void m1();

    default int m2() {

        jhgasf();

        return 1;
    }

    default int m4() {
        jhgasf();

        return 5;
    }

    private void jhgasf() {
        //xyz
    }

    static void m3() {

    }

    static void main(String... __) {
        System.out.println(123);
    }
}
