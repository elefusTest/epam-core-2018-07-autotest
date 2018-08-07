package com.epam.se02.interfaces;

public class Quadrate implements Square {

    private int width;

    public Quadrate(int width) {
        this.width = width;
    }

    @Override
    public double square() {
        return width * width;
    }
}

