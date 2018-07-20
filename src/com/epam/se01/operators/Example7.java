package com.epam.se01.operators;

import static java.lang.Math.*;

public class Example7 {

    // XOR
    //       true   false
    // true    -      +
    // false   +      -

    // AND
    //       true   false
    // true    +      -
    // false   -      -

    {
        System.out.println("Out of method");
    }

    public static void main(String[] args) {
        int value = 0;

        Object a = 5 > 6 ? "abc" : 5d;

        System.out.println((value > 0 ? "positive" : value < 0 ? "negative" : "zero") + " value");

        System.out.println(Integer.MAX_VALUE + 1 == Integer.MIN_VALUE);
        System.out.println(subtractExact(Integer.MIN_VALUE, 1));
        System.out.println(addExact(Integer.MAX_VALUE, 1));

        switch (1) {
            case 2: {

            }
            case 3: {

            }
        }

        {
            System.out.println(PI);
            double var = PI * PI + PI;
        }
    }
}
