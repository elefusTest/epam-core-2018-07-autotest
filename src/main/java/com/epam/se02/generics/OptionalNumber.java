package com.epam.se02.generics;

import java.io.Serializable;

public class OptionalNumber<T extends Number & Comparable<T> & Serializable & Cloneable> {

    private T value;

    public OptionalNumber() {
    }

    public OptionalNumber(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T val) {
        value = val;
    }

    @Override
    public String toString() {
        if (value == null) return null;
        return value.getClass().getName() + " " + value;
    }
}

class Launcher {

    public static void main(String[] args) {
        OptionalNumber<CloneableInteger> optional1 = new OptionalNumber<>();

    }
}

class CloneableInteger extends Number implements Serializable, Cloneable, Comparable<CloneableInteger> {

    @Override
    public int compareTo(CloneableInteger o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int intValue() {
        throw new UnsupportedOperationException();
    }

    @Override
    public long longValue() {
        throw new UnsupportedOperationException();
    }

    @Override
    public float floatValue() {
        throw new UnsupportedOperationException();
    }

    @Override
    public double doubleValue() {
        throw new UnsupportedOperationException();
    }
}