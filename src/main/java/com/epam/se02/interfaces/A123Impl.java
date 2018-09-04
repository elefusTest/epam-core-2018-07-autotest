package com.epam.se02.interfaces;

public final class A123Impl implements A123 {

    @Override
    public void m1() {
        //...
        System.out.println(m2());
    }

    @Override
    public int m2() {
        return A123.super.m2();
    }
}
