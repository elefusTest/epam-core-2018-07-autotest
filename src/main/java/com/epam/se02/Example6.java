package com.epam.se02;

public class Example6 {

    public static void main(String[] args) throws CloneNotSupportedException {
        B ref = new C();
//        ref.method();
//
//        Pen pen = new Pen(100, "producer");
//        Pen clone = (Pen) pen.clone();
//        System.out.println(pen == clone);
//        System.out.println(pen.equals(clone));
//
//        System.out.println(pen.getPrice() == clone.getPrice());
//        System.out.println(pen.getProducerName() == clone.getProducerName());


    }
}


class B {

    {
        System.out.println("Init in B");
    }

    public B() {
        super();
        System.out.println("Constuctor B");
    }

    void method() {
        System.out.println("Hello from B");
    }
}

class C extends B {

    {
        System.out.println("Init in C");
    }

    public C() {
        super();
        System.out.println("Consturctor C");
    }

    @Override
    public void method() {
        System.out.println("Hello from C");
    }
}
