package com.epam.se02;

public class Example4 {

    public static void method() {
        System.out.println("Method from Example4");
    }
}

class Example4Child extends Example4 {

    public static void method() {
        System.out.println("Method from Example4Child");
    }
}

class Example4GrandChild extends Example4Child {

}


class Launcher5 {

    public static void main(String[] args) {
        Example4GrandChild ref = new Example4GrandChild();
        Example4.method();
        Example4GrandChild.method();


    }
}