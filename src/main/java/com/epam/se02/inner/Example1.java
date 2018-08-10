package com.epam.se02.inner;

import java.io.Serializable;

public class Example1 {

    private static final int staticOuterField = 20;
    private int outerField;
    private int count = 20;

    class Inner extends Object implements Serializable {

        private static final int staticInnerField = 10;
        private int innerField;
        private int count = 10;

        public void method() {
            System.out.println(innerField);
            System.out.println(staticInnerField);
            System.out.println(outerField);
            System.out.println(staticOuterField);
            System.out.println(this.count);
            System.out.println(Example1.this.count);
        }
    }

    public void method() {
        System.out.println(outerField);
        System.out.println(staticOuterField);
        System.out.println(Inner.staticInnerField);
        Inner inner = new Inner();
        System.out.println(inner.innerField);

        class Inner2 {

            public void printFields() {
                System.out.println(outerField);
            }
        }
        Inner2 inner2 = new Inner2();
        inner2.printFields();
    }

    public void setOuterField(int outerField) {
        this.outerField = outerField;
    }
}


class Launcher {

    public static void main(String[] args) {
        Example1 example1 = new Example1();

        example1.setOuterField(1);

        Example1.Inner inner = example1.new Inner();
        inner.method();

        example1.setOuterField(2);
        inner.method();
    }
}
