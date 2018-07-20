package com.epam.se01.memory;

public class Example3 {

    // HEAP
    // [HEADER | 20 | PADDING]
    //       ^^
    //       ||
    //       ||
    //       ||  STACK main
    // ref i ||
    //        |
    //        |
    //        |  STACK changeInteger
    // ref x  |

    public static void main(String[] args) {
        Integer i = 10;
        int val = i;
        System.out.println("i1=" + i);
        changeInteger(i);
        System.out.println("i2=" + i);
//
//        int i = 10;
//        System.out.println("i1=" + i);
//        changeInt(i);
//        System.out.println("i2=" + i);


        IntHolder holder = new IntHolder();
        holder.value = 10;
        System.out.println("i1=" + holder.value);
        changeIntHolder(holder);
        System.out.println("i2=" + holder.value);
    }

    public static void changeIntHolder(IntHolder x) {
        System.out.println("x1=" + x.value);
        x.value = 20;
        System.out.println("x2=" + x.value);
    }

    public static void changeInteger(Integer x) {
        System.out.println("x1=" + x);
        x = new Integer(20);
        System.out.println("x2=" + x);
    }

    public static void changeInt(int x) {
        System.out.println("x1=" + x);
        x = 20;
        System.out.println("x2=" + x);
    }

}

class IntHolder {

    int value;
}
