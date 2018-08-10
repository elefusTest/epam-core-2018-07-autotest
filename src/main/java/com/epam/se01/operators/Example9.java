package com.epam.se01.operators;

public class Example9 {

    public static void main(String[] args) {
        outer: for (int j = 0; j < 10; ++j) {
            for (int i = 0; i < 10; ++i) {
                if (i % 2 == 0) {
                    continue outer;
                }
                System.out.println(j + " " + i);
            }
        }

        outer2: for (int i = 10; i < 20; ++i) {

        }

        label: if (6 > 5) {
            System.out.println("Before");
            if (4 < 8) {
                break label;
            }
            System.out.println("After");
        }

        loop: for (int x = 0; x < 100; ++x) {
            for (int y = 0; y < 100; ++y) {
                for (int z = 0; z < 100; ++z) {
                    if (x + y + z > 5) {
                        break loop;
                    }
                }
            }
        }
    }
}
