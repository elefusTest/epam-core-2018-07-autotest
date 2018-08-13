package com.epam.se02.interfaces;

public class Circle implements Square {

    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public double square() {
        return radius * radius * Square.PI;
    }
}

