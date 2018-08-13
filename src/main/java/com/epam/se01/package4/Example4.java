package com.epam.se01.package4;

public class Example4 {


    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = new String("abc");

        System.out.println(str1.equals(str2));
        System.out.println(str1 == str2);
    }
}
