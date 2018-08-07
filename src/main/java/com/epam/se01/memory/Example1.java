package com.epam.se01.memory;

public class Example1 {

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Double.MIN_VALUE);
        System.out.println(Double.MAX_VALUE);



        System.out.println(Runtime.getRuntime().totalMemory());



//        Thread.sleep(1_000_000);
        // byte     1    [-128...0...127]
        // short    2    -2^15..2^15 - 1
        // int      4    -2^31..3^31 - 1
        // long     8    -2^63..2^63 - 1

        // IEEE754
        // float    4
        // double   8

        // char     2    0..65535 2^16

        // boolean  ~    HotSpot [1]

        A ref = new A();
        System.out.println(ref.intValue);

        int val = 10;
        Integer wrapper = new Integer(val);
    }
}

class A {

    // header
    // 8  bytes (32-bit VM)
    // 12 bytes (64-bit VM)
    int intValue = 66;     // 4
    private short shortValue = 1;  // 2
    // padding                        6

}

// ~6~ bytes
// 24  bytes