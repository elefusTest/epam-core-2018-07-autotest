package com.epam.se02;

import java.util.concurrent.ThreadLocalRandom;

public class Mathematica {

    public Mathematica(Num obj) {} // 1

    public Mathematica(Int obj) {} // 2

    public Mathematica(Num obj1, Int obj2) {} // 3

    public Mathematica(Int obj1, Int obj2) {} // 4
}

class Num {}
class Int extends Num {}
class LongInt extends Int {}

class Launcher3 {

    public static void main(String[] args) {
        Num o1 = new Num();
        Int o2 = new Int();
        LongInt o3 = new LongInt();
        Num o4 = new Int();

//            Mathematica m1 = new Mathematica(o1);      // 1
//            Mathematica m2 = new Mathematica(o2);      // 2
//            Mathematica m3 = new Mathematica(o3);      // 2
//            Mathematica m4 = new Mathematica(o4);      // 1
//            Mathematica m5 = new Mathematica(o1, o2);  // 3
//            Mathematica m6 = new Mathematica(o3, o2);  // 4
//            Mathematica m7 = new Mathematica(o1, (Int)o4);
            Mathematica m8 = new Mathematica(o3, (Int)o4); // 4
    }

    private static Int createObject() {
        return ThreadLocalRandom.current().nextBoolean() ? new Int() : new LongInt();
    }
}
