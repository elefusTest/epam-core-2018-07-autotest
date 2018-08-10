package com.epam.se02.interfaces;

public class Rectangle implements Square {

    private int width;
    private int height;

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public double square() {
        return width * height;
    }
}
