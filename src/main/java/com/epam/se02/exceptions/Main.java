package com.epam.se02.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("Lol exception was thrown!");
            }
        });
        method();
    }

    public static void method() {
        method2(new RuntimeException());
    }

    public static void method2(RuntimeException ex) {
        ex.printStackTrace(System.out);
        ex.fillInStackTrace();
        throw ex;
    }


    public static void example() {
        System.out.println("1");
        try {
            System.out.println("2");
            throw new FileNotFoundException();
        } catch (NumberFormatException | IOException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("5");
        }



    }
}
