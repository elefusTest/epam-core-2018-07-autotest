package com.epam.se02;

import java.util.Objects;

class Pen {

    private int price;
    private String producerName;

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

    public static void main(String[] args) {
        Pen pen = new Pen(50, "tmp");
        System.out.println(pen);
    }
}

