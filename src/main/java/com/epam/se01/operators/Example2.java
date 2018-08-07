package com.epam.se01.operators;

public class Example2 {

    public static void main(String[] args) {
        int a = 10;
        byte b = (byte) 80;

        String str = "string";

        // HEAP
        // _50_


        // Stack
        // intVal
        // ref

        Integer intVal = new Integer(50);
        Object ref = intVal;
        if (ref instanceof String) {
            String str2 = ((String) ref);
        } else {
            System.out.println("It's not a string!");
        }

    }
}
