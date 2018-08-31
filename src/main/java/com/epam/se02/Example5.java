package com.epam.se02;

public class Example5 {

    private static final String VERSION = null;
    static {
        // 12.0-SNAPSHOT
//        String version = System.getProperty("version");
//        VERSION = version.substring(0, version.indexOf('-'));
        System.out.println("Static-1");
    }

    private static String parseVersionFromEnvironment() {
        String version = System.getProperty("version");
        return version.substring(0, version.indexOf('-'));
    }

    {
        System.out.println(this.stringField);
        System.out.println("1");
    }

    private int intField;
    private String stringField = "string";
    private final double doubleField;

    {
        doubleField = 6;
        System.out.println(stringField);
        System.out.println("2");
    }

    public Example5(int intField) {
        this.intField = intField;
//        doubleField = 5;
        System.out.println("Constructor");
    }

    {
//        doubleField = 5;
        System.out.println("3");
    }

    public static void main(String[] args) {
//        new Example5(1);
    }

    static {
        System.out.println("Static-2");
    }
}
