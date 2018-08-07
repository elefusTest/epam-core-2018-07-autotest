package com.epam.se01.package4;

import java.util.Arrays;

public class Example2 {

    public static void main(String[] args) {
        String str = "I like ";

        String[] arr = new String[]{ str };

        char a = 'a';
        String b = "a";
        System.out.println("Before: " + str);
        changeString(arr);
        System.out.println("After: " + arr[0]);
    }

    public static void changeString(String[] s) {
        System.out.println("	- before change: " + Arrays.toString(s));
        s[0] += " Java.";
        System.out.println("	- after change: " + Arrays.toString(s));
    }

//    public static void changeString(String s) {
//        System.out.println("	- before change: " + s);
//        s = s + " Java.";
//        System.out.println("	- after change: " + s);
//    }

}
