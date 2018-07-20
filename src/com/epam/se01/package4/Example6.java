package com.epam.se01.package4;

import java.util.Arrays;

public class Example6 {

    public static void main(String[] args) {
        int[] original = new int[]{1, 2, 3, 4, 5};

        int[] newArr1 = new int[original.length + 1];
        for (int i = 0; i < original.length; ++i) {
            newArr1[i] = original[i];
        }
        newArr1[newArr1.length - 1] = 6;

        int[] newArr2 = new int[original.length + 1];
        System.arraycopy(original, 0, newArr2, 0, original.length);
        newArr2[newArr2.length - 1] = 6;

        // best
        int[] newArr3 = Arrays.copyOf(original, original.length + 1);
        newArr3[newArr3.length - 1] = 6;
    }
}
