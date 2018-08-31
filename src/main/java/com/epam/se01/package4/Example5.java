package com.epam.se01.package4;

public class Example5 {

    public static void main(String[] args) {
        int[] arr1 = new int[10];
        int[] arr2 = new int[]{1, 2, 3, 4};
        int[] arr3 = {1, 2, 3, 4};

        int[][] arr4 = new int[4][3];   // <- correct
        int[] arr5 [] = new int[4][3];
        int arr6 [][] = new int[4][3];

        // [2][0]
        //   0 1 2
        // 0
        // 1
        // 2 *
        // 3

        Number[] numbers = new Integer[10];
        Number[] numbers2 = new Integer[] {1, 2, 3, 4};
        Integer[] integers2 = (Integer[]) numbers2;
        System.out.println(integers2[0]);


        Number[] numbers3 = {1, 2, 3, 4};
        Integer[] integers3 = (Integer[]) numbers3;
        System.out.println(integers3[0]);
    }
}
