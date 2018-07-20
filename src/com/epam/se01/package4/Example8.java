package com.epam.se01.package4;

public class Example8 {

    public static void main(String[] args) {
//        if (true) {
//            System.exit(1);
//        } else {
//            System.out.println("Hello");
//        }

        for (int element : method(1, 2)) {
            System.out.println(element);
        }
    }

    /**
     *
     * @param element0
     * @param element1
     * @return
     * @throws IllegalArgumentException Если <code>element0 < 0</code>
     * @throws IllegalAccessError
     */
    public static int[] method(int element0, int element1) throws IllegalArgumentException, IllegalAccessError {
        return new int[0];
//        return new int[]{element0, element1};
    }

    /**
     * Редактируема ли даннная ячейка.
     * @param column Номер колонки, в которой расположена ячейка.
     * @return true - ячейка редактируема, false - в противном случае.
     */
    public boolean isCellEditable(int column) {
        return column % 2 == 0;
    }

}






















