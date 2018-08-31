package com.epam.se01.visibility.subpackage1;

import com.epam.se01.visibility.A;

public class B {

    public static void main(String[] args) {
        System.out.println(new A().publicField);
        System.out.println(new A().publicField);
    }
}
