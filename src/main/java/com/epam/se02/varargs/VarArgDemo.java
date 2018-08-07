package com.epam.se02.varargs;

public final class VarArgDemo {
//    public static void main(String... args) {
//        if(args.length == 0)
//            getString();
//        else {
//            System.out.println(args.length);
//            for (String arg : args) {
//                System.out.println(arg);
//            }
//        }
//    }

//    static void methodName(int... xs, char s) {} // error

    public static void main(String... __) {
        Integer[] i = { 1, 2, 3, 4, 5 };
        printArgCount(7, "No", true, null); // 1
        printArgCount(i, i, i); //2
        printArgCount(i, 4, 71); // 2? 3?
        printArgCount(i); // будет вызван метод 1
        // printArgCount(5, 7); //неопределенность, 1 или 3!

    }

    public static String getString() {
        main("rtyrsthzf", "aretgaerty", "sg", "dfag");

        return "";
    }

    public final void m(int x, String... args) {

    }

    public static void printArgCount(Object... args) { // 1
        System.out.println("Object args: " + args.length);
    }

    public static void printArgCount(Integer[]... args) { // 2
        System.out.println("Integer[] args: " + args.length);
    }

    public static void printArgCount(int... args) { // 3
        System.out.print("int args: " + +args.length);
    }

}
