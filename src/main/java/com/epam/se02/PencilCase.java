package com.epam.se02;

import java.util.Objects;

public class PencilCase implements Cloneable {

    // FIXME ломает метод clone
//    private final Pen[] pens;
    private Pen[] pens;
    private int current = 0;

    // Конструктор копирования
    public PencilCase(PencilCase pencilCase) {
        current = pencilCase.current;
        pens = new Pen[pencilCase.pens.length];
        for (int i = 0; i < pens.length; ++i) {
            try {
                pens[i] = pencilCase.pens[i].clone();
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
    }

    public PencilCase(int size) {
        pens = new Pen[size];
    }

    public void add(Pen pen) {
        pens[current++] = pen;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        PencilCase clone = (PencilCase) super.clone();
        int numberPens = clone.pens.length;
        Pen[] clonePens = new Pen[numberPens];
        for (int i = 0; i < numberPens; ++i) {
            clonePens[i] = clone.getPens()[i].clone();
        }
        clone.pens = clonePens;
        return clone;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof PencilCase)) {
            return false;
        }
        PencilCase other = (PencilCase) obj;
        return Objects.deepEquals(pens, other.pens);
    }

    public Pen[] getPens() {
        return pens;
    }
}


class Launcher4 {

    public static void main(String[] args) throws CloneNotSupportedException {
        PencilCase pencilCase = new PencilCase(3);
        pencilCase.add(new Pen(1, "a"));
        pencilCase.add(new Pen(2, "b"));
        pencilCase.add(new Pen(3, "c"));

        PencilCase clone = (PencilCase) pencilCase.clone();
        System.out.println(pencilCase == clone);
        System.out.println(pencilCase.equals(clone));

        clone.getPens()[0].setPrice(5);
        System.out.println(clone.getPens()[0].getPrice());
        System.out.println(pencilCase.getPens()[0].getPrice());
    }
}