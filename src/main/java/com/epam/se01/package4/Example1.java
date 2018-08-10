package com.epam.se01.package4;

public class Example1 {

    public final IntHolder holder = new IntHolder(60);

    public Example1() {
//        holder = null;
//        holder = new IntHolder();
        holder.setValue(50);

        holder.setValue(40);
//        value = 50;
    }
}


class IntHolder {

    private int value;

    public IntHolder(int value) {
        this.value = value;
    }

    public IntHolder() {
        value = 70;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Negative value");
        }
        this.value = value;
    }
}
