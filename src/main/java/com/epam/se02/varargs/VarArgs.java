package com.epam.se02.varargs;

public final class VarArgs {

    public static int getArgCount(Integer... args) {
        if (args.length == 0) {
            System.out.print("No arg");
        }
        for (int i : args) {
            System.out.print("arg:" + i + "  ");
        }
        return args.length;
    }

    public static void getArgCount(Integer[]... args) {
        if (args.length == 0) {
            System.out.print("No arg2");
        }
        for (Integer[] mas : args) {
            for (int x : mas) {
                System.out.print("arg2:" + x + "  ");
            }
        }
    }

    public static void main(String... __) {
        System.out.println("N=" + getArgCount(7, 71, 555));
        Integer[] i = { 1, 2, 3, 4, 5, 6, 7 };
        System.out.println("N=" + getArgCount(i));
        getArgCount(i, i);
        //getArgCount(); //error
    }
}
