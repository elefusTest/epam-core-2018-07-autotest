package com.epam.se03;

public final class Other {
    static String hello = "Hello";

    public static void main(String... __) {
        String s1 = "Hello";
        String s2 = new StringBuffer("He").append("llo").toString();
        String s3 = s2.intern();

        System.out.println("s1 == s2? " + (s1 == s2)); // false
        System.out.println("s1 == s3? " + (s1 == s3)); // true

        String hello = "Hello",
                lo = "lo";

        System.out.print((hello == "Hello") + " "); // true
        System.out.print((Other.hello == hello) + " "); // true
        System.out.print((com.epam.se03.otherpack.Other.hello == hello) + " "); // true
        System.out.print((hello == ("Hel" + "lo")) + " "); // true
        System.out.print((hello == ("Hel" + lo)) + " "); // false
        System.out.println(hello == ("Hel" + lo).intern()); // true


//        "12345678910"
        StringBuilder s = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
//            s += i;
            s.append(i);
        }
        System.out.println(s.toString());
    }
}
