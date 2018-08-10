package com.epam.se01.memory;

public class Example4 {


    // HEAP
    // [HEADER | 10 | PADDING]
    // [HEADER | 11 | PADDING] <
    // [HEADER | 11 | PADDING]  |
    //                ^         |
    // STACK main     |         |
    // byteValue      |         |
    // anotherValue   |

    // HEAP
    //            [256] of Byte
    //              ||
    //              ||
    // STACK main   ||
    // byteValue    ||
    // anotherValue  |


    public static void main(String[] args) {
        Byte byteValue = 10;
        ++byteValue;

        Byte anotherValue = 11;

        System.out.println(byteValue == anotherValue);


        Integer a = 128;
        Integer b = 128;
        System.out.println(a.equals(b));
        System.out.println(b.equals(a));

        Integer integer = Integer.valueOf(50);
        Number number = integer;
        Number[] numbers = new Number[]{1, 5L, 5.0, 2.0F};
        System.out.println(numbers[0] instanceof Integer);
        System.out.println(numbers[1] instanceof Long);
        System.out.println(numbers[2] instanceof Float);
    }
}
