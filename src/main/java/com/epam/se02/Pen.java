package com.epam.se02;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

class Pen implements Cloneable, Comparable<Pen> {

    private static final int SLEEP_INTERVAL = 24 * 60 * 60 * 1000;
    private int price;
    private String producerName;

    public Pen(Pen pen) {
        price = pen.price;
        producerName = pen.producerName;
    }

    public Pen(int price, String producerName) {
        this.price = price;
        this.producerName = producerName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pen pen = (Pen) o;
        return price == pen.price
            && Objects.equals(producerName, pen.producerName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, producerName);
    }

    @Override
    public String toString() {
        return "Pen{" +
                "price=" + price +
                ", producerName='" + producerName + '\'' +
                '}';
    }

    public int compareTo(Pen other) {
        return Integer.compare(price, other.price);
    }

    // FIXME не рекомендуется к использованию
//    @Override
//    protected void finalize() throws Throwable {
//        System.out.println(Thread.currentThread());
//        System.out.println("Called finalize of class Pen");
//    }


    @Override
    public Pen clone() throws CloneNotSupportedException {
        return (Pen) super.clone();
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProducerName() {
        return producerName;
    }

    public static void main(String[] args) {
        Pen pen1 = new Pen(50, "tmp");
        Pen pen2 = new Pen(50, "tmp");
        System.out.println(pen1.equals(pen2));
        System.out.println(pen1);

        int[] arr = new int[1_000_000];
        pen1 = null;
        pen2 = null;
        arr = null;
        System.gc();

        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String string = "This is " + pen1;
        System.out.println(string);
    }
}

