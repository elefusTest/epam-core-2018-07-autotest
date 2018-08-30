package com.epam.s06;

import com.epam.se02.varargs.VarArgDemo;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public final class MapExample {
    public static void main(String... __) {

        var stringIntegerHashMap = new HashMap<String, Integer>();

        stringIntegerHashMap.put("Smith", 30);
        stringIntegerHashMap.put("Anderson", 31);
        stringIntegerHashMap.put("Lewis", 29);
        stringIntegerHashMap.put("Cook", 29);

        System.out.println("Display entries in HashMap");
        System.out.println(stringIntegerHashMap);

        var stringIntegerTreeMap = new TreeMap<String, Integer>(stringIntegerHashMap);
        System.out.println("\nDisplay entries in ascending order of key");
        System.out.println(stringIntegerTreeMap);

        var stringIntegerLinkedHashMap = new LinkedHashMap<String, Integer>(
                16,
                0.75f,
                true);
        stringIntegerLinkedHashMap.put("Smith", 30);
        stringIntegerLinkedHashMap.put("Anderson", 31);
        stringIntegerLinkedHashMap.put("Lewis", 29);
        stringIntegerLinkedHashMap.put("Cook", 29);
        System.out.printf("\nThe age for Lewis is %d%n",
                stringIntegerLinkedHashMap.get("Lewis"));
        System.out.println(stringIntegerLinkedHashMap);
    }
}
